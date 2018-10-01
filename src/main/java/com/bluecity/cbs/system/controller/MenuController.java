package com.bluecity.cbs.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluecity.cbs.system.domain.MenuDO;
import com.bluecity.cbs.system.service.MenuService;
import com.bluecity.cbs.common.utils.PageUtils;
import com.bluecity.cbs.common.utils.Query;
import com.bluecity.cbs.common.utils.R;

/**
 * 菜单管理
 * 
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-07-25 23:07:32
 */
 
@Controller
@RequestMapping("/system/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@GetMapping()
	@RequiresPermissions("system:menu:menu")
	String Menu(){
	    return "system/menu/menu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	//@RequiresPermissions("system:menu:menu")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<MenuDO> menuList = menuService.list(query);
		int total = menuService.count(query);
		PageUtils pageUtils = new PageUtils(menuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:menu:add")
	String add(){
	    return "system/menu/add";
	}

	@GetMapping("/edit/{menuId}")
	@RequiresPermissions("system:menu:edit")
	String edit(@PathVariable("menuId") Long menuId,Model model){
		MenuDO menu = menuService.get(menuId);
		model.addAttribute("menu", menu);
	    return "system/menu/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:menu:add")
	public R save( MenuDO menu){
		if(menuService.save(menu)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:menu:edit")
	public R update( MenuDO menu){
		menuService.update(menu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:menu:remove")
	public R remove( Long menuId){
		if(menuService.remove(menuId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:menu:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] menuIds){
		menuService.batchRemove(menuIds);
		return R.ok();
	}
	
}
