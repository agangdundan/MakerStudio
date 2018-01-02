package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface ActionManagerService extends BaseService {

    /**
     * Distribute actions to user group
     * @param adminId
     * @param actionIds
     * @param ugId
     * @return
     */
    JsonResult distributeActionToUserGroup(Integer adminId, Integer ugId, String[] actionIds);

    /**
     * Select Action-UserGroup Mapping by User id
     * @param uid
     * @return
     */
    JsonResult selectActionGroupsByUid(Integer uid);

}
