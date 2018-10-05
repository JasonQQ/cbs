package com.bluecity.cbs.system.service;

import com.bluecity.cbs.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-05 16:57:17
 */

public interface RoleService {
    RoleDO get(Long roleId);

    List<RoleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RoleDO role);

    int update(RoleDO role);

    int remove(Long roleId);

    int batchRemove(Long[] roleIds);
}
