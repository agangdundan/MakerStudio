package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.*;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.pojo.UserExample;
import cn.it.phw.ms.service.UserService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Gson gson;

    @Cacheable("doLogin")
    @Override
    public JsonResult doLogin(String username, String password) {

        UserExample.Criteria criteria = userExample.or();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("错误：用户不存在！");
        } else {
            User user = userList.get(0);
            String newPasswords = password + user.getSalt();
            logger.debug(newPasswords);
            System.out.println(newPasswords);
            if (user.getPassword().equals(Md5Utils.MD5Encode(newPasswords, "UTF-8", false))) {

                user.setLastTime(new Date());

                userMapper.updateByPrimaryKey(user);
                jsonResult.setStatus(200);
                jsonResult.setMessage("登陆成功！");
                String token = JwtUtils.createJWT(user.getId(), AppContext.KEY_ISSUSE, 1000*60*60*24);
                data.put(AppContext.KEY_TOKEN, token);
                data.put(AppContext.KEY_USER, user);

                redisTemplate.opsForHash().put(AppContext.USER_CACHE, String.valueOf(user.getId()), gson.toJson(user));

                jsonResult.setData(data);
            } else {
                jsonResult.setStatus(500);
                jsonResult.setMessage("错误：密码不正确！");
            }

        }

        return jsonResult;
    }

    @Override
    public JsonResult doLogout(String userId) {
        redisTemplate.opsForHash().delete(AppContext.USER_CACHE, userId);
        jsonResult.setStatus(200);
        jsonResult.setMessage("注销成功！");
        return jsonResult;
    }

    @Override
    public JsonResult doUpdateUser(User user) {

        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        if (oldUser == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("用户不存在！");
        } else {
            if (!StringUtils.isEmpty(user.getUsername())) {
                oldUser.setUsername(user.getUsername());
            } else if (!StringUtils.isEmpty(user.getSignature())) {
                oldUser.setSignature(user.getSignature());
            } else if (!StringUtils.isEmpty(user.getSex())) {
                oldUser.setSex(user.getSex());
            } else if (!StringUtils.isEmpty(user.getEmail())) {
                oldUser.setEmail(user.getEmail());
            } else if (!StringUtils.isEmpty(user.getPhone())) {
                oldUser.setPhone(user.getPhone());
            }
            userMapper.updateByPrimaryKey(oldUser);
            jsonResult.setStatus(500);
            jsonResult.setMessage("更新成功");
        }

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
    public JsonResult doDeleteUserByPK(Integer id) {

        userMapper.deleteByPrimaryKey(id);
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
    public JsonResult doRegUser(User user) {

        user.setCreateTime(new Date());
        user.setSalt(String.valueOf(System.currentTimeMillis()));
        user.setPassword(Md5Utils.MD5Encode("123456" + user.getSalt(), "UTF-8", false));

        userMapper.insert(user);
        jsonResult.setStatus(200);
        jsonResult.setMessage("恭喜你，注册成功！请尽快完善信息。");

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

    @Override
    public JsonResult findAllUsers() {
        List<User> users = userMapper.selectByExample(null);
        if (users.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("没有查找到任何记录！");
        } else {
            jsonResult.setStatus(0);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, users);
            jsonResult.setData(data);
        }

        return jsonResult;
    }

    @Override
    public JsonResult findUserByPK(Integer id) {
        UserExample.Criteria criteria = userExample.or();
        criteria.andIdEqualTo(id);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("没有查找到任何记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, userList.get(0));
            jsonResult.setData(data);
        }
        return jsonResult;
    }

    @Override
    public JsonResult doAddUser(User user, String adminId) {

        String adminJson = (String) redisTemplate.opsForHash().get(AppContext.USER_CACHE, adminId);
        User admin = gson.fromJson(adminJson, User.class);
        if (admin == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("无效的用户！");
        } else {
            user.setCreatorId(admin.getId());
            user.setCreatorName(admin.getUsername());
            doRegUser(user);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加成功！");
        }

        return jsonResult;
    }


    @Override
    public JsonResultForLayui findAllUsersWithLayui() {
        List<User> users = userMapper.selectByExample(null);
        if (users.size() == 0) {
            jsonResultForLayui.setCode(500);
            jsonResultForLayui.setMsg("未查询到任何记录！");
        } else {
            jsonResultForLayui.setCode(0);
            jsonResultForLayui.setMsg("加载完成！");
            jsonResultForLayui.setCount(users.size());
            jsonResultForLayui.setData(users);
        }
        return jsonResultForLayui;
    }
}
