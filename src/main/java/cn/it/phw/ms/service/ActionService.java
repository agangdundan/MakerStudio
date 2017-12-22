package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface ActionService extends BaseService {

    public JsonResult selectActionByUserGroupId(Integer ugid);

}
