package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;

public interface AuthService extends BaseService {

    JsonResult doCheckAuth();

}
