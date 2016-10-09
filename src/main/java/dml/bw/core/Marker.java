package dml.bw.core;


class Marker {
    void process(ItemQuality itemQualityLhs, ItemQuality itemQualityRhs) {
            /*
			 * sprawdza warunek: nastepnie program sprawdza czy spelniony jest
			 * warunek poniedzy dana trojka liczb p2-p1=s1-s2 dla liczb
			 * [p1,b1,s1] oraz [p2,b2,s2]
			 *
			 * i jesli spelniony ustawia markedToDelete=true
			 */
        if (isItemsNotMarked(itemQualityLhs, itemQualityRhs) && isPrefixEqualsThree(itemQualityLhs, itemQualityRhs)
                && isSuffixEqualsThree(itemQualityLhs, itemQualityRhs)) {
            itemQualityLhs.setMarkedToDelete(true);
            itemQualityRhs.setMarkedToDelete(true);
            System.out.println("Łaczenie: " + itemQualityLhs.getName()
                    + "+ " + itemQualityRhs.getName());
        }
    }

    private boolean isItemsNotMarked(ItemQuality itemQualityLhs, ItemQuality itemQualityRhs) {
        return !itemQualityLhs.isMarkedToDelete() && !itemQualityRhs.isMarkedToDelete();
    }

    private boolean isSuffixEqualsThree(ItemQuality itemQualityLhs, ItemQuality itemQualityRhs) {
        return (itemQualityLhs.getSuffix() - itemQualityRhs.getSuffix()) == 3;
    }

    private boolean isPrefixEqualsThree(ItemQuality itemQualityLhs, ItemQuality itemQualityRhs) {
        return (itemQualityRhs.getPrefix() - itemQualityLhs.getPrefix()) == 3;
    }
}