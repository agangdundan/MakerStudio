package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ms")
public class UploadController extends BaseController {

    @Autowired
    private UploadService uploadService;

    @ResponseBody
    @PostMapping("/file")
    public JsonResult uploadFile(@RequestParam("file")MultipartFile file) {

        return uploadService.doUploadFile(file);
    }

}
