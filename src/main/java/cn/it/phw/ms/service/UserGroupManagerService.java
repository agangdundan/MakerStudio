package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Groupmanager;

public interface UserGroupManagerService extends BaseService {

    /**
     * Insert UserGroupManager Record
     * @param groupmanager
     * @return
     */
    JsonResult insertUserGroupManager(Groupmanager groupmanager, Integer adminId);

    JsonResult selectGroupManagerByUGId(Integer UGId);
}
