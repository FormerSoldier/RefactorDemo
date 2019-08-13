package gildedRose;

public class AgedItem implements SellItem {

    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.increaseQualityIfQualityLessThanFifty();
        if (item.getSellIn() < 0)
            item.increaseQualityIfQualityLessThanFifty();
    }
}
