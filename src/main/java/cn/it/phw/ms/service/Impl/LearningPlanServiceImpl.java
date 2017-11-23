package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.LearningplancolumnMapper;
import cn.it.phw.ms.dao.mapper.LearningplanformMapper;
import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.Learningplanform;
import cn.it.phw.ms.pojo.LearningplanformExample;
import cn.it.phw.ms.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LearningPlanServiceImpl extends BaseServiceImpl implements LearningPlanService {

    @Autowired
    private LearningplanformMapper learningplanformMapper;

    @Autowired
    private LearningplancolumnMapper learningplancolumnMapper;

    @Override
    public JsonResult getLearningPlanTemplate() {

        List<Learningplancolumn> learningplancolumns = learningplancolumnMapper.selectByExample(null);
        if (learningplancolumns.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("模板还未设置，请先通知教师设置模板在填写！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("获取模板成功！");
            data.put(AppContext.KEY_DATA, learningplancolumns);
            jsonResult.setData(data);
        }

        return jsonResult;
    }

    @Override
    public JsonResult doAddLearningPlanForm(Learningplanform form) {

        learningplanformMapper.insert(form);
        jsonResult.setStatus(200);
        jsonResult.setMessage("填写完成！");

        return jsonResult;
    }

    @Override
    public JsonResult doUpdateLearningPlanForm(Learningplanform form) {
        int result = learningplanformMapper.updateByPrimaryKey(form);
        jsonResult.setMessage("成功更新" + result + "条记录！");
        jsonResult.setStatus(200);
        return jsonResult;
    }

    @Override
    public JsonResult doDeleteLearningPlanForm(Learningplanform form) {
        int result = learningplanformMapper.deleteByPrimaryKey(form.getId());
        jsonResult.setStatus(200);
        jsonResult.setMessage("成功删除" + result + "条记录！");
        return jsonResult;
    }

    @Override
    public JsonResult doApproveLearningPlanForm(Learningplanform form) {
        int result = learningplanformMapper.updateByPrimaryKey(form);
        jsonResult.setStatus(200);
        jsonResult.setMessage("成功审批" + result + "条记录！");
        return jsonResult;
    }

    @Override
    public JsonResult doAddLearningPlanColumn(Learningplancolumn column) {
        learningplancolumnMapper.insert(column);
        jsonResult.setStatus(200);
        jsonResult.setMessage("添加成功！");
        return jsonResult;
    }

    @Override
    public JsonResult doUpdateLearningPlanColumn(Learningplancolumn column) {
        learningplancolumnMapper.updateByPrimaryKey(column);
        jsonResult.setStatus(200);
        jsonResult.setMessage("更新成功！");
        return jsonResult;
    }

    @Override
    public JsonResult doDeleteLearningPlanColumn(Learningplancolumn column) {
        learningplancolumnMapper.deleteByPrimaryKey(column.getId());
        jsonResult.setStatus(200);
        jsonResult.setMessage("删除成功！");
        return jsonResult;
    }

    @Override
    public JsonResult doFindLearningPlanFormByUsername(String username) {
        LearningplanformExample.Criteria criteria = learningplanformExample.or();
        criteria.andUsernameEqualTo(username);
        List<Learningplanform> learningplanforms = learningplanformMapper.selectByExample(learningplanformExample);
        if (learningplanforms.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未找到任何记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("查找到" + learningplanforms.size() + "条记录！");
            data.put(AppContext.KEY_DATA, learningplanforms);
            jsonResult.setData(data);
        }
        return jsonResult;
    }

}
