package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Action;

import java.util.List;

public interface ActionService extends BaseService {

    public JsonResult selectActionByUserGroupId(Integer ugid);

    /**
     * 根据权算法验证权限
     * @param actions 要验证的权限
     * @param uid 当前用户
     * @return jsonResult
     */
    public JsonResult verifyActions(Integer uid, List<Action> actions);

}
