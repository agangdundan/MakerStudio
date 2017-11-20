package cn.it.pwh.ms.dao.mapper;

import cn.it.pwh.ms.pojo.Missionmanager;
import cn.it.pwh.ms.pojo.MissionmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MissionmanagerMapper {
    long countByExample(MissionmanagerExample example);

    int deleteByExample(MissionmanagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Missionmanager record);

    int insertSelective(Missionmanager record);

    List<Missionmanager> selectByExample(MissionmanagerExample example);

    Missionmanager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Missionmanager record, @Param("example") MissionmanagerExample example);

    int updateByExample(@Param("record") Missionmanager record, @Param("example") MissionmanagerExample example);

    int updateByPrimaryKeySelective(Missionmanager record);

    int updateByPrimaryKey(Missionmanager record);
}