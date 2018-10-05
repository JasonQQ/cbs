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

import com.bluecity.cbs.system.domain.RoleDO;
import com.bluecity.cbs.system.service.RoleService;
import com.bluecity.cbs.common.utils.PageUtils;
import com.bluecity.cbs.common.utils.Query;
import com.bluecity.cbs.common.utils.R;

/**
 * 角色管理
 *
 * @author bluecity
 * @email 22829273@qq.com
 * @date 2018-10-05 16:57:17
 */

@Controller
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping()
    @RequiresPermissions("system:role:role")
    String Role() {
        return "system/role/role";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("system:role:role")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<RoleDO> roleList = roleService.list(query);
        int total = roleService.count(query);
        PageUtils pageUtils = new PageUtils(roleList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("system:role:add")
    String add() {
        return "system/role/add";
    }

    @GetMapping("/edit/{roleId}")
    @RequiresPermissions("system:role:edit")
    String edit(@PathVariable("roleId") Long roleId, Model model) {
        RoleDO role = roleService.get(roleId);
        model.addAttribute("role", role);
        return "system/role/edit";
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("system:role:add")
    public R save(RoleDO role) {
        if (roleService.save(role) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("system:role:edit")
    public R update(RoleDO role) {
        roleService.update(role);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("system:role:remove")
    public R remove(Long roleId) {
        if (roleService.remove(roleId) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("system:role:batchRemove")
    public R remove(@RequestParam("ids[]") Long[] roleIds) {
        roleService.batchRemove(roleIds);
        return R.ok();
    }
}
