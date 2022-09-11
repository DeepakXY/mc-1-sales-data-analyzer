package com.jap.sales;


import java.util.Comparator;

public class TimeOnSiteComparator implements Comparator<SalesRecord> {
    @Override
    public int compare(SalesRecord o1, SalesRecord o2) {

        if (o1.getTimeOnSite() == o2.getTimeOnSite()) {
            return 0;
        }
        if (o1.getTimeOnSite() > o2.getTimeOnSite()) {
            return -1;
        }
        return 1;
    }
}

