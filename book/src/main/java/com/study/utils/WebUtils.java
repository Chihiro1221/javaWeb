package com.study.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map map, T obj) {
        try {
            BeanUtils.copyProperties(obj, map);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            int i = Integer.parseInt(strInt);
            return i;
        } catch (Exception e) {
//            e.printStackTrace();
        }

        return defaultValue;
    }
}
