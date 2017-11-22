package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Learningplanform;
import cn.it.phw.ms.service.LearningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ms")
public class LearningPlanController extends BaseController {

    @Autowired
    private LearningPlanService learningPlanService;

    @ResponseBody
    @PutMapping
    public JsonResult doFillLearningPlanFrom(Learningplanform form) {
        return learningPlanService.doAddLearningPlanForm(form);
    }

    @ResponseBody
    @DeleteMapping
    public JsonResult doDeleteLearningPlanForm(Learningplanform form) {
        return learningPlanService.doDeleteLearningPlanForm(form);
    }

    @ResponseBody
    @PostMapping
    public JsonResult doUpdateLearningPlanForm(Learningplanform form) {
        return learningPlanService.doUpdateLearningPlanForm(form);
    }


}
