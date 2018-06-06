import enums.Edition;
import enums.ItemType;
import film_memorabilia.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectorTest {
    Collector collector;
    Beaker beaker;
    GeorgeLucas georgeLucas;
    MuppetsItem muppetsItem;
    StarWarsItem starWarsItem;


    @Before
    public void before() {
        collector = new Collector("Finn");
        muppetsItem = new MuppetsItem(ItemType.POSTER, Edition.NOVELTY, "Red, fluffy and gormless looking", 250, 50, 300, "05/06/2018");
        georgeLucas = new GeorgeLucas("The Force Awakens", "genuine autograph from 2015", 100, 25, 99, "10/05/2018");
    }

    @Test
    public void hasName() {
        assertEquals("Finn", collector.getName());
    }

    @Test
    public void collectionStartsEmpty() {
        assertEquals(0, collector.getTotalCollectionSize());
    }

    @Test
    public void canAddItemToCollection() {
        collector.addToCollection(beaker);
        assertEquals(1, collector.getTotalCollectionSize());
    }

    @Test
    public void canAddLucasAndBeakerToCollection() {
        collector.addToCollection(georgeLucas);
        collector.addToCollection(beaker);
        assertEquals(2, collector.getTotalCollectionSize());
    }

    @Test
    public void canRemoveItemFromCollection() {
        collector.addToCollection(beaker);
        collector.removeFromCollection(beaker);
        assertEquals(0, collector.getTotalCollectionSize());
    }

    @Test
    public void canGetValueOfTotalCollection() {
        collector.addToCollection(beaker);
        collector.addToCollection(georgeLucas);
        assertEquals(350, collector.totalValueOfCollection(250, 100));
    }

//    STARWARS COLLECTION //

    @Test
    public void starWarsCollectionCountStartAtZero() {
        assertEquals(0, collector.StarWarsItemCount());
    }

    @Test
    public void canAddToStarWarsCollection() {
        collector.addToStarWarsCollection(starWarsItem);
        assertEquals(1, collector.StarWarsItemCount());
    }

    @Test
    public void canRemoveFromStarWarsCollection() {
        collector.addToStarWarsCollection(starWarsItem);
        collector.removeFromStarWarsCollection(starWarsItem);
        assertEquals(0, collector.StarWarsItemCount());
    }

    @Test
    public void canGetTotalValueOfStarWars() {
        collector.addToStarWarsCollection(georgeLucas);
        assertEquals(100, collector.totalValueOfStarWars());
    }

//    MUPPETS COLLECTION //

    @Test
    public void muppetsItemCountStartAtZero() {
        assertEquals(0, collector.muppetsItemCount());
    }

    @Test
    public void canAddToMuppetsCollection() {
        collector.addToMuppetsCollection(muppetsItem);
        assertEquals(1, collector.muppetsItemCount());
    }

    @Test
    public void canRemoveFromMuppetsCollection() {
        collector.addToMuppetsCollection(muppetsItem);
        collector.removeFromMuppetsCollection(muppetsItem);
        assertEquals(0, collector.muppetsItemCount());
    }

    @Test
    public void canGetTotalValueOfMuppets() {
        collector.addToMuppetsCollection(muppetsItem);
        collector.addToMuppetsCollection(muppetsItem);
        assertEquals(500, collector.totalValueOfMuppets());
    }

    @Test
    public void canCheckForSaleListSize() {
        assertEquals(0, collector.countForSale());
    }

    @Test
    public void canGetMarketValue() {
        assertEquals(300, muppetsItem.getMarketValue());
    }

    @Test
    public void canCheckBeakerIsFavourite() {
        assertEquals(true, collector.isFavourite(muppetsItem));
    }

    @Test
    public void canCheckIsNotFavourite() {
        assertEquals(false, collector.isFavourite(georgeLucas));
    }

    @Test
    public void canAddIfNotFavourite() {
        collector.isFavourite(georgeLucas);
        collector.addToForSale(georgeLucas);
        assertEquals(1, collector.countForSale());
    }

    @Test
    public void canClearForSaleList() {
        collector.addToForSale(georgeLucas);
        assertEquals(1, collector.countForSale());
        collector.soldItem();
        assertEquals(0, collector.countForSale());
    }

    //DATES

    @Test
    public void getToday() {
        assertEquals("06/06/2018", collector.getToday().toString());
    }

    @Test
    public void canAddItemAndCountItemsBetweenDates() {
        collector.addItemToDatesArray(muppetsItem);
        assertEquals(1,collector.countItems());
    }

    @Test
    public void canReturnItemsBoughtBetweenGivenDates() {
        collector.addToMuppetsCollection(muppetsItem);
        collector.getMuppetsItemsBoughtBetweenDates("05/05/2018", "11/08/2018");
        assertEquals(1, collector.itemsBetweenDates.size());
    }

    @Test
    public void canGetEnumPosters() {
        assertEquals("POSTER", collector.getPosters());
    }

}
