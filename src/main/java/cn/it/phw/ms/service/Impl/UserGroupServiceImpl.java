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
            List<Usergroup> usergroups = new ArrayList<>();
            for (Groupmanager groupmanager : groupmanagers) {
                Usergroup temp = usergroupMapper.selectByPrimaryKey(groupmanager.getUserGroupId());
                usergroups.add(temp);
            }

            for (int n = 0; n < usergroups.size(); n++) {

                for (int m = 0; m < usergroups.size() - 1; m++) {
                    Usergroup temp;
                    Usergroup temp1 = usergroups.get(m);
                    Usergroup temp2 = usergroups.get(m + 1);
                    if (temp1.getSort() < temp2.getSort()) {
                        temp = temp2;
                        temp2 = temp1;
                        temp1 = temp;
                    }
                }

            }
            //取最大的
            Usergroup usergroup = usergroups.get(usergroups.size() - 1);
            jsonResult.setMessage("OK");
            jsonResult.setStatus(200);
            data.put(AppContext.KEY_DATA, usergroup);
            jsonResult.setData(data);
        }

        return jsonResult;
    }

    @Override
    public JsonResult selectUserGroupByPK(Integer userGroupId) {

        Usergroup usergroup = usergroupMapper.selectByPrimaryKey(userGroupId);
        jsonResult.setStatus(200);
        jsonResult.setMessage("OK");
        data.put(AppContext.KEY_DATA, usergroup);
        jsonResult.setData(data);

        return jsonResult;
    }
}
