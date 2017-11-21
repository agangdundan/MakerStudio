package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Actiongroup;
import cn.it.phw.ms.pojo.ActiongroupExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ActiongroupMapper {
    long countByExample(ActiongroupExample example);

    int deleteByExample(ActiongroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Actiongroup record);

    int insertSelective(Actiongroup record);

    List<Actiongroup> selectByExampleWithBLOBs(ActiongroupExample example);

    List<Actiongroup> selectByExample(ActiongroupExample example);

    Actiongroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Actiongroup record, @Param("example") ActiongroupExample example);

    int updateByExampleWithBLOBs(@Param("record") Actiongroup record, @Param("example") ActiongroupExample example);

    int updateByExample(@Param("record") Actiongroup record, @Param("example") ActiongroupExample example);

    int updateByPrimaryKeySelective(Actiongroup record);

    int updateByPrimaryKeyWithBLOBs(Actiongroup record);

    int updateByPrimaryKey(Actiongroup record);
}