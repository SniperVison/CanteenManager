package com.vison.canteen.core.controller;

import com.vison.canteen.core.bean.DTO.RoleDTO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.RoleVO;
import com.vison.canteen.core.exception.CanteenException;
import com.vison.canteen.core.service.RoleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author huangwenshen 2018/4/16 22:06
 */
@Slf4j
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 新增角色
     *
     * @param roleDTO
     * @return
     */
    @PostMapping("add-role")
    @ApiOperation(value = "新增角色",
            notes = "通过传入对象进行新增角色",
            httpMethod = "POST")
    @ApiImplicitParam(name = "role", value = "用户角色对象DTO", paramType = "query", required = true)
    @ApiResponses(value = {
            @ApiResponse(code = 701, message = "角色对象为null"),
            @ApiResponse(code = 702, message = "新增角色时,默认可用,不能设置可用性")
    })
    public Boolean addRole(@NotNull @RequestParam("role") RoleDTO roleDTO) throws CanteenException {
        return roleService.addRole(roleDTO);
    }

    /**
     * 更新角色
     *
     * @param roleDTO
     * @return
     */
    @PostMapping("update-role")
    @ApiOperation(value = "更新角色",
            notes = "通过传入对象进行更新角色",
            httpMethod = "POST")
    @ApiImplicitParam(name = "role", value = "用户角色对象DTO", paramType = "query", required = true)
    @ApiResponses(value = {
            @ApiResponse(code = 701, message = "角色对象为null"),
            @ApiResponse(code = 702, message = "新增角色时,默认可用,不能设置可用性")
    })
    public Boolean updateRole(@NotNull @RequestParam("role") RoleDTO roleDTO) throws CanteenException {
        return roleService.updateRole(roleDTO);
    }

    @GetMapping("list")
    public ModelAndView roleView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        UserPO user = (UserPO) session.getAttribute("user");
        request.setAttribute("user", user);
        model.setViewName("role");
        return model;
    }

    @GetMapping("get-all-role")
    public List<RoleVO> getAllRole() {
        return roleService.getAllRole();
    }

}
