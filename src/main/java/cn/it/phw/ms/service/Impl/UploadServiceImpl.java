package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.UploadMapper;
import cn.it.phw.ms.pojo.Upload;
import cn.it.phw.ms.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UploadServiceImpl extends BaseServiceImpl implements UploadService {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UploadMapper uploadMapper;

    @Override
    public JsonResult getUploadFileDetails() {
        return null;
    }

    @Override
    public JsonResult doDownloadFile() {
        return null;
    }

    @Override
    public JsonResult doDeleteFiles(List<Upload> files) {
        return null;
    }

    @Override
    public JsonResult doUpdateFile(Upload file) {
        return null;
    }

    @Override
    public JsonResult doUpdateFile(MultipartFile file) {
        return null;
    }

    @Override
    public JsonResult doUploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            jsonResult.setStatus(200);
            jsonResult.setMessage("文件不能为空！");
        } else {

            try {
                Upload upload = new Upload();
                upload.setContenttype(file.getContentType());
                upload.setCreateTime(new Date(System.currentTimeMillis()));
                upload.setDownloadtime(0);
                String originName = file.getOriginalFilename();
                upload.setFilename(UUID.randomUUID() + String.valueOf(System.currentTimeMillis())
                        + originName.substring(originName.lastIndexOf(".")));
                upload.setVisiable(0);

                String localPath = request.getServletContext().getRealPath("/" + upload.getFilename());
                System.out.println(localPath);
                file.transferTo(new File(localPath));
                upload.setLocalpath(localPath);

                upload.setUrl("");
                upload.setUploadUserId(1);
                upload.setUploadUsername("");
            } catch (IOException e) {
                e.printStackTrace();
                jsonResult.setStatus(500);
                jsonResult.setMessage("上传错误：" + e.getMessage());
                return jsonResult;
            }
        }

        return jsonResult;
    }

}
