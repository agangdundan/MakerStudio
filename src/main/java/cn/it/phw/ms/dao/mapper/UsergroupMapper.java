package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Usergroup;
import cn.it.phw.ms.pojo.UsergroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsergroupMapper {
    long countByExample(UsergroupExample example);

    int deleteByExample(UsergroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usergroup record);

    int insertSelective(Usergroup record);

    List<Usergroup> selectByExample(UsergroupExample example);

    Usergroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usergroup record, @Param("example") UsergroupExample example);

    int updateByExample(@Param("record") Usergroup record, @Param("example") UsergroupExample example);

    int updateByPrimaryKeySelective(Usergroup record);

    int updateByPrimaryKey(Usergroup record);
}