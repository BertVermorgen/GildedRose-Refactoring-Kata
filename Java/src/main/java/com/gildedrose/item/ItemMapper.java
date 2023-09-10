package com.gildedrose.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemMapper {
    public static List<InventoryItem> mapItemsToType(Item[] items) {
        var mappedItems = new ArrayList<InventoryItem>();
        for (var item : items) {
            if (item.name.toLowerCase().startsWith("sulfuras")) {
                mappedItems.add(new Sulfuras(item));
            } else if (item.name.toLowerCase().startsWith("aged brie")) {
                mappedItems.add(new AgedBrie(item));
            } else if (item.name.toLowerCase().startsWith("backstage passes")) {
                mappedItems.add(new BackstagePasses(item));
            } else if (item.name.toLowerCase().startsWith("conjured")) {
                mappedItems.add(new ConjuredItem(item));
            } else {
                mappedItems.add(new RegularItem(item));
            }
        };
        return mappedItems;
    }
}


/* new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };*/
