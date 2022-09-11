package com.jap.sales;


import java.util.Comparator;

public class AmountComparator implements Comparator<SalesRecord> {


    @Override
    public int compare(SalesRecord o1, SalesRecord o2) {
        if (o1.getAmount() == o2.getAmount()) {
            return 0;
        }
        if (o1.getAmount() > o2.getAmount()) {
            return -1;
        }

        return 1;

    }
}
