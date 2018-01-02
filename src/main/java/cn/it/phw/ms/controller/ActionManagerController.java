package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.Authority;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.service.ActionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActionManagerController extends BaseController {

    @Autowired
    private ActionManagerService actionManagerService;

    @ResponseBody
    @PutMapping("/actiongroup")
    public JsonResult addActionGroup(@RequestParam("ids") String ids,
                                        @RequestParam("ugId") Integer ugId,
                                            HttpServletRequest request) {

        if (StringUtils.isEmpty(ids) || ugId == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("参数错误");
        } else {
            String[] actionIds = ids.split(",");
            if (actionIds.length == 0) {
                jsonResult.setStatus(500);
                jsonResult.setMessage("参数有误");
            } else {
                String adminId = (String) request.getAttribute(AppContext.KEY_ID);
                jsonResult = actionManagerService.distributeActionToUserGroup(Integer.valueOf(adminId), ugId, actionIds);
            }
        }

        return jsonResult;
    }


    @ResponseBody
    @GetMapping("/usergroup")
    public JsonResult getActionGroupsByUid(Integer ugId) {
        return actionManagerService.selectActionGroupsByUid(ugId);
    }

}
