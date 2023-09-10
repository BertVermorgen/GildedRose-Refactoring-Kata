package com.gildedrose.item;

public class AgedBrie implements UpdateableItem {
    private Item item;
    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.quality++;
        if (item.sellIn <= 0) {
            item.quality++;
        }
        if (item.quality > 50) {
            item.quality = 50;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
