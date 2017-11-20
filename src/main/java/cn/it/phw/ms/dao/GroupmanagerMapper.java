package cn.it.phw.ms.dao;

import cn.it.phw.ms.pojo.Groupmanager;
import cn.it.phw.ms.pojo.GroupmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupmanagerMapper {
    long countByExample(GroupmanagerExample example);

    int deleteByExample(GroupmanagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Groupmanager record);

    int insertSelective(Groupmanager record);

    List<Groupmanager> selectByExample(GroupmanagerExample example);

    Groupmanager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Groupmanager record, @Param("example") GroupmanagerExample example);

    int updateByExample(@Param("record") Groupmanager record, @Param("example") GroupmanagerExample example);

    int updateByPrimaryKeySelective(Groupmanager record);

    int updateByPrimaryKey(Groupmanager record);
}