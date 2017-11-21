package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Systemmessage;
import cn.it.phw.ms.pojo.SystemmessageExample;
import cn.it.phw.ms.pojo.SystemmessageWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SystemmessageMapper {
    long countByExample(SystemmessageExample example);

    int deleteByExample(SystemmessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemmessageWithBLOBs record);

    int insertSelective(SystemmessageWithBLOBs record);

    List<SystemmessageWithBLOBs> selectByExampleWithBLOBs(SystemmessageExample example);

    List<Systemmessage> selectByExample(SystemmessageExample example);

    SystemmessageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemmessageWithBLOBs record, @Param("example") SystemmessageExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemmessageWithBLOBs record, @Param("example") SystemmessageExample example);

    int updateByExample(@Param("record") Systemmessage record, @Param("example") SystemmessageExample example);

    int updateByPrimaryKeySelective(SystemmessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemmessageWithBLOBs record);

    int updateByPrimaryKey(Systemmessage record);
}