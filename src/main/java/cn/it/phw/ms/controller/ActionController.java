package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Action;
import cn.it.phw.ms.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ms")
public class ActionController extends BaseController {

    @Autowired
    private ActionService actionService;

    @ResponseBody
    @GetMapping("/actions")
    public JsonResult findAllActions() {
        return actionService.selectAllActions();
    }

    @ResponseBody
    @PutMapping("/action")
    public JsonResult addAction(Action action) {
        return actionService.insertAction(action);
    }

    @ResponseBody
    @DeleteMapping("/action/{id}")
    public JsonResult deleteAction(@PathVariable("id") Integer id) {
        return actionService.deleteActonByPK(id);
    }

    @ResponseBody
    @PostMapping("/action")
    public JsonResult updateActionByPK(Action action) {
        return actionService.updateActionByPK(action);
    }


}
