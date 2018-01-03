package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.ActiongroupMapper;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.Actiongroup;
import cn.it.phw.ms.pojo.ActiongroupExample;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.pojo.Usergroup;
import cn.it.phw.ms.service.ActionManagerService;
import cn.it.phw.ms.service.UserGroupService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ActionManagerServiceImpl extends BaseServiceImpl implements ActionManagerService {

    @Autowired
    private ActiongroupMapper actiongroupMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Gson gson;


    @Override
    public JsonResult distributeActionToUserGroup(Integer adminId, Integer ugId, String[] actionIds) {

        String adminJson = (String) redisTemplate.opsForHash().get(AppContext.USER_CACHE, adminId + "");
        User admin = gson.fromJson(adminJson, User.class);
        if (admin == null) {
            admin = userMapper.selectByPrimaryKey(adminId);
        }

        Date date = new Date();
        Actiongroup actiongroup;
        for (String actionId : actionIds) {
            actiongroup = new Actiongroup();
            actiongroup.setCreateTime(date);
            actiongroup.setCreaterName(admin.getUsername());
            actiongroup.setActionId(Integer.valueOf(actionId));
            actiongroup.setUserId(admin.getId());
            actiongroup.setUserGroupId(ugId);
            actiongroupMapper.insert(actiongroup);
        }
        jsonResult.setStatus(200);
        jsonResult.setMessage("操作完成");

        return jsonResult;
    }

    @Override
    public JsonResult selectActionGroupsByUid(Integer uid) {

        ActiongroupExample.Criteria criteria = actiongroupExample.or();
        jsonResult = userGroupService.selectTheMaxUserGroupByUserId(uid + "");
        Usergroup usergroup = (Usergroup) jsonResult.getData().get(AppContext.KEY_DATA);
        criteria.andUserGroupIdEqualTo(usergroup.getId());
        criteria.andUserIdEqualTo(uid);
        List<Actiongroup> actiongroups = actiongroupMapper.selectByExample(actiongroupExample);
        if (actiongroups.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("该用户组还没有任何权限");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
            data.put(AppContext.KEY_DATA, actiongroups);
            jsonResult.setData(data);
        }

        return jsonResult;
    }


}
