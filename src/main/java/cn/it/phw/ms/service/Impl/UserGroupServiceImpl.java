package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.GroupmanagerMapper;
import cn.it.phw.ms.pojo.Groupmanager;
import cn.it.phw.ms.pojo.GroupmanagerExample;
import cn.it.phw.ms.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserGroupServiceImpl extends BaseServiceImpl implements UserGroupService {

    @Autowired
    private GroupmanagerMapper groupmanagerMapper;

    @Override
    public JsonResult selectUserGroupByUserId(String uid) {

        GroupmanagerExample.Criteria criteria = groupmanagerExample.or();
        criteria.andUserIdEqualTo(Integer.valueOf(uid));
        List<Groupmanager> groupmanagers = groupmanagerMapper.selectByExample(groupmanagerExample);
        if (groupmanagers.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("您还没有任何用户组");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("OK");
            data.put(AppContext.KEY_DATA, groupmanagers);
            jsonResult.setData(data);
        }

        return jsonResult;
    }
}
