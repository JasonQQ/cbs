package com.bluecity.cbs.system.dao;

import com.bluecity.cbs.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-05 16:57:17
 */

@Mapper
public interface RoleDao {
    RoleDO get(Long roleId);

    List<RoleDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(RoleDO role);

    int update(RoleDO role);

    int remove(Long role_id);

    int batchRemove(Long[] roleIds);
}
