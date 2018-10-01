package com.bluecity.cbs.system.dao;

import com.bluecity.cbs.system.domain.MenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-07-25 23:07:32
 */
@Mapper
public interface MenuDao {

	MenuDO get(Long menuId);
	
	List<MenuDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(MenuDO menu);
	
	int update(MenuDO menu);
	
	int remove(Long menu_id);
	
	int batchRemove(Long[] menuIds);
}
