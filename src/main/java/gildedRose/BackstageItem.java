package gildedRose;

public class BackstageItem implements SellItem {

    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.increaseQualityIfQualityLessThanFifty();
        if (item.getQuality() < 50) {
            if (item.getSellIn() < 11) {
                item.increaseQualityIfQualityLessThanFifty();
            }
            if (item.getSellIn() < 6) {
                item.increaseQualityIfQualityLessThanFifty();
            }
        }
        if(item.getSellIn() < 0)
            item.setQuality(0);
    }
}
