package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.ActionMapper;
import cn.it.phw.ms.dao.mapper.ActiongroupMapper;
import cn.it.phw.ms.pojo.Action;
import cn.it.phw.ms.pojo.Actiongroup;
import cn.it.phw.ms.pojo.ActiongroupExample;
import cn.it.phw.ms.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ActionServiceImpl extends BaseServiceImpl implements ActionService {

    @Autowired
    private ActionMapper actionMapper;

    @Autowired
    private ActiongroupMapper actiongroupMapper;

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
                actions.add(actionMapper.selectByPrimaryKey(actiongroup.getActionId()));
            }
        }

        return null;
    }

}
