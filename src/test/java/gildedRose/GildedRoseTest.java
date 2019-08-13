package gildedRose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    private final String NORMAL = "NORMAL";
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String CONJURED = "CONJURED";

    GildedRose gildedRose = new GildedRose(null);
    Item[] items = new Item[1];


    @Test
    public void should_decrease_sellIn_when_call_updateQuality_given_NORMAL_has_two_sellIn_and_zero_quality(){
        givenAnItemToGildedRose(new Item(NORMAL,2,0));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,0);
    }

    @Test
    public void should_decrease_sellIn_and_quality_when_call_updateQuality_given_NORMAL_has_two_sellIn_and_two_quality(){
        givenAnItemToGildedRose(new Item(NORMAL,2,2));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,1);
    }

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

    @Test
    public void should_decrease_sellIn_and_increase_quality_when_call_updateQuality_given_AGRD_item_has_two_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(AGED_BRIE,2,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,41);
    }

    @Test
    public void should_decrease_sellIn_and_increase_three_quality_when_call_updateQuality_given_BACKSTAGE_has_less_than_five_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(BACKSTAGE_PASSES,4,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(3,43);
    }

    @Test
    public void should_decrease_sellIn_and_increase_two_quality_when_call_updateQuality_given_BACKSTAGE_has_beyond_five_and_less_than_ten_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(BACKSTAGE_PASSES,7,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(6,42);
    }

    @Test
    public void should_decrease_sellIn_and_increase_quality_when_call_updateQuality_given_BACKSTAGE_has_beyond_ten_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(BACKSTAGE_PASSES,12,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(11,41);
    }

    @Test
    public void should_decrease_sellIn_and_zero_quality_when_call_updateQuality_given_BACKSTAGE_has_zero_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(BACKSTAGE_PASSES,0,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(-1,0);
    }

    @Test
    public void should_decrease_sellIn_and_zero_quality_when_call_updateQuality_given_AGED_has_zero_sellIn_and_less_than_fifty_quality(){
        givenAnItemToGildedRose(new Item(AGED_BRIE,0,40));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(-1,42);
    }

    @Test
    public void should_decrease_sellIn_when_call_updateQuality_given_CONJURED_has_two_sellIn_and_zero_quality(){
        givenAnItemToGildedRose(new Item(CONJURED,2,0));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,0);
    }
    @Test
    public void should_decrease_sellIn_and_two_quality_when_call_updateQuality_given_CONJURED_has_two_sellIn_and_eight_quality(){
        givenAnItemToGildedRose(new Item(CONJURED,2,8));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(1,6);
    }

    @Test
    public void should_decrease_sellIn_and_four_quality_when_call_updateQuality_given_CONJURED_has_zero_sellIn_and_eight_quality(){
        givenAnItemToGildedRose(new Item(CONJURED,0,8));
        assertAnItemSellInAndQualityWhenCallUpdateQuality(-1,4);
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
