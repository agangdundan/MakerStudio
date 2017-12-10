package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Systemmessage;
import cn.it.phw.ms.pojo.User;
import org.springframework.http.HttpRequest;

public interface SystemMessageService extends BaseService {

    JsonResult doAddNewMsg(Systemmessage systemmessage, Integer uid);

    JsonResult doUpdateMsg(Systemmessage systemmessage);

    JsonResult doSendMsg(Systemmessage systemmessage);

    JsonResult doDeleteMsg(Systemmessage systemmessage);

    JsonResult getAllMsgs();

    JsonResult findMsgByKeywords(String keywords);

    JsonResult findMsgByAdmin(User user);

    JsonResult getNewestMsg();
}
