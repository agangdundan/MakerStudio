package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.Learningplanform;

public interface LearningPlanService extends BaseService {

    JsonResultForLayui getLearningPlanTemplate();

    JsonResult doAddLearningPlanForm(Learningplanform form);

    JsonResult doUpdateLearningPlanForm(Learningplanform form);

    JsonResult doDeleteLearningPlanForm(Learningplanform form);

    JsonResult doApproveLearningPlanForm(Learningplanform form);

    JsonResult doAddLearningPlanColumn(Learningplancolumn column);

    JsonResult doUpdateLearningPlanColumn(Learningplancolumn column);

    JsonResult doDeleteLearningPlanColumn(Integer id);

    JsonResult doFindLearningPlanFormByUsername(String username);

    JsonResult doFindLearningPlanTemplateByPK(Integer id);

    JsonResultForLayui findAllLearningPlanForms();

    /**
     * 根据主键查找规划表
     * @param id 主键id
     * @return 规划表
     */
    JsonResult findLearningPlanByPK(Integer id);
}
