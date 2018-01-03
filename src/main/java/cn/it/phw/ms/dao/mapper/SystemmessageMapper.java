package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Systemmessage;
import cn.it.phw.ms.pojo.SystemmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemmessageMapper {
    long countByExample(SystemmessageExample example);

    int deleteByExample(SystemmessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Systemmessage record);

    int insertSelective(Systemmessage record);

    List<Systemmessage> selectByExampleWithBLOBs(SystemmessageExample example);

    List<Systemmessage> selectByExample(SystemmessageExample example);

    Systemmessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Systemmessage record, @Param("example") SystemmessageExample example);

    int updateByExampleWithBLOBs(@Param("record") Systemmessage record, @Param("example") SystemmessageExample example);

    int updateByExample(@Param("record") Systemmessage record, @Param("example") SystemmessageExample example);

    int updateByPrimaryKeySelective(Systemmessage record);

    int updateByPrimaryKeyWithBLOBs(Systemmessage record);

    int updateByPrimaryKey(Systemmessage record);
}