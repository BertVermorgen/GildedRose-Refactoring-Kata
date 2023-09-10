package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }


    @Test
    void allNonConjuredItemsQualityAndSellInDaysAreLoweredDaily() {
        var items = getNonConjuredItems().toArray(new Item[0]);
        var originalItems = getNonConjuredItems();
        var app = new GildedRose(items);
        for (var i = 0; i < 50; i++) {
            app.updateQuality();
            var count = 0;
            for (var item : items) {
                var originalItem = originalItems.get(count);
                var qualityToTest = originalItem.quality - 1;
                var sellInToTest = originalItem.sellIn - 1;
                if (item.sellIn < 0) {
                    qualityToTest = originalItem.quality - 2;
                }
                if (qualityToTest < 0) {
                    qualityToTest = 0;
                }
                if (item.name.startsWith("Backstage passes")) {
                    qualityToTest = originalItem.quality + 1;
                    if (originalItem.sellIn <= 10 && originalItem.sellIn > 5) {
                        qualityToTest = originalItem.quality + 2;
                    } else if (originalItem.sellIn <= 5 && originalItem.sellIn > 0) {
                        qualityToTest = originalItem.quality + 3;
                    } else if (item.sellIn < 0) {
                        qualityToTest = 0;
                    }
                }
                if (item.name.startsWith("Aged Brie")) {
                    qualityToTest = originalItem.quality + 1;
                    if (item.sellIn < 0) {
                        qualityToTest = qualityToTest + 1;
                    }
                }
                if (item.name.startsWith("Sulfuras")) {
                    qualityToTest = originalItem.quality;
                    sellInToTest = originalItem.sellIn;
                } else if (qualityToTest > 50) {
                    qualityToTest = 50;
                }
                System.out.println(item + " (i) " + originalItem + " (o) " + sellInToTest + " " + qualityToTest);
                assertEquals(item.quality, qualityToTest);
                assertEquals(item.sellIn, sellInToTest);
                originalItem.quality = qualityToTest;
                originalItem.sellIn = sellInToTest;
                count++;
            }
        }
    }

    @Test
    void conjuredItemsDegradeTwiceAsFast() {
        var items = List.of(new Item("Conjured Mana Cake", 3, 6)).toArray(new Item[0]);
        var app = new GildedRose(items);
        app.updateQuality();
        assertEquals(items[0].quality, 4);
        assertEquals(items[0].sellIn, 2);
    }

    public List<Item> getNonConjuredItems() {
        return List.of(
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        );
    }
}
