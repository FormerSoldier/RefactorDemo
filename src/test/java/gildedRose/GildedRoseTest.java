package gildedRose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    private final String MISMATCH = "MISMATCH";
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    GildedRose gildedRose = new GildedRose(null);
    Item[] items = new Item[1];

    @Test
    public void should_nothing_change_when_call_updateQuality_given_SULFURAS(){
        givenAnItemToGildedRose(new Item(SULFURAS,1,1));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,1);
    }

    @Test
    public void should_decrease_sellIn_when_call_updateQuality_given_AGRD_item_has_one_sellIn_and_beyond_fifty_quality(){
        givenAnItemToGildedRose(new Item(AGED_BRIE,1,51));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(0,51);
    }


    private void givenAnItemToGildedRose(Item item){
        items[0] = item;
        gildedRose.items = items;
    }
    private void assertAnItemSellInAndQualityWhenCallUpdateQuality(int sellIn, int quality){
        gildedRose.updateQuality();
        Item item = gildedRose.items[0];
        Assert.assertEquals(sellIn,item.sellIn);
        Assert.assertEquals(quality,item.quality);
    }

}
