package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService extends BaseService {

    JsonResult doLogin(String username, String password, HttpSession session);

    JsonResult doLogout(HttpSession session);

    JsonResult doUpdateUser(User user);

    JsonResult doRePass(User user);

    JsonResult doDeleteUserByPK(Integer id);

    JsonResult doDeleteUsers(List<User> users);

    JsonResult doRegUser(User user, HttpSession session);

    JsonResult doRegUsers(String path);

    JsonResult findUserByUsername(String userName);

    JsonResult findUserByEmail(String email);

    /**
     * 查询所有用户
     * 需要符合layui表格的数据格式
     * @return Layui的json数据格式
     */
    JsonResult findAllUsers();

    JsonResultForLayui findAllUsersWithLayui();

    JsonResult findUserByPK(Integer id);
}
