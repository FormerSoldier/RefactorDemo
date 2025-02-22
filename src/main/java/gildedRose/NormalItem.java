package gildedRose;

public class NormalItem implements SellItem {

    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.saleDecreaseQuality();
        if(item.getSellIn() < 0)
            item.saleDecreaseQuality();
    }
}
