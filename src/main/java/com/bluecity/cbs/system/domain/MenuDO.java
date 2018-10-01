package com.bluecity.cbs.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 菜单管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-01 15:16:04
 */

@Data
public class MenuDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 编号
    private Long menuId;
    // 父编号
    private Long parentId;
    // 名称
    private String name;
    // 路径
    private String url;
    // 权限
    private String perms;
    // 类型
    private Integer type;
    // 图标
    private String icon;
    // 排序
    private Integer orderNum;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
}
