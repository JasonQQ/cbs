package com.bluecity.cbs.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bluecity.cbs.system.dao.MenuDao;
import com.bluecity.cbs.system.domain.MenuDO;
import com.bluecity.cbs.system.service.MenuService;

/**
 * 菜单管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-01 15:16:04
 */

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public MenuDO get(Long menuId) {
        return menuDao.get(menuId);
    }

    @Override
    public List<MenuDO> list(Map<String, Object> map) {
        return menuDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return menuDao.count(map);
    }

    @Override
    public int save(MenuDO menu) {
        return menuDao.save(menu);
    }

    @Override
    public int update(MenuDO menu) {
        return menuDao.update(menu);
    }

    @Override
    public int remove(Long menuId) {
        return menuDao.remove(menuId);
    }

    @Override
    public int batchRemove(Long[] menuIds) {
        return menuDao.batchRemove(menuIds);
    }
}
