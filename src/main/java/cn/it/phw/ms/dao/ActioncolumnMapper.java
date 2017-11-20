package cn.it.phw.ms.dao;

import cn.it.phw.ms.pojo.Actioncolumn;
import cn.it.phw.ms.pojo.ActioncolumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActioncolumnMapper {
    long countByExample(ActioncolumnExample example);

    int deleteByExample(ActioncolumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Actioncolumn record);

    int insertSelective(Actioncolumn record);

    List<Actioncolumn> selectByExample(ActioncolumnExample example);

    Actioncolumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Actioncolumn record, @Param("example") ActioncolumnExample example);

    int updateByExample(@Param("record") Actioncolumn record, @Param("example") ActioncolumnExample example);

    int updateByPrimaryKeySelective(Actioncolumn record);

    int updateByPrimaryKey(Actioncolumn record);
}