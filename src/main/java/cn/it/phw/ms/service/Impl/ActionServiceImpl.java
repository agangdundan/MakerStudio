package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.ActionMapper;
import cn.it.phw.ms.dao.mapper.ActiongroupMapper;
import cn.it.phw.ms.pojo.*;
import cn.it.phw.ms.service.ActionService;
import cn.it.phw.ms.service.UserGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ActionServiceImpl extends BaseServiceImpl implements ActionService {

    private Logger logger = LoggerFactory.getLogger(ActionServiceImpl.class);

    @Autowired
    private ActionMapper actionMapper;

    @Autowired
    private ActiongroupMapper actiongroupMapper;

    @Autowired
    private UserGroupService userGroupService;

    @Override
    public JsonResult selectActionByUserGroupId(Integer ugid) {

        ActiongroupExample.Criteria criteria = actiongroupExample.or();
        criteria.andUserGroupIdEqualTo(ugid);
        List<Actiongroup> actiongroups = actiongroupMapper.selectByExample(actiongroupExample);
        if (actiongroups.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("这个权限组还没有分配任何权限");
        } else {
            List<Action> actions = new ArrayList<>();
            for (Actiongroup actiongroup : actiongroups) {
                Integer actionId = actiongroup.getActionId();
                Action action = actionMapper.selectByPrimaryKey(1);
                actions.add(action);
            }
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
            data.put(AppContext.KEY_DATA, actions);
            jsonResult.setData(data);
        }

        return jsonResult;
    }

    @Override
    public JsonResult verifyActions(Integer uid, List<Action> actions) {

        JsonResult jsonResultOfUseGroup = userGroupService.selectTheMaxUserGroupByUserId(String.valueOf(uid));
        Usergroup usergroup = (Usergroup) jsonResultOfUseGroup.getData().get(AppContext.KEY_DATA);
        JsonResult jsonResultOfAction = selectActionByUserGroupId(usergroup.getId());
        List<Action> currActions = (List<Action>) jsonResultOfAction.getData().get(AppContext.KEY_DATA);

        //用户的权和
        int userPurviewValue = 0;
        //验证的权和
        int currPirviewValue = 0;

        boolean isAccess = false;

        for (Action action : currActions) {
            Integer temp = (int) Math.pow(2, action.getId());
            userPurviewValue += temp;
        }
        logger.error("用户总的权和为：" + String.valueOf(userPurviewValue));
        for (Action action : actions) {
            Integer temp = (int) Math.pow(2, action.getId());
            currPirviewValue += temp;
        }
        logger.error("当前需要的权和为：" + String.valueOf(currPirviewValue));

        isAccess = (userPurviewValue & currPirviewValue) == currPirviewValue;

        if (isAccess) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("您没有足够的权限");
        }

        return jsonResult;
    }

}
