package gildedRose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    private SellItem sellItem;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;

        switch (name){
            case "Aged Brie" :
                sellItem = new AgedItem();
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                sellItem = new BackstageItem();
                break;
            case "Sulfuras, Hand of Ragnaros":
                sellItem = new SulfurasItem();
                break;
            default:
                sellItem = new NormalItem();
        }

    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void UpdateEachItem(GildedRose gildedRose) {
        sellItem.updateQuality(this);
//        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
//            sellIn = sellIn - 1;
//        }
//        if(name.equals("Aged Brie")) {
//            increaseQualityIfQualityLessThanFifty();
//            if (sellIn < 0)
//                increaseQualityIfQualityLessThanFifty();
//        }else if(name.equals("Backstage passes to a TAFKAL80ETC concert")){
//            increaseQualityIfQualityLessThanFifty();
//            if (quality < 50) {
//                if (sellIn < 11) {
//                    increaseQualityIfQualityLessThanFifty();
//                }
//                if (sellIn < 6) {
//                    increaseQualityIfQualityLessThanFifty();
//                }
//            }
//            if(sellIn < 0)
//                quality = 0;
//        }else{
//            if (quality > 0 && !name.equals("Sulfuras, Hand of Ragnaros")) {
//                quality = quality - 1;
//                if(sellIn < 0)
//                    quality = quality - 1;
//            }
//        }
    }
    public void increaseQualityIfQualityLessThanFifty() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    public void decreaseSellIn(){
        sellIn = sellIn - 1;
    }
    public void decreaseQuality(){
        quality = quality - 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
