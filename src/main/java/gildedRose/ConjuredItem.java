package gildedRose;

public class ConjuredItem implements SellItem{
    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        item.saleDecreaseQuality();
        item.saleDecreaseQuality();
        if(item.getSellIn() < 0){
            item.saleDecreaseQuality();
            item.saleDecreaseQuality();
        }
    }
}
