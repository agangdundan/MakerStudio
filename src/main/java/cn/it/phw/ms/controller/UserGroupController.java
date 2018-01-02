package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Usergroup;
import cn.it.phw.ms.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/ms")
public class UserGroupController extends BaseController {

    @Autowired
    private UserGroupService userGroupService;

    @ResponseBody
    @GetMapping("/usergroups")
    public JsonResult findAllUserGroups() {
        return userGroupService.selectAllUserGroups();
    }

    @ResponseBody
    @PostMapping("/usergroup")
    public JsonResult updateUserGroupByPK(Usergroup usergroup) {
        return userGroupService.updateUserGroupByPK(usergroup);
    }

    @ResponseBody
    @DeleteMapping("/usergroup/{id}")
    public JsonResult deleteUserGroupByPK(@PathVariable("id") Integer id) {
        return userGroupService.deleteUserGroupByPK(id);
    }

    @ResponseBody
    @PutMapping("/usergroup")
    public JsonResult addUserGroup(Usergroup usergroup, HttpServletRequest request) {
        return userGroupService.insertUserGroup(usergroup, (String) request.getAttribute(AppContext.KEY_ID));
    }

}
