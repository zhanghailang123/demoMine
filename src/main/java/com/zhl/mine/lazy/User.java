package com.zhl.mine.lazy;

import lombok.Data;

import java.util.Set;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/11/8 10:56
 */
@Data
public class User {
    private Long userId;

    /**
     * 远程调用 用户所属部门
     */
    private String departMent;
    /**
     * 用户的上级主管
     */
    private Long supervisor;
    /**
     * 用户的权限集合
     */
    private Set<String> permissions;
}