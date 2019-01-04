package com.adc.da.system.controller;

import com.adc.da.system.model.dto.QueryParam;
import com.adc.da.system.model.dto.VueRouter;
import com.adc.da.system.model.vo.MenuTreeVO;
import com.adc.da.system.service.MenuService;
import com.adc.da.system.util.TreeUtil;
import com.adc.da.common.constant.Constants;
import com.adc.da.common.model.domain.MenuDO;
import com.adc.da.common.model.dto.Page;
import com.adc.da.common.model.dto.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**

 */
@Api(tags = "菜单服务")
@RequestMapping("menu")
@RestController
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @GetMapping("{id}")
    @ApiOperation("获取菜单详情")
    public R get(@PathVariable("id") Long id) {
        MenuDO menu = menuService.get(id);
        R r = R.success();
        r.setData(menu);
        return r;
    }

    @GetMapping
    @ApiOperation("查询菜单列表")
    public R find(QueryParam queryParam) {
        Page page = menuService.findPage(queryParam);
        R r = R.success();
        r.setData(page);
        return r;
    }

    @PostMapping
    @ApiOperation("添加菜单")
    public R save(@Valid @RequestBody MenuDO menuDO) {
        return R.operate(menuService.save(menuDO));
    }

    @PutMapping
    @ApiOperation("更新菜单信息")
    public R update(@RequestBody MenuDO menuDO) {
        return R.operate(menuService.update(menuDO));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除菜单", notes = "根据菜单ID删除")
    public R delete(@PathVariable("id") Long id) {
        return R.operate(menuService.delete(id));
    }

    @GetMapping("roleMenu")
    @ApiOperation("查询角色菜单")
    public List<MenuDO> findRoleMenu(@NotBlank @RequestParam String[] roleKeys) {
        List<String> keys = Arrays.asList(roleKeys);
        return menuService.getRoleMenu(keys);
    }

    @GetMapping("userMenu")
    @ApiOperation("查询用户路由树")
    public R findUserMenu() {
        R r = R.success();
        List<String> roleKeys = getRole();
        List<MenuDO> menus = menuService.getRoleMenu(roleKeys);
        List<VueRouter> routers = new ArrayList<>();
        menus.forEach(menuDO -> {
            if (Constants.MENU == menuDO.getType()) {
                routers.add(new VueRouter(menuDO));
            }
        });
        Collections.sort(routers, Comparator.comparingInt(VueRouter::getSort));
        r.setData(TreeUtil.build(routers, 0L));
        return r;
    }

    @GetMapping("tree")
    @ApiOperation("查询菜单树")
    public R findMenuTree() {
        R r = R.success();
        List<MenuDO> menus = menuService.findAll();
        List<MenuTreeVO> menuTrees = new ArrayList<>();
        menus.forEach(menuDO -> {
            menuTrees.add(new MenuTreeVO(menuDO));
        });
        Collections.sort(menuTrees, Comparator.comparingInt(MenuTreeVO::getSequence));
        r.setData(TreeUtil.build(menuTrees, 0L));
        return r;
    }
}
