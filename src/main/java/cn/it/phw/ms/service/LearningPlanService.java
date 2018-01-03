package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.Learningplancolumnmanager;
import cn.it.phw.ms.pojo.Learningplanform;

public interface LearningPlanService extends BaseService {

    JsonResult getLearningPlanTemplate();

    JsonResult doAddLearningPlanForm(Learningplanform form);

    JsonResult doUpdateLearningPlanForm(Learningplanform form);

    JsonResult doDeleteLearningPlanForm(Learningplanform form);

    /**
     * 审批一张规划表
     * @param form 规划表
     * @return 结果
     */
    JsonResult doApproveLearningPlanForm(Learningplanform form);

    JsonResult doAddLearningPlanColumn(Learningplancolumn column);

    JsonResult doUpdateLearningPlanColumn(Learningplancolumn column);

    JsonResult doDeleteLearningPlanColumn(Integer id);

    JsonResult doFindLearningPlanFormByUsername(String username);

    JsonResult doFindLearningPlanTemplateByPK(Integer id);

    JsonResult findAllLearningPlanForms();

    /**
     * 根据主键查找规划表
     *
     * 首先查询规划表记录
     *
     * 再根据规划表查询用户
     *
     * 最后根据用户ID和规划表ID查找规划表内容
     *
     * @param id 主键id
     * @return 规划表
     */
    JsonResult findLearningPlanByPK(Integer id);

    JsonResult findLearningPlanByUid(String uid);

    JsonResult doSaveLearningPlanColumnContent(Learningplancolumnmanager learningplancolumnmanager);
}
