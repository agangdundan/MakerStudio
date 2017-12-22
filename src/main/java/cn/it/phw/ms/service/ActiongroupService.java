package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface ActiongroupService extends BaseService {

    /**
     *
     * @param ugid
     * @return
     */
    public JsonResult selectActonGroupByUserGroupId(String ugid);

}
