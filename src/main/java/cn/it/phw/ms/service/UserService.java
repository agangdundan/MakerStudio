package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService extends BaseService {

    JsonResult doLogin(String username, String password);

    JsonResult doLogout(String userId);

    JsonResult doUpdateUser(User user);

    JsonResult doRePass(User user);

    JsonResult doDeleteUserByPK(Integer id);

    JsonResult doDeleteUsers(List<User> users);

    JsonResult doRegUser(User user);

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

    /**
     * 根据ID查找User记录
     * 首先查找redis中是否有相应的记录
     * 如果有则直接返回缓存中的数据
     * 如果没有则从数据库中查找
     * @param id 主键id
     * @return
     */
    JsonResult findUserByPK(Integer id);

    JsonResult doAddUser(User user, String adminId);
}
