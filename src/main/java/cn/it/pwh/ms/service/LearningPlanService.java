package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.Learningplancolumn;
import cn.it.pwh.ms.pojo.Learningplanform;

public interface LearningPlanService extends BaseService {

    JsonResult getLearningPlanTemplate();

    JsonResult doAddLearningPlanForm(Learningplanform form);

    JsonResult doUpdateLearningPlanForm(Learningplanform form);

    JsonResult doDeleteLearningPlanForm(Learningplanform form);

    JsonResult doApproveLearningPlanForm(Learningplanform form);

    JsonResult doUpdateLearningPlanColumn(Learningplancolumn column);

}
