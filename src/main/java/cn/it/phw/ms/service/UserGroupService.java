package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface UserGroupService extends BaseService {

    public JsonResult selectTheMaxUserGroupByUserId(String uid);

    public JsonResult selectUserGroupByPK(Integer userGroupId);
}
