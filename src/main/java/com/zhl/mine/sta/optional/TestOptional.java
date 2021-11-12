package com.zhl.mine.sta.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/10 13:40
 */
public class TestOptional {

    /**
     * paper name
     */
    private String paperName;

    /**
     * paper id
     */
    private int paperId;

    /**
     * Check to see if the object highlighted
     * In this class 'flag' default 'true'
     */
    private boolean flag = true;

    private List<Optional<StemList>> stemList = new LinkedList<>();

    private List<Optional<MaterialList>> materialList = new LinkedList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class MaterialList {

        /**
         * material id
         */
        private Integer id;

        /**
         * material content
         */
        private String content;

        /**
         * Check to see if the object highlighted
         */
        private boolean flag = false;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class StemList {
        /**
         * stem baseId
         */
        private Integer baseId;

        /**
         * stem detailId
         */
        private Integer detailId;

        /**
         * stem content
         */
        private String content;

        /**
         * Check to see if the object highlighted
         */
        private boolean flag = false;


    }
}