package gildedRose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void UpdateEachItem(GildedRose gildedRose) {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }
        if(name.equals("Aged Brie")){
            addBackstageQuality();
            if(sellIn < 0)
                increaseQualityIfQualityLessThanFifty();
        }else{
            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                addBackstageQuality();
                if(sellIn < 0)
                    quality = 0;
            } else {
                NoSulfurasIncreaseQuality();
                if(sellIn < 0)
                    NoSulfurasIncreaseQuality();
            }
        }
//        if (sellIn < 0) {
//            if (name.equals("Aged Brie")) {
//                increaseQualityIfQualityLessThanFifty();
//            } else {
//                if(name.equals("Backstage passes to a TAFKAL80ETC concert")){
//                    quality = 0;
//                }else{
//                    NoSulfurasIncreaseQuality();
//                }
//            }
//        }
    }

    private void NoSulfurasIncreaseQuality() {
        if (quality > 0 && !name.equals("Sulfuras, Hand of Ragnaros")) {
            quality = quality - 1;
        }
    }

    private void addBackstageQuality() {
        if (quality < 50) {
            quality = quality + 1;

            if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn < 11) {
                    increaseQualityIfQualityLessThanFifty();
                }
                if (sellIn < 6) {
                    increaseQualityIfQualityLessThanFifty();
                }
            }
        }
    }

    public void increaseQualityIfQualityLessThanFifty() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }
}
