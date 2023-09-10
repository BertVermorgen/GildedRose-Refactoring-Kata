package com.gildedrose.item;

public class BackstagePasses implements UpdateableItem {
    private Item item;
    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.quality++;
        if (item.sellIn < 11) {
            item.quality++;
        }
        if (item.sellIn < 6) {
            item.quality++;
        }
        if (item.sellIn <= 0) {
            item.quality = 0;
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
