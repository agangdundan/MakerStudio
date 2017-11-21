package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Upload;

import java.util.List;

public interface FileService extends BaseService {

    JsonResult doUploadFile(String path);

    JsonResult getUploadFileDetails();

    JsonResult doDownloadFile();

    JsonResult doDeleteFile(Upload file);

    JsonResult doDeleteFiles(List<Upload> files);

    JsonResult doUpdateFile(Upload file);


}
