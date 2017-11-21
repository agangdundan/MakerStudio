package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;

public interface AuthService extends BaseService {

    JsonResult doCheckAuth();

}
