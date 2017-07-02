package com.generaltest.nevien.generaltests.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.generaltest.nevien.generaltests.R;
import com.generaltest.nevien.generaltests.model.Item;
import com.generaltest.nevien.generaltests.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Nevien on 6/21/2017.
 */

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesHolder> {

    private List<Item> list;
    private Context mContext;

    public TopStoriesAdapter(List<Item> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public TopStoriesAdapter.TopStoriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TopStoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(TopStoriesHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.publish.setText(list.get(position).getPublish());
        Picasso.with(mContext).load(list.get(position).getUrl())
                .placeholder(R.drawable.progress_placeholder)
                .error(R.drawable.failed)
                .transform(new CircleTransform())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TopStoriesHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView publish;

        public TopStoriesHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_img);
            title = (TextView) itemView.findViewById(R.id.item_title_TV);
            publish = (TextView) itemView.findViewById(R.id.item_publish_TV);
        }
    }
}
