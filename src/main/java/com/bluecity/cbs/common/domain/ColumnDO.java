package com.bluecity.cbs.common.domain;

import lombok.*;

@Data
public class ColumnDO {
    // 列名
    private String columnName;
    // 列名类型
    private String dataType;
    // 列名备注
    private String comments;

    // 属性名称(第一个字母大写)，如：user_name => UserName
    private String attrName;
    // 属性名称(第一个字母小写)，如：user_name => userName
    private String attributeName;
    // 属性类型
    private String attributeType;
    // auto_increment
    private String extra;
}

