package com.bluecity.cbs.system.service;

import com.bluecity.cbs.system.domain.MenuDO;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-01 15:16:04
 */

public interface MenuService {
    MenuDO get(Long menuId);

    List<MenuDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MenuDO menu);

    int update(MenuDO menu);

    int remove(Long menuId);

    int batchRemove(Long[] menuIds);
}
