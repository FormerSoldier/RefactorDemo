package gildedRose;

public class Item {

    public static int UpperLimit = 50;

    public String name;

    public int sellIn;

    public int quality;

    private SellItem sellItem;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;

        sellItem = SellItemFactory.createSellItemByName(name);
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void UpdateEachItem() {
        sellItem.updateQuality(this);
    }
    public void increaseQualityIfQualityLessThanFifty() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    public void decreaseSellIn(){
        sellIn -= 1;
    }
    public void saleDecreaseQuality(){
        if (quality > 0)
            quality -= 1;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
