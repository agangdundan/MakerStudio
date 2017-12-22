package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.GroupmanagerMapper;
import cn.it.phw.ms.dao.mapper.UsergroupMapper;
import cn.it.phw.ms.pojo.Groupmanager;
import cn.it.phw.ms.pojo.GroupmanagerExample;
import cn.it.phw.ms.pojo.Usergroup;
import cn.it.phw.ms.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserGroupServiceImpl extends BaseServiceImpl implements UserGroupService {

    @Autowired
    private GroupmanagerMapper groupmanagerMapper;

    @Autowired
    private UsergroupMapper usergroupMapper;

    @Override
    public JsonResult selectTheMaxUserGroupByUserId(String uid) {

        GroupmanagerExample.Criteria criteria = groupmanagerExample.or();
        criteria.andUserIdEqualTo(Integer.valueOf(uid));
        List<Groupmanager> groupmanagers = groupmanagerMapper.selectByExample(groupmanagerExample);
        if (groupmanagers.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("您还没有任何用户组");
        } else {
            Integer sort = 0;
            for (Groupmanager groupmanager : groupmanagers) {
                Usergroup temp = usergroupMapper.selectByPrimaryKey(groupmanager.getUserGroupId());

            }
        }

        return jsonResult;
    }

    @Override
    public JsonResult selectUserGroupByPK(Integer userGroupId) {

        Usergroup usergroup =

        return null;
    }
}
