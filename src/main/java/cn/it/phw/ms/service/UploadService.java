package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService extends BaseService {

    JsonResult getUploadFileDetails();

    JsonResult doDownloadFile();

    JsonResult doDeleteFiles(List<Upload> files);

    JsonResult doUpdateFile(Upload file);

    JsonResult doUpdateFile(MultipartFile file);

    JsonResult doUploadImage(MultipartFile file);

    JsonResult doUploadFile(MultipartFile file);
}
