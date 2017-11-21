package cn.it.pwh.ms.service.Impl;

import cn.it.pwh.ms.common.AppContext;
import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.common.Md5Utils;
import cn.it.pwh.ms.dao.mapper.UserMapper;
import cn.it.pwh.ms.dao.mapper.UsergroupMapper;
import cn.it.pwh.ms.pojo.User;
import cn.it.pwh.ms.pojo.UserExample;
import cn.it.pwh.ms.pojo.UserWithBLOBs;
import cn.it.pwh.ms.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    @Override
    public JsonResult doLogin(String userName, String password) {

        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("错误：用户不存在！");
        } else {
            User user = userList.get(0);
            String newPasswords = password + user.getPassword();
            logger.debug(newPasswords);

            if (user.getPassword().equals(Md5Utils.MD5Encode(newPasswords, "UTF-8", true))) {
                data.put(AppContext.KEY_USER, user);
            } else {
                jsonResult.setStatus(500);
                jsonResult.setMessage("错误：密码不正确！");
            }

        }

        return jsonResult;
    }

    @Override
    public JsonResult doLogout() {
        return null;
    }

    @Override
    public JsonResult doUpdateUser(User user) {

        userMapper.updateByPrimaryKey(user);
        jsonResult.setStatus(200);
        jsonResult.setMessage("更新用户信息成功！");

        return jsonResult;
    }

    @Override
    public JsonResult doRePass(User user) {

        userMapper.updateByPrimaryKey(user);
        jsonResult.setStatus(200);
        jsonResult.setMessage("更改密码成功！");

        return jsonResult;
    }

    @Override
    public JsonResult doDeleteUser(User user) {

        userMapper.deleteByPrimaryKey(user.getId());
        jsonResult.setStatus(200);
        jsonResult.setMessage("删除用户成功！");

        return jsonResult;
    }

    @Override
    public JsonResult doDeleteUsers(List<User> users) {
        if (users.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("错误：没有选择用户！");
        } else {
            int i = 0;
            for (User user : users) {
                userMapper.deleteByPrimaryKey(user.getId());
                i++;
            }
            jsonResult.setStatus(200);
            jsonResult.setMessage("成功删除了" + i + "个用户！");
        }

        return jsonResult;
    }

    @Override
    public JsonResult doRegUser(UserWithBLOBs user) {

        userMapper.insert(user);
        jsonResult.setStatus(200);
        jsonResult.setMessage("恭喜你，注册成功！");

        return jsonResult;
    }

    @Override
    public JsonResult doRegUsers(String path) {
        return null;
    }

    @Override
    public JsonResult findUserByUsername(String userName) {

        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(userName);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("没有找到相关记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("找到了" + userList.size() + "!");
            data.put(AppContext.KEY_DATA, userList);
            jsonResult.setData(data);
        }

        return jsonResult;
    }

    @Override
    public JsonResult findUserByEmail(String email) {

        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("没有找到相关记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("找到了" + userList.size() + "条记录！");
            data.put(AppContext.KEY_DATA, userList);
            jsonResult.setData(data);
        }
        return jsonResult;
    }
}
