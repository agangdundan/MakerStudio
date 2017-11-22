package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.ActionExample;
import cn.it.phw.ms.pojo.ActioncolumnExample;
import cn.it.phw.ms.pojo.UserExample;
import cn.it.phw.ms.pojo.UsergroupExample;
import cn.it.phw.ms.service.BaseService;

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
