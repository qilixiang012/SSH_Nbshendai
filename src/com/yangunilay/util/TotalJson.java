package com.yangunilay.util;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/11/13
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class TotalJson {
    private long results;

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    public long getResults() {
        return results;
    }

    public void setResults(long results) {
        this.results = results;
    }

    private List items;
}
