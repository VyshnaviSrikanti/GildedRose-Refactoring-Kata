package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
    private static final String BRIE = "Aged Brie";
    private static final String PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    // TASK-13: everyday decay and the expiry boundary.
    @ParameterizedTest
    @CsvSource({"2,10,1,9", "1,10,0,9", "0,10,-1,8", "-1,10,-2,8"})
    void ordinaryItemsAgeAndDegrade(int days, int quality, int nextDays, int nextQuality) {
        assertUpdate("Elixir of the Mongoose", days, quality, nextDays, nextQuality);
    }

    // TASK-14: lower bound, including an expired item with one quality point.
    @ParameterizedTest
    @CsvSource({"1,0", "0,0", "-1,0", "0,1", "-1,1"})
    void ordinaryQualityNeverBecomesNegative(int days, int quality) {
        assertUpdate("ordinary", days, quality, days - 1, 0);
    }

    // TASK-15: +2 after expiry is characterized from the working legacy code.
    @ParameterizedTest
    @CsvSource({"1,10,11", "0,10,12", "-1,10,12", "1,0,1"})
    void brieImprovesWithAge(int days, int quality, int expected) {
        assertUpdate(BRIE, days, quality, days - 1, expected);
    }

    // TASK-16
    @ParameterizedTest
    @CsvSource({"1,49", "1,50", "0,48", "0,49", "0,50", "-1,49", "-1,50"})
    void brieQualityStopsAtFifty(int days, int quality) {
        assertUpdate(BRIE, days, quality, days - 1, 50);
    }

    // TASK-17
    @ParameterizedTest
    @CsvSource({"1", "0", "-1"})
    void sulfurasNeverChanges(int days) {
        assertUpdate(SULFURAS, days, 80, days, 80);
    }

    // TASK-18: values on each side of both concert thresholds.
    @ParameterizedTest
    @CsvSource({"12,21", "11,21", "10,22", "9,22", "6,22", "5,23", "4,23", "1,23"})
    void passesImproveFasterAsConcertApproaches(int days, int expected) {
        assertUpdate(PASSES, days, 20, days - 1, expected);
    }

    // TASK-19
    @ParameterizedTest
    @CsvSource({"11,49", "11,50", "10,49", "10,50", "5,48", "5,49", "5,50", "1,49"})
    void passesQualityStopsAtFifty(int days, int quality) {
        assertUpdate(PASSES, days, quality, days - 1, 50);
    }

    // TASK-20
    @ParameterizedTest
    @CsvSource({"0,0", "0,20", "0,50", "-1,20", "-1,50"})
    void passesBecomeWorthlessAfterConcert(int days, int quality) {
        assertUpdate(PASSES, days, quality, days - 1, 0);
    }

    // TASK-21
    @Test
    void preservesNamesAndUpdatesOriginalItemsAndArray() {
        Item item = new Item("unknown item", 2, 10);
        Item[] inventory = {item};
        GildedRose shop = new GildedRose(inventory);
        shop.updateQuality();
        assertAll(() -> assertSame(inventory, shop.items),
            () -> assertSame(item, inventory[0]),
            () -> assertEquals("unknown item", item.name),
            () -> assertEquals(1, item.sellIn),
            () -> assertEquals(9, item.quality));
    }

    // TASK-22: multiple days cross expiry and both pass thresholds.
    @Test
    void updatesMixedInventoryAcrossSeveralDays() {
        Item ordinary = new Item("ordinary", 1, 10);
        Item brie = new Item(BRIE, 1, 48);
        Item passes = new Item(PASSES, 11, 0);
        Item sulfuras = new Item(SULFURAS, 0, 80);
        GildedRose shop = new GildedRose(new Item[]{ordinary, brie, passes, sulfuras});
        for (int day = 0; day < 11; day++) shop.updateQuality();
        assertAll(() -> assertEquals(-10, ordinary.sellIn),
            () -> assertEquals(0, ordinary.quality),
            () -> assertEquals(50, brie.quality),
            () -> assertEquals(0, passes.sellIn),
            () -> assertEquals(26, passes.quality),
            () -> assertEquals(0, sulfuras.sellIn),
            () -> assertEquals(80, sulfuras.quality));
        shop.updateQuality();
        assertEquals(0, passes.quality);
    }

    @Test
    void acceptsEmptyInventory() {
        assertDoesNotThrow(() -> new GildedRose(new Item[0]).updateQuality());
    }

    // TASK-9/TASK-10: the new feature is separate from legacy characterization.
    @ParameterizedTest
    @CsvSource({"1,10,8", "0,10,6", "-1,10,6", "1,1,0", "0,3,0", "0,4,0", "1,0,0", "0,0,0"})
    void conjuredItemsDegradeTwiceAsFast(int days, int quality, int expected) {
        assertUpdate("Conjured Mana Cake", days, quality, days - 1, expected);
    }

    @ParameterizedTest
    @CsvSource({"Conjured,8", "Conjured Elixir,8", "Conjuredness,9", "conjured Mana Cake,9"})
    void conjuredClassificationUsesAnExplicitNameBoundary(String name, int expected) {
        assertUpdate(name, 1, 10, 0, expected);
    }

    @Test
    void conjuredItemsAgeOncePerDayInAMixedInventory() {
        Item ordinary = new Item("ordinary", 1, 10);
        Item conjured = new Item("Conjured Mana Cake", 1, 10);
        GildedRose shop = new GildedRose(new Item[]{ordinary, conjured});
        for (int day = 0; day < 3; day++) shop.updateQuality();
        assertAll(() -> assertEquals(-2, ordinary.sellIn),
            () -> assertEquals(-2, conjured.sellIn),
            () -> assertEquals(5, ordinary.quality),
            () -> assertEquals(0, conjured.quality));
    }

    private void assertUpdate(String name, int days, int quality, int nextDays, int nextQuality) {
        Item item = new Item(name, days, quality);
        new GildedRose(new Item[]{item}).updateQuality();
        assertAll(() -> assertEquals(name, item.name),
            () -> assertEquals(nextDays, item.sellIn, "sellIn"),
            () -> assertEquals(nextQuality, item.quality, "quality"));
    }
}
