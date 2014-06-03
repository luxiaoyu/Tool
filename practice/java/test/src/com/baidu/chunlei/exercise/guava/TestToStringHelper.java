package com.baidu.chunlei.exercise.guava;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-5-21
 * @todo
 */
public class TestToStringHelper {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Objects.toStringHelper(TestToStringHelper.class).add("name", "luxiaoyu")
                .add("age", null).omitNullValues().toString());
    }

}
