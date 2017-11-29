package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/ms")
@SessionAttributes(AppContext.KEY_USER)
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/user/login")
    public JsonResult doLogin(@RequestParam String username,
                              @RequestParam String password, ModelMap map) {
        jsonResult = userService.doLogin(username, password);
        map.addAttribute(AppContext.KEY_USER, jsonResult.getData().get(AppContext.KEY_USER));
        return jsonResult;
    }

    @ResponseBody
    @GetMapping(value = "/user/logout")
    public JsonResult doLogout(HttpSession session) {
        return userService.doLogout(session);
    }

    @ResponseBody
    @PostMapping(value = "/user")
    public JsonResult doUpdateUser(User user) {
        return userService.doUpdateUser(user);
    }

    @ResponseBody
    @DeleteMapping(value = "/user/{id}")
    public JsonResult doDeleteUserByPK(@PathVariable("id") Integer id) {
        return userService.doDeleteUserByPK(id);
    }

    @ResponseBody
    @PutMapping("/user")
    public JsonResult doRegUser(User user, ModelMap map){
        User admin = (User) map.get(AppContext.KEY_USER);
        //user.setCreaterId(admin.getId());
        //user.setCreatorName(admin.getUsername());
        return userService.doRegUser(user);
    }

    @ResponseBody
    @GetMapping("/users")
    public JsonResult findAllUsers() {
        return userService.findAllUsers();
    }

    @ResponseBody
    @GetMapping("/users/layui")
    public JsonResultForLayui findAllUsersWithLayui() {
        return userService.findAllUsersWithLayui();
    }

    @ResponseBody
    @GetMapping("/user/{id}")
    public JsonResult findUserByPK(@PathVariable("id") Integer id) {
        return userService.findUserByPK(id);
    }
}
