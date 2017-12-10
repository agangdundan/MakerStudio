package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.SystemmessageMapper;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.Systemmessage;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.service.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SystemMessageServiceImpl extends BaseServiceImpl implements SystemMessageService {

    @Autowired
    private SystemmessageMapper systemmessageMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult doAddNewMsg(Systemmessage systemmessage, Integer uid) {
        systemmessage.setStatus(0);
        systemmessage.setCreateTime(new Date(System.currentTimeMillis()));
        User user = userMapper.selectByPrimaryKey(uid);
        if (user != null) {
            systemmessage.setAdminId(uid);
            systemmessage.setAdminName(user.getUsername());
            systemmessageMapper.insert(systemmessage);
            jsonResult.setStatus(200);
            jsonResult.setMessage("添加完成");
        } else {
            jsonResult.setStatus(500);
            jsonResult.setMessage("错误：用户不存在！");
        }
        return jsonResult;
    }

    @Override
    public JsonResult doUpdateMsg(Systemmessage systemmessage) {
        Systemmessage oldMsg = systemmessageMapper.selectByPrimaryKey(systemmessage.getId());
        if (oldMsg == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("记录不存在！");
        } else {
            if (systemmessage.getAdminId() != null) {
                oldMsg.setAdminId(systemmessage.getAdminId());
            }
            if (systemmessage.getAdminName() != null) {
                oldMsg.setAdminName(systemmessage.getAdminName());
            }
            if (systemmessage.getCreateTime() != null) {
                oldMsg.setCreateTime(systemmessage.getCreateTime());
            }
            if (systemmessage.getMessage() != null) {
                oldMsg.setMessage(systemmessage.getMessage());
            }
            if (systemmessage.getStatus() != null) {
                oldMsg.setStatus(systemmessage.getStatus());
            }
            systemmessageMapper.updateByPrimaryKeyWithBLOBs(oldMsg);
            jsonResult.setStatus(200);
            jsonResult.setMessage("更新完成");
        }

        return jsonResult;
    }

    @Override
    public JsonResult doSendMsg(Systemmessage systemmessage) {
        return null;
    }

    @Override
    public JsonResult doDeleteMsg(Systemmessage systemmessage) {
        return null;
    }

    @Override
    public JsonResult getAllMsgs() {
        return null;
    }

    @Override
    public JsonResult findMsgByKeywords(String keywords) {
        return null;
    }

    @Override
    public JsonResult findMsgByAdmin(User user) {
        return null;
    }

    @Override
    public JsonResult getNewestMsg() {
        systemmessageExample.setOrderByClause("create_time");

        List<Systemmessage> systemmessages = systemmessageMapper.selectByExampleWithBLOBs(systemmessageExample);
        if (systemmessages.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("当前系统还没有添加任何通知");
        } else {
            Systemmessage systemmessage = systemmessages.get(systemmessages.size() - 1);
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            data.put(AppContext.KEY_DATA, systemmessage);
            jsonResult.setData(data);
        }
        return jsonResult;
    }
}
