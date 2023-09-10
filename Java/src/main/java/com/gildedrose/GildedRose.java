package com.gildedrose;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemMapper;
import com.gildedrose.item.UpdateableItem;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        var mappedItems = ItemMapper.mapItemsToType(items);
        for (var mappedItem : mappedItems) {
            if (mappedItem instanceof UpdateableItem) {
                ((UpdateableItem) mappedItem).updateQuality();
                ((UpdateableItem) mappedItem).updateSellIn();
            }
        }
    }
}
