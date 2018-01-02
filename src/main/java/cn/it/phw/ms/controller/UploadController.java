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

import java.io.File;

@Controller
public class UploadController extends BaseController {

    @Autowired
    private UploadService uploadService;

    @ResponseBody
    @PostMapping("/image")
    public JsonResult uploadImage(@RequestParam("file") MultipartFile file) {

        return uploadService.doUploadImage(file);
    }

    @ResponseBody
    @PostMapping("/file")
    public JsonResult uploadFile(@RequestParam("file") MultipartFile file) {
        return uploadService.doUploadFile(file);
    }

}
