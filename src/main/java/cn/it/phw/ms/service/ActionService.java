package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Action;

import java.util.List;

public interface ActionService extends BaseService {

    public JsonResult selectActionByUserGroupId(Integer ugid);

    public JsonResult verifyActions(Integer userId, String url, String type);

    public JsonResult selectActionByActionStr(String action);

    public JsonResult selectAllActions();

    public JsonResult insertAction(Action action);

    public JsonResult updateActionByPK(Action action);

    public JsonResult deleteActonByPK(Integer id);

}
