package com.generaltest.nevien.generaltests.callback;

import com.generaltest.nevien.generaltests.model.Item;

import java.util.List;

/**
 * Created by Nevien on 21/06/17.
 */

public interface OnJsonParsedListener {
    void onParsed(List<String> section, List<Item> items);
}
