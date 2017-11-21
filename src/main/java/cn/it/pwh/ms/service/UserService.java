package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.User;
import cn.it.pwh.ms.pojo.UserWithBLOBs;

import java.util.List;

public interface UserService extends BaseService {

    JsonResult doLogin(String userName, String password);

    JsonResult doLogout();

    JsonResult doUpdateUser(User user);

    JsonResult doRePass(User user);

    JsonResult doDeleteUser(User user);

    JsonResult doDeleteUsers(List<User> users);

    JsonResult doRegUser(UserWithBLOBs user);

    JsonResult doRegUsers(String path);

    JsonResult findUserByUsername(String userName);

    JsonResult findUserByEmail(String email);

}
