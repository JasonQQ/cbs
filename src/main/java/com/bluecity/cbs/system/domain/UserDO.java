package com.bluecity.cbs.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-03 14:35:58
 */

@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 编号
    private Long userId;
    // 用户名
    private String username;
    // 姓名
    private String name;
    // 密码
    private String password;
    // 部门
    private Long deptId;
    // 邮箱
    private String email;
    // 手机号
    private String mobile;
    // 状态
    private Integer status;
    // 创建用户id
    private Long userIdCreate;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModified;
    // 性别
    private Long sex;
    // 出生日期
    private Date birth;
    // 头像
    private Long picId;
    // 住址
    private String liveAddress;
    // 爱好
    private String hobby;
    // 省份
    private String province;
    // 城市
    private String city;
    // 地区
    private String district;
}
