package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.Authority;
import cn.it.phw.ms.common.AuthorityType;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Systemmessage;
import cn.it.phw.ms.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SystemManagerController extends BaseController {

    @Autowired
    private SystemMessageService systemMessageService;

    @ResponseBody
    @GetMapping("/msg/newest")
    @Authority(AuthorityType.NoValidate)
    public JsonResult getNewestMessage() {
        return systemMessageService.getNewestMsg();
    }

    @ResponseBody
    @PutMapping("/msg")
    public JsonResult addSystemMessage(HttpServletRequest request, Systemmessage systemmessage) {
        return systemMessageService.doAddNewMsg(systemmessage, (Integer) request.getAttribute(AppContext.KEY_USER));
    }

    @ResponseBody
    @PostMapping("/msg")
    public JsonResult updateSystemMessage(Systemmessage systemmessage) {
        return systemMessageService.doUpdateMsg(systemmessage);
    }

}
