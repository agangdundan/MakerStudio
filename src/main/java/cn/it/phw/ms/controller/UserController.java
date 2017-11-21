package cn.it.phw.ms.controller;

import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.UserWithBLOBs;
import cn.it.phw.ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ms")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/user/login")
    public JsonResult doLogin(@RequestParam String userName,
                              @RequestParam String password, HttpSession session) {

        return userService.doLogin(userName, password, session);
    }

    @ResponseBody
    @GetMapping("/user/logout")
    public JsonResult doLogout(HttpSession session) {
        return userService.doLogout(session);
    }

    @ResponseBody
    @PostMapping("/user")
    public JsonResult doUpdateUser(User user) {
        return userService.doUpdateUser(user);
    }

    @ResponseBody
    @DeleteMapping("/user")
    public JsonResult doDeleteUser(User user) {
        return userService.doDeleteUser(user);
    }

    @ResponseBody
    @PutMapping("/user")
    public JsonResult doRegUser(UserWithBLOBs user){
        return userService.doRegUser(user);
    }

}
