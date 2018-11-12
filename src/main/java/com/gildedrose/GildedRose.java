package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
// on réduit la qualité de 1 SI le nom est différent de Aged Brie & Backstage passes to a TAFKAL80ETC concert
// & Sulfuras, Hand of Ragnaros ET que la qualité est supérieure à 0
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
// on l'augmente de 1 si le nom est égal à Aged Brie OU Backstage passes to a TAFKAL80ETC concert
//ET la qualité est inférieur à 50

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
// on l'augmente de 1 si el nom est égal à Backstage etc..
//ET que Sellin < 11 et qualité < 50
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
// on l'augmente de 1 si el nom est égal à Backstage etc..
//ET que Sellin < 6 et qualité < 50
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) { // Si nom différend de Sulfuras
                items[i].sellIn = items[i].sellIn - 1; // on réduit de 1 le Sellin
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
// on réduit la qualité de 1 si le Sellin est négatif, que le nom est différent de Aged Brie
//& Backstage etc.. & Sulfuras ET que la qualité est supérieure à 0
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
// on met la qualité à 0 si le Sellin est négatif ET que le nom est égal à Backstage etc..

                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
// Si la qualité est inférieur à 50 ET nom égal Aged Brie on l'augmente de 1
                    }
                }
            }
        }
    }
}