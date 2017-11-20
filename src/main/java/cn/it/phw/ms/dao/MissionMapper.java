package cn.it.phw.ms.dao;

import cn.it.phw.ms.pojo.Mission;
import cn.it.phw.ms.pojo.MissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MissionMapper {
    long countByExample(MissionExample example);

    int deleteByExample(MissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mission record);

    int insertSelective(Mission record);

    List<Mission> selectByExampleWithBLOBs(MissionExample example);

    List<Mission> selectByExample(MissionExample example);

    Mission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mission record, @Param("example") MissionExample example);

    int updateByExampleWithBLOBs(@Param("record") Mission record, @Param("example") MissionExample example);

    int updateByExample(@Param("record") Mission record, @Param("example") MissionExample example);

    int updateByPrimaryKeySelective(Mission record);

    int updateByPrimaryKeyWithBLOBs(Mission record);

    int updateByPrimaryKey(Mission record);
}