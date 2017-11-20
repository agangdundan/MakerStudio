package cn.it.phw.ms.dao;

import cn.it.phw.ms.pojo.Learningplancolumnmanager;
import cn.it.phw.ms.pojo.LearningplancolumnmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningplancolumnmanagerMapper {
    long countByExample(LearningplancolumnmanagerExample example);

    int deleteByExample(LearningplancolumnmanagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Learningplancolumnmanager record);

    int insertSelective(Learningplancolumnmanager record);

    List<Learningplancolumnmanager> selectByExampleWithBLOBs(LearningplancolumnmanagerExample example);

    List<Learningplancolumnmanager> selectByExample(LearningplancolumnmanagerExample example);

    Learningplancolumnmanager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Learningplancolumnmanager record, @Param("example") LearningplancolumnmanagerExample example);

    int updateByExampleWithBLOBs(@Param("record") Learningplancolumnmanager record, @Param("example") LearningplancolumnmanagerExample example);

    int updateByExample(@Param("record") Learningplancolumnmanager record, @Param("example") LearningplancolumnmanagerExample example);

    int updateByPrimaryKeySelective(Learningplancolumnmanager record);

    int updateByPrimaryKeyWithBLOBs(Learningplancolumnmanager record);

    int updateByPrimaryKey(Learningplancolumnmanager record);
}