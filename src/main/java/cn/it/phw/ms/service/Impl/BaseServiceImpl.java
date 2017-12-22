package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.*;
import cn.it.phw.ms.service.BaseService;

import java.util.HashMap;
import java.util.Map;

public class BaseServiceImpl implements BaseService {

    public JsonResult jsonResult = new JsonResult();

    public JsonResultForLayui jsonResultForLayui = new JsonResultForLayui();

    public Map<String, Object> data = new HashMap<>();

    public UserExample userExample = new UserExample();

    public UsergroupExample usergroupExample = new UsergroupExample();

    public LearningplanformExample learningplanformExample = new LearningplanformExample();

    public LearningplancolumnExample learningplancolumnExample = new LearningplancolumnExample();

    public LearningplancolumnmanagerExample learningplancolumnmanagerExample = new LearningplancolumnmanagerExample();

    public ActionExample actionExample = new ActionExample();

    public ActioncolumnExample actioncolumnExample = new ActioncolumnExample();

    public SystemmessageExample systemmessageExample = new SystemmessageExample();

    public GroupmanagerExample groupmanagerExample = new GroupmanagerExample();

    public ActiongroupExample actiongroupExample = new ActiongroupExample();

}
