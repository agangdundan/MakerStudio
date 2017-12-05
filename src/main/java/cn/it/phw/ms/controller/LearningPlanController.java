package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.common.JsonResultForLayui;
import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.Learningplancolumnmanager;
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
    @PutMapping("/learningplan")
    public JsonResult doFillLearningPlanFrom(Learningplanform form) {
        return learningPlanService.doAddLearningPlanForm(form);
    }

    @ResponseBody
    @DeleteMapping("/learningplan")
    public JsonResult doDeleteLearningPlanForm(Learningplanform form) {
        return learningPlanService.doDeleteLearningPlanForm(form);
    }

    @ResponseBody
    @PostMapping("/learningplan")
    public JsonResult doUpdateLearningPlanForm(Learningplanform form) {
        return learningPlanService.doUpdateLearningPlanForm(form);
    }

    @ResponseBody
    @GetMapping("/learningplan")
    public JsonResult doFindLearningPlanByUid(@RequestParam String token) {
        return learningPlanService.findLearningPlanByUid(token);
    }

    @ResponseBody
    @GetMapping("/learningplan/{id}")
    public JsonResult doFindLearningPlanByPK(@PathVariable("id") Integer id) {
        return learningPlanService.findLearningPlanByPK(id);
    }

    @ResponseBody
    @GetMapping("/learningplans")
    public JsonResult findAllLearningPlanForm() {
        return learningPlanService.findAllLearningPlanForms();
    }

    @ResponseBody
    @DeleteMapping("/learningplan/template/{id}")
    public JsonResult doDeleteLearningPlanTemplateByPK(@PathVariable("id") Integer id) {
        return learningPlanService.doDeleteLearningPlanColumn(id);
    }

    @ResponseBody
    @GetMapping("/learningplan/template")
    public JsonResult findLearningPlanTemplate() {
        return learningPlanService.getLearningPlanTemplate();
    }

    @ResponseBody
    @GetMapping("/learningplan/template/{id}")
    public JsonResult findLearningPlanTemplateByPK(@PathVariable("id") Integer id) {
        return learningPlanService.doFindLearningPlanTemplateByPK(id);
    }

    @ResponseBody
    @PutMapping("/learningplan/template")
    public JsonResult addLearningPlanColumn(Learningplancolumn learningplancolumn) {
        return learningPlanService.doAddLearningPlanColumn(learningplancolumn);
    }

    @ResponseBody
    @PostMapping("/learningplan/template")
    public JsonResult updateLearningPlanTemplate(Learningplancolumn learningplancolumn) {
        return learningPlanService.doUpdateLearningPlanColumn(learningplancolumn);
    }

    @ResponseBody
    @PostMapping("/learningplan/approve")
    public JsonResult doApproveLearningPlanForm(Learningplanform learningplanform) {
        return learningPlanService.doApproveLearningPlanForm(learningplanform);
    }

    @ResponseBody
    @PostMapping("/learningplancolumn/content")
    public JsonResult saveLearningPlanColumnContent(Learningplancolumnmanager learningplancolumnmanager) {
        return learningPlanService.doSaveLearningPlanColumnContent(learningplancolumnmanager);
    }

}
