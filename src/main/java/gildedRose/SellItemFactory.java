package gildedRose;

public class SellItemFactory {
    private final static String AGED_BRIE = "Aged Brie";
    private final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final static String CONJURED = "CONJURED";

    public static SellItem createSellItemByName(String name){
        SellItem sellItem;
        switch (name){
            case AGED_BRIE:
                sellItem = new AgedItem();
                break;
            case BACKSTAGE_PASSES:
                sellItem = new BackstageItem();
                break;
            case SULFURAS :
                sellItem = new SulfurasItem();
                break;
            case CONJURED :
                sellItem = new ConjuredItem();
                break;
            default:
                sellItem = new NormalItem();
        }

        return sellItem;
    }
}
