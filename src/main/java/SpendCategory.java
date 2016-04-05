
public enum SpendCategory {
    FOOD(0), TAXES(2), MY(4), WIFE(6), CAR(8), DIFFERENT(10), SON(12), UNKNOWN(20);

    int index;

    SpendCategory(int index) {
        this.index = index;
    }

    static SpendCategory fromIndex(int index) {
        for (SpendCategory spendCategory : values()) {
            if (spendCategory.index == index) return spendCategory;
        }
        throw new IllegalArgumentException("index: " + index);
    }
}