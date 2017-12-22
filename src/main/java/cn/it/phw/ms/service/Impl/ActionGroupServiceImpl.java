package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.ActiongroupMapper;
import cn.it.phw.ms.pojo.Actiongroup;
import cn.it.phw.ms.pojo.ActiongroupExample;
import cn.it.phw.ms.service.ActiongroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActionGroupServiceImpl extends BaseServiceImpl implements ActiongroupService {

    @Autowired
    private ActiongroupMapper actiongroupMapper;

    @Override
    public JsonResult selectActonGroupByUserGroupId(String ugid) {

        ActiongroupExample.Criteria criteria = actiongroupExample.or();
        criteria.andUserGroupIdEqualTo(Integer.valueOf(ugid));
        List<Actiongroup> actiongroups = actiongroupMapper.selectByExample(actiongroupExample);
        if (actiongroups.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("权限映射失败");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
            data.put(AppContext.KEY_DATA, actiongroups);
            jsonResult.setData(data);
        }

        return jsonResult;
    }
}
