package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.Systemmessage;
import cn.it.pwh.ms.pojo.User;

public interface SystemMessageService extends BaseService {

    JsonResult doAddNewMsg(Systemmessage systemmessage);

    JsonResult doUpdateMsg(Systemmessage systemmessage);

    JsonResult doSendMsg(Systemmessage systemmessage);

    JsonResult doDeleteMsg(Systemmessage systemmessage);

    JsonResult getAllMsgs();

    JsonResult findMsgByKeywords(String keywords);

    JsonResult findMsgByAdmin(User user);

}
