package cn.it.pwh.ms.service.Impl;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.*;
import cn.it.pwh.ms.service.BaseService;

import java.util.HashMap;
import java.util.Map;

public class BaseServiceImpl implements BaseService {

    public JsonResult jsonResult = new JsonResult();

    public Map<String, Object> data = new HashMap<>();

    public UserExample userExample = new UserExample();

    public UsergroupExample usergroupExample = new UsergroupExample();

    public ActionExample actionExample = new ActionExample();

    public ActioncolumnExample actioncolumnExample = new ActioncolumnExample();

}
