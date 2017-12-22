package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface UserGroupService extends BaseService {

    /**
     * 根据用户id获取出用户所有的权限组
     * 并且根据冒泡排序法取出权限最大的用户组
     * @param uid 用户id
     * @return 权限最大的用户组
     */
    public JsonResult selectTheMaxUserGroupByUserId(String uid);

    public JsonResult selectUserGroupByPK(Integer userGroupId);
}
