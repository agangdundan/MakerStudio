package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.Mission;
import cn.it.pwh.ms.pojo.User;

import java.util.List;

public interface MissionService extends BaseService {

    JsonResult doAddMission(Mission mission);

    JsonResult doUpdateMission(Mission mission);

    JsonResult doDeleteMission(Mission mission);

    JsonResult doDeleteMissions(List<Mission> missions);

    JsonResult findMissionByAdmin(User user);

    JsonResult findMissionByKeywords(String keywords);

    JsonResult doWriteDuty(String duty);

    JsonResult doCompleteMission();

}
