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

            //用户所具有的总权限
            List<Action> actions = new ArrayList<>();
            for (Actiongroup actiongroup : actiongroups) {
                Integer actionId = actiongroup.getActionId();
                Action action = actionMapper.selectByPrimaryKey(actionId);
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
    public JsonResult verifyActions(Integer uid, List<String> reqActionsStr) {

        JsonResult jsonResultOfUseGroup = userGroupService.selectTheMaxUserGroupByUserId(String.valueOf(uid));
        Usergroup usergroup = (Usergroup) jsonResultOfUseGroup.getData().get(AppContext.KEY_DATA);
        JsonResult jsonResultOfAction = selectActionByUserGroupId(usergroup.getId());

        List<Action> userActions = (List<Action>) jsonResultOfAction.getData().get(AppContext.KEY_DATA);

        StringBuilder userActionsStr = new StringBuilder();
        for (Action action : userActions) {
            userActionsStr.append(action.getAction())
                        .append(",");
        }
        logger.info(userActionsStr.toString());
        for (String action : reqActionsStr) {
            if ((userActions.toString()).contains(action)) {
                data.put(action, true);
            } else {
                data.put(action, false);
            }
        }
        jsonResult.setStatus(200);
        jsonResult.setMessage("OK");
        jsonResult.setData(data);

        return jsonResult;
    }

    @Override
    public JsonResult selectActionByActionStr(String action) {

        ActionExample.Criteria criteria = actionExample.or();
        criteria.andActionEqualTo(action);
        List<Action> actions = actionMapper.selectByExample(actionExample);
        if (actions.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("No Such Action");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
            data.put(AppContext.KEY_DATA, actions.get(0));
        }

        return jsonResult;
    }

    @Override
    public JsonResult selectAllActions() {
        List<Action> actions = actionMapper.selectByExample(null);
        if (actions.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("还没有添加任何权限");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, actions);
            jsonResult.setData(data);
        }
        return jsonResult;
    }

    @Override
    public JsonResult insertAction(Action action) {
        action.setActionColumnId(1);
        action.setVisiable(0);
        actionMapper.insert(action);
        jsonResult.setStatus(200);
        jsonResult.setMessage("操作完成");
        return jsonResult;
    }

    @Override
    public JsonResult updateActionByPK(Action action) {
        Action oldAction = actionMapper.selectByPrimaryKey(action.getId());
        if (oldAction == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("参数错误");
        } else {
            if (action.getAction() != null) {
                oldAction.setAction(action.getAction());
            } if (action.getActionColumnId() != null) {
                oldAction.setActionColumnId(action.getActionColumnId());
            } if (action.getDescription() != null) {
                oldAction.setDescription(action.getDescription());
            } if (action.getType() != null) {
                oldAction.setType(action.getType());
            } if (action.getVisiable() != null) {
                oldAction.setVisiable(action.getVisiable());
            }

            actionMapper.updateByPrimaryKey(oldAction);

            jsonResult.setMessage("操作完成");
            jsonResult.setStatus(200);
        }
        return jsonResult;
    }

    @Override
    public JsonResult deleteActonByPK(Integer id) {
        if (id == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("Params Error");
        } else {
            actionMapper.deleteByPrimaryKey(id);
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
        }
        return jsonResult;
    }

}
