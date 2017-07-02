package com.generaltest.nevien.generaltests.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.generaltest.nevien.generaltests.R;
import com.generaltest.nevien.generaltests.adapter.TopStoriesAdapter;
import com.generaltest.nevien.generaltests.api.NyTimes;
import com.generaltest.nevien.generaltests.callback.OnStoriesRetrieveListener;
import com.generaltest.nevien.generaltests.database.SharedPreferenceHelper;
import com.generaltest.nevien.generaltests.model.Item;
import com.generaltest.nevien.generaltests.util.JsonParser;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerCategories;
    private RecyclerView recyclerItem;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        setUpUI();
    }

    private void initUI() {
        spinnerCategories = (Spinner) findViewById(R.id.categories_spinner);
        recyclerItem = (RecyclerView) findViewById(R.id.recycler_items);
        mLayoutManager = new LinearLayoutManager(this);

    }

    private void setUpUI() {
        recyclerItem.setLayoutManager(mLayoutManager);

        if (SharedPreferenceHelper.getInstance().getSections() == null) {
            retrieveItemsFromApi();
        } else {
            initSpinner();
        }
    }

    private void retrieveItemsFromApi() {
        NyTimes.retrieveTopStories(new OnStoriesRetrieveListener() {
            @Override
            public void onStoriesRetrieved(JSONObject jsonObject) {
                JsonParser.parseAndCache(jsonObject, MainActivity.this);
                initSpinner();

            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initSpinner() {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, SharedPreferenceHelper.getInstance().getSections());
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategories.setAdapter(dataAdapter);
        spinnerCategories.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedCategory = spinnerCategories.getSelectedItem().toString();
        updateItemsRecyclerWithCategory(selectedCategory);
    }

    private void updateItemsRecyclerWithCategory(String selectedCategory) {
        List<Item> allItems = SharedPreferenceHelper.getInstance().getItems();
        List<Item> categoryItems = new ArrayList<>();

        if (allItems != null) {
            for (Item item : allItems) {
                if (item.getSection().equals(selectedCategory))
                    categoryItems.add(item);
            }
        }

        recyclerItem.setAdapter(new TopStoriesAdapter(categoryItems, this));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
