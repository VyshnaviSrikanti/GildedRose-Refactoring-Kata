package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final int MAX_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        switch (item.name) {
            case SULFURAS:
                return;
            case AGED_BRIE:
                updateBrie(item);
                break;
            case BACKSTAGE_PASSES:
                updateBackstagePass(item);
                break;
            default:
                int dailyDecay = isConjured(item.name) ? 2 : 1;
                updateDegradingItem(item, dailyDecay);
        }
    }

    private void updateBrie(Item item) {
        increaseQuality(item);
        item.sellIn--;
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePass(Item item) {
        increaseQuality(item);
        if (item.sellIn <= 10) {
            increaseQuality(item);
        }
        if (item.sellIn <= 5) {
            increaseQuality(item);
        }
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private boolean isConjured(String name) {
        return name.equals("Conjured") || name.startsWith("Conjured ");
    }

    private void updateDegradingItem(Item item, int dailyDecay) {
        decreaseQuality(item, dailyDecay);
        item.sellIn--;
        if (item.sellIn < 0) {
            decreaseQuality(item, dailyDecay);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item, int amount) {
        if (item.quality > 0) {
            item.quality = Math.max(0, item.quality - amount);
        }
    }
}
