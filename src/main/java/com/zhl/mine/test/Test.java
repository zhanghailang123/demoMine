package com.zhl.mine.test;

import cn.hutool.core.util.StrUtil;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/9 10:54
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(StrUtil.startWith("XYZZZZ","XY"));
        System.out.println(StrUtil.startWith("XYXZ23q23123","XY"));
    }
}