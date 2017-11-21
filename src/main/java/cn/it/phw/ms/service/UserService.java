package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.pojo.UserWithBLOBs;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService extends BaseService {

    JsonResult doLogin(String userName, String password, HttpSession session);

    JsonResult doLogout(HttpSession session);

    JsonResult doUpdateUser(User user);

    JsonResult doRePass(User user);

    JsonResult doDeleteUser(User user);

    JsonResult doDeleteUsers(List<User> users);

    JsonResult doRegUser(UserWithBLOBs user);

    JsonResult doRegUsers(String path);

    JsonResult findUserByUsername(String userName);

    JsonResult findUserByEmail(String email);

}
