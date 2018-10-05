package com.bluecity.cbs.system.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 角色管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-05 16:57:17
 */

@Data
public class RoleDO implements Serializable {
    private static final long serialVersionUID = 1L;

    // 
    private Long roleId;
    // 角色名称
    private String roleName;
    // 角色标识
    private String roleSign;
    // 备注
    private String remark;
    // 创建用户id
    private Long userIdCreate;
    // 创建时间
    private Date gmtCreate;
    // 创建时间
    private Date gmtModified;
}
