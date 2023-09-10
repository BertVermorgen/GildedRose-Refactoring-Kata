package com.gildedrose.item;

public class RegularItem implements UpdateableItem {
    private Item item;
    public RegularItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        item.quality -= 1;
        if( item.sellIn <= 0) {
            item.quality--;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    @Override
    public void updateSellIn() {
        this.item.sellIn--;
    }
}
