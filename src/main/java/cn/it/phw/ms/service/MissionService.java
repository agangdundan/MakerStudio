package cn.it.phw.ms.service;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Mission;
import cn.it.phw.ms.pojo.User;

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
