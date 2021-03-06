package film_memorabilia;

import behaviours.ICollect;
import enums.Edition;
import enums.ItemType;
import film_memorabilia.filmTitleParents.MuppetsItem;


public class Beaker extends MuppetsItem implements ICollect {

    public Beaker(ItemType type, Edition edition, String itemDescription, int buyPrice, int shipping, int marketValue, String purchaseDate) {
        super(type, edition, itemDescription, buyPrice, shipping, marketValue, purchaseDate);
    }

    public int totalSpendOnItem() {
        return this.buyPrice + this.shipping;
    }

    public int calculateMarkup(int totalSpendOnItem) {
        return this.marketValue - totalSpendOnItem;
    }
}
