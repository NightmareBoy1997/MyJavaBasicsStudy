package org.javasm.supermarket.util;

import org.javasm.supermarket.bean.Commodity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: MyJavaStudy
 * @package: org.javasm.supermarket.util
 * @author: Nightmare970701
 * @description:
 * @since:
 * @version: JDK11
 * @create: 2022-03-17 11:31
 */
public class QueryUtil {
    static Map<String, List<?>> map = new HashMap(16);

    /**
     * 获取商品类型缓存
     */
    public List getCommodityList(){
        String name = "Commodity";
        if(!map.containsKey(name)){
            map.put(name,new ArrayList<Commodity>(10));
        }
        return map.get(name);
    }

    @Test
    public void test(){

    }




}