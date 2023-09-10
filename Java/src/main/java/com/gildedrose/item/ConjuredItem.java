package com.gildedrose.item;

public class ConjuredItem implements UpdateableItem {
    private Item item;
    public ConjuredItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.quality -= 2;
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
