package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.User;

public interface AuthService extends BaseService {

    JsonResult doCheckAuth();

    /**
     * 根据用户来获取用户组权限
     * @param user 传入的用户
     * @return 权限字符串
     */
    JsonResult getAuthsByUser(User user);

}
