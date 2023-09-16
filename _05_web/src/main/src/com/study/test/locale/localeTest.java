package com.study.test.locale;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class localeTest {
    @Test
    public void test1() {
        // 获取系统默认地区语言信息
        Locale default1 = Locale.getDefault();
        System.out.println(Locale.US);
    }

    @Test
    public void test2() {
        Locale us = Locale.US;

        ResourceBundle i18n = ResourceBundle.getBundle("i18n", us);
        System.out.println(i18n.getString("username"));
    }
}
