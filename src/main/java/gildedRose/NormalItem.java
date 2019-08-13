package gildedRose;

public class NormalItem implements SellItem {

    @Override
    public void updateQuality(Item item) {
        item.decreaseSellIn();
        if(item.getQuality() > 0)
            item.decreaseQuality();
        if(item.getSellIn() < 0)
            item.decreaseQuality();
    }
}
