package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.common.JwtUtils;
import cn.it.phw.ms.dao.mapper.LearningplancolumnMapper;
import cn.it.phw.ms.dao.mapper.LearningplancolumnmanagerMapper;
import cn.it.phw.ms.dao.mapper.LearningplanformMapper;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.*;
import cn.it.phw.ms.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class LearningPlanServiceImpl extends BaseServiceImpl implements LearningPlanService {

    @Autowired
    private LearningplanformMapper learningplanformMapper;

    @Autowired
    private LearningplancolumnMapper learningplancolumnMapper;

    @Autowired
    private LearningplancolumnmanagerMapper learningplancolumnmanagerMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult getLearningPlanTemplate() {

        List<Learningplancolumn> learningplancolumns = learningplancolumnMapper.selectByExample(null);
        if (learningplancolumns.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("模板还未设置，请先通知教师设置模板在填写！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, learningplancolumns);
            jsonResult.setData(data);
            jsonResult.setCount(learningplancolumns.size());
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

        Learningplanform oldForm = learningplanformMapper.selectByPrimaryKey(form.getId());
        if (form.getIsshare() != null) {
            oldForm.setIsshare(form.getIsshare());
        }
        if (form.getStatus() != null) {
            oldForm.setStatus(form.getStatus());
        }
        if (form.getApproveContent() != null) {
            oldForm.setApproveContent(form.getApproveContent());
        }
        int result = learningplanformMapper.updateByPrimaryKey(oldForm);
        if (result == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未更新任何记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("成功更新了" + result + "条记录！");
        }

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

        Learningplanform oldForm = learningplanformMapper.selectByPrimaryKey(form.getId());
        if (form.getApproveContent() != null) {
            oldForm.setApproveContent(form.getApproveContent());
        }
        oldForm.setApproveContent(form.getApproveContent());
        oldForm.setStatus(1);
        int result = learningplanformMapper.updateByPrimaryKey(oldForm);
        if (result == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未更新任何记录！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("成功审批" + result + "条记录！");
        }
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
    public JsonResult doDeleteLearningPlanColumn(Integer id) {
        learningplancolumnMapper.deleteByPrimaryKey(id);
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

    @Override
    public JsonResult doFindLearningPlanTemplateByPK(Integer id) {
        Learningplancolumn learningplancolumn = learningplancolumnMapper.selectByPrimaryKey(id);
        if (learningplancolumn != null) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, learningplancolumn);
            jsonResult.setData(data);
        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未查找到任何数据！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult findAllLearningPlanForms() {
        List<Learningplanform> learningplanforms = learningplanformMapper.selectByExample(null);
        if (learningplanforms.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未查找到任何记录！");
        } else {
            jsonResult.setStatus(0);
            jsonResult.setMessage("加载完成");
            jsonResult.setCount(learningplanforms.size());
            data.put(AppContext.KEY_DATA, learningplanforms);
            jsonResult.setData(data);
        }
        return jsonResult;
    }

    @Override
    public JsonResult findLearningPlanByPK(Integer id) {

        /**
         * 先查找出规划表
         */
        Learningplanform form = learningplanformMapper.selectByPrimaryKey(id);
        if (form == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未找到任何规划表记录！");
            return jsonResult;
        }
        data.put(AppContext.KEY_CODE, form);

        /**
         * 再查找填写人
         */
        User user = userMapper.selectByPrimaryKey(form.getUserId());
        if (user == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("填写人不存在！");
            return jsonResult;
        }
        data.put(AppContext.KEY_USER, user);

        /**
         * 最后查找规划表详细信息
         */
        LearningplancolumnmanagerExample.Criteria criteria = learningplancolumnmanagerExample.or();
        criteria.andLearningplanformIdEqualTo(id);
        List<Learningplancolumnmanager> learningplancolumnmanagers =
                learningplancolumnmanagerMapper.selectByExampleWithBLOBs(learningplancolumnmanagerExample);

        if (learningplancolumnmanagers.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("规划表还未填写完整！");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
        }
        data.put(AppContext.KEY_DATA, learningplancolumnmanagers);
        jsonResult.setData(data);

        return jsonResult;
    }

    @Override
    public JsonResult findLearningPlanByUid(String uid) {

        LearningplanformExample.Criteria criteria = learningplanformExample.or();
        criteria.andUserIdEqualTo(Integer.valueOf(uid));
        List<Learningplanform> learningplanforms = learningplanformMapper.selectByExample(learningplanformExample);
        if (learningplanforms.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("您还没有填写任何规划表！");
        } else {
            Learningplanform learningplanform = learningplanforms.get(0);
            jsonResult = findLearningPlanByPK(learningplanform.getId());
        }

        return jsonResult;
    }

    @Override
    public JsonResult doSaveLearningPlanColumnContent(Learningplancolumnmanager learningplancolumnmanager) {

        if (learningplancolumnmanager.getId() == null) {
            String learningplancolumnName = learningplancolumnmanager.getLearningplancolumnName();
            LearningplancolumnExample.Criteria criteria = learningplancolumnExample.or();
            criteria.andLearningplancolumnNameEqualTo(learningplancolumnName);
            List<Learningplancolumn> learningplancolumns = learningplancolumnMapper.selectByExample(learningplancolumnExample);
            if (learningplancolumns.size() == 0) {
                jsonResult.setStatus(500);
                jsonResult.setMessage("错误：列名不存在！");
                return jsonResult;
            } else {
                Learningplancolumn learningplancolumn = learningplancolumns.get(0);
                learningplancolumnmanager.setLearningplancolumnId(learningplancolumn.getId());
                learningplancolumnmanagerMapper.insert(learningplancolumnmanager);
            }
        } else {
            learningplancolumnmanagerMapper.updateByPrimaryKeyWithBLOBs(learningplancolumnmanager);
        }
        jsonResult.setStatus(200);
        jsonResult.setMessage("最近保存时间" + new Date(System.currentTimeMillis()));

        return jsonResult;
    }

}
