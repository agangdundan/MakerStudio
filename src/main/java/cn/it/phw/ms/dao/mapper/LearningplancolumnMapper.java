package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Learningplancolumn;
import cn.it.phw.ms.pojo.LearningplancolumnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LearningplancolumnMapper {
    long countByExample(LearningplancolumnExample example);

    int deleteByExample(LearningplancolumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Learningplancolumn record);

    int insertSelective(Learningplancolumn record);

    List<Learningplancolumn> selectByExample(LearningplancolumnExample example);

    Learningplancolumn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Learningplancolumn record, @Param("example") LearningplancolumnExample example);

    int updateByExample(@Param("record") Learningplancolumn record, @Param("example") LearningplancolumnExample example);

    int updateByPrimaryKeySelective(Learningplancolumn record);

    int updateByPrimaryKey(Learningplancolumn record);
}