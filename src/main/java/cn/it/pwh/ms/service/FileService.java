package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.Upload;

import java.util.List;

public interface FileService extends BaseService {

    JsonResult doUploadFile(String path);

    JsonResult getUploadFileDetails();

    JsonResult doDownloadFile();

    JsonResult doDeleteFile(Upload file);

    JsonResult doDeleteFiles(List<Upload> files);

    JsonResult doUpdateFile(Upload file);


}
