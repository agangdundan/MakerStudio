package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.GroupmanagerMapper;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.Groupmanager;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.service.UserGroupManagerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;

public class UserGroupManagerServiceImpl extends BaseServiceImpl implements UserGroupManagerService {

    @Autowired
    private GroupmanagerMapper groupmanagerMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private Gson gson;

    @Override
    public JsonResult insertUserGroupManager(Groupmanager groupmanager, Integer adminId) {
        String adminJson = (String) redisTemplate.opsForHash().get(AppContext.USER_CACHE, adminId);
        User admin = gson.fromJson(adminJson, User.class);
        if (admin == null) {
            admin = userMapper.selectByPrimaryKey(adminId);
        }

        groupmanager.setCreateTime(new Date());
        groupmanager.setModifyUserId(admin.getId());
        groupmanager.setModifyUsername(admin.getUsername());

        groupmanagerMapper.insert(groupmanager);

        jsonResult.setStatus(200);
        jsonResult.setMessage("OK");

        return jsonResult;
    }

}
