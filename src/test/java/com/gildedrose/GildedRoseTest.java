package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {


    // NOM GENERIQUE
    @Test
    public void should_return_inputQuality_minus_1_and_inputSellIn_minus_1_if_inputQuality_more_than_0_and_inputSellIn_more_than_0_and_inputName_is_not_AgedBrie_or_SulfurasHandOfRagnaros_or_BackstagePassesToATAFKAL80ETCConcert(){

//GIVEN
        Item[] input = {new Item("Conjured Mana Cake", 3, 6)};
        GildedRose gildedRose = new GildedRose(input);

//WHEN
        gildedRose.updateQuality();
        int sellIn_Result = 2;
        int quality_Result = 5;


//THEN
        assertEquals(sellIn_Result,gildedRose.items[0].sellIn );
        assertEquals(quality_Result,gildedRose.items[0].quality );
    }

    @Test
    public void should_return_inputQuality_and_inputSellIn_minus_1_if_inputQuality_less_than_0_and_inputName_is_not_AgedBrie_or_SulfurasHandOfRagnaros_or_BackstagePassesToATAFKAL80ETCConcert(){

//GIVEN
        Item[] input = {new Item("+5 Dexterity Vest", 10, -1)};
        GildedRose gildedRose = new GildedRose(input);

//WHEN
        gildedRose.updateQuality();
        int sellIn_Result = 9;
        int quality_Result = -1;


//THEN
        assertEquals(sellIn_Result,gildedRose.items[0].sellIn );
        assertEquals(quality_Result,gildedRose.items[0].quality );
    }

    @Test
    public void should_return_inputQuality_minus_2_and_inputSellIn_minus_1_if_inputQuality_more_than_1_and_inputSellIn_less_than_0_and_inputName_is_not_AgedBrie_or_SulfurasHandOfRagnaros_or_BackstagePassesToATAFKAL80ETCConcert(){

//GIVEN
        Item[] input = {new Item("+5 Dexterity Vest", -1, 20)};
        GildedRose gildedRose = new GildedRose(input);

//WHEN
        gildedRose.updateQuality();
        int sellIn_Result = -2;
        int quality_Result = 18;


//THEN
        assertEquals(sellIn_Result,gildedRose.items[0].sellIn );
        assertEquals(quality_Result,gildedRose.items[0].quality );
    }

    //------------------------------------------------------------------------------------------
// SULFURAS
    @Test
    public void should_return_same_sellin_and_quality_if_name_of_item_is_Sulfuras_Hand_of_Ragnaros(){
//GIVEN
        int sellin = 0;
        int quality = 49;
        String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN - ACT
        app.updateQuality();

//THEN - ASSERT
        assertEquals(sellin, app.items[0].sellIn);
        assertEquals(quality, app.items[0].quality);

    }


//AGED BRIE

    @Test
    public void should_return_sellin_minus_one_and_same_quality_if_name_of_item_is_Aged_Brie_and_quality_superior_or_equal_to_fifty(){
        //GIVEN
        int sellin = 0;
        int quality = 50;
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

        //WHEN - ACT
        int resultQuality = quality;
        int resultSellin = sellin - 1;
        app.updateQuality();

        //THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_and_quality_plus_two_if_name_of_item_is_Aged_Brie_and_quality_inferior_to_fifty(){
        //GIVEN
        int sellin = 0;
        int quality = 47;
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

        //WHEN - ACT
        int resultQuality = quality + 2;
        int resultSellin = sellin - 1;
        app.updateQuality();

        //THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_and_quality_plus_one_if_name_of_item_is_Aged_Brie_and_quality_equal_to_forty_nine(){
        //GIVEN
        int sellin = 0;
        int quality = 49;
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

        //WHEN - ACT
        int resultQuality = quality + 1;
        int resultSellin = sellin - 1;
        app.updateQuality();

        //THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    //BACKSTAGE
    @Test
    public void should_return_sellin_minus_one_and_quality_plus_three_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_inferior_to_forty_seven(){
//GIVEN
        int sellin = 5;
        int quality = 46;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN - ACT
        int resultQuality = 49;
        int resultSellin = 4;
        app.updateQuality();

//THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_and_quality_equal_fifty_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_superior_or_equal_to_forty_seven(){
//GIVEN
        int sellin = 5;
        int quality = 47;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN - ACT
        int resultQuality = 50;
        int resultSellin = 4;
        app.updateQuality();

//THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_and_quality_equal_zero_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_inferior_to_fifty_and_sellin_inferior_or_equal_to_0(){
//GIVEN
        int sellin = -1;
        int quality = 35;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN - ACT
        int resultQuality = 0;
        int resultSellin = -2;
        app.updateQuality();

//THEN - ASSERT
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }


    @Test
    public void should_return_sellin_minus_one_and_quality_plus_two_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_inferior_to_fourty_eight_and_sellin_between_6_and_11(){
//GIVEN
        int sellin = 9;
        int quality = 35;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN
        app.updateQuality();

//THEN
        int resultQuality = 37;
        int resultSellin = 8;
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_and_quality_equal_fifty_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_equal_or_superior_to_fourty_eight_and_sellin_between_6_and_11(){
//GIVEN
        int sellin = 9;
        int quality = 49;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN
        app.updateQuality();

//THEN
        int resultQuality = 50;
        int resultSellin = 8;
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

    @Test
    public void should_return_sellin_minus_one_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_equals_fifty_and_sellin_positive(){
//GIVEN
        int sellin = 9;
        int quality = 50;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN
        app.updateQuality();

//THEN
        int resultQuality = 50;
        int resultSellin = 8;
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }
    @Test
    public void should_return_sellin_minus_one_and_quality_plus_one_if_name_of_item_is_Backstage_passes_to_a_TAFKAL80ETC_concert_and_quality_inferiror_to_fifty_and_sellin_superior_to_11(){
//GIVEN
        int sellin = 15;
        int quality = 48;
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, sellin, quality) };
        GildedRose app = new GildedRose(items);

//WHEN
        app.updateQuality();

//THEN
        int resultQuality = 49;
        int resultSellin = 14;
        assertEquals(resultSellin, app.items[0].sellIn);
        assertEquals(resultQuality, app.items[0].quality);
    }

}