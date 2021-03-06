package com.bluecity.cbs.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bluecity.cbs.system.dao.RoleDao;
import com.bluecity.cbs.system.domain.RoleDO;
import com.bluecity.cbs.system.service.RoleService;

/**
 * 角色管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-05 16:57:17
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public RoleDO get(Long roleId) {
        return roleDao.get(roleId);
    }

    @Override
    public List<RoleDO> list(Map<String, Object> map) {
        return roleDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return roleDao.count(map);
    }

    @Override
    public int save(RoleDO role) {
        return roleDao.save(role);
    }

    @Override
    public int update(RoleDO role) {
        return roleDao.update(role);
    }

    @Override
    public int remove(Long roleId) {
        return roleDao.remove(roleId);
    }

    @Override
    public int batchRemove(Long[] roleIds) {
        return roleDao.batchRemove(roleIds);
    }
}
