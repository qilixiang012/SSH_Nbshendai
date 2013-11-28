package com.yangunilay.util;


import java.util.List;
import net.sf.json.*;
/**
 * Created with IntelliJ IDEA.
 * User: yyz
 * Date: 11/11/13
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExtHelper {
    public static String getJsonFromList(long recordTotal,List beanList){
        TotalJson total = new TotalJson();
        total.setResults(recordTotal);
        total.setItems(beanList);
        JSONObject jsonArray = JSONObject.fromObject(total);
        return  jsonArray.toString();
    }
}
