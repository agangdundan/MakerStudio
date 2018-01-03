package cn.it.phw.ms.controller;


import cn.it.phw.ms.common.Authority;
import cn.it.phw.ms.common.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Authority
@RequestMapping("/ms")
public class BaseController {

    JsonResult jsonResult = new JsonResult();

    Map<String, Object> dataMap = new HashMap<>();

}
