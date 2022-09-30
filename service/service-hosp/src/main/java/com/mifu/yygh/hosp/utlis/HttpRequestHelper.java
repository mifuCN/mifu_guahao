package com.mifu.yygh.hosp.utlis;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpRequestHelper {
    /**
     * 返回封装好的resultMap  是 键值对的形式
     * @param parameterMap
     * @return
     */
    public static Map<String, Object> switchMap(Map<String, String[]> parameterMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();

        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue()[0];
            resultMap.put(key, value);
        }

        return resultMap;
    }
}
