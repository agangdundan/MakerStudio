package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.Learningplanform;

public interface LearningPlanService extends BaseService {

    JsonResult getLearningPlanTemplate();

    JsonResult doAddLearningPlanForm(Learningplanform form);

    JsonResult doUpdateLearningPlanForm(Learningplanform form);

    JsonResult doDeleteLearningPlanForm(Learningplanform form);

    JsonResult doApproveLearningPlanForm(Learningplanform form);

    JsonResult doAddLearningPlanColumn(Learningplancolumn column);

    JsonResult doUpdateLearningPlanColumn(Learningplancolumn column);

    JsonResult doDeleteLearningPlanColumn(Learningplancolumn column);

    JsonResult doFindLearningPlanFormByUsername(String username);

}
