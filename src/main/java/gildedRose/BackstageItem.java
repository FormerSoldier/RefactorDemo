package gildedRose;

public class BackstageItem implements SellItem {

    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.increaseQualityIfQualityLessThanFifty();
        if (item.getQuality() < Item.UpperLimit) {
            if (item.getSellIn() < 10) {
                item.increaseQualityIfQualityLessThanFifty();
            }
            if (item.getSellIn() < 5) {
                item.increaseQualityIfQualityLessThanFifty();
            }
        }
        if(item.getSellIn() < 0)
            item.setQuality(0);
    }
}
