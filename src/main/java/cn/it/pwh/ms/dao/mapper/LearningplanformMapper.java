package cn.it.pwh.ms.dao.mapper;

import cn.it.pwh.ms.pojo.Learningplanform;
import cn.it.pwh.ms.pojo.LearningplanformExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LearningplanformMapper {
    long countByExample(LearningplanformExample example);

    int deleteByExample(LearningplanformExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Learningplanform record);

    int insertSelective(Learningplanform record);

    List<Learningplanform> selectByExample(LearningplanformExample example);

    Learningplanform selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Learningplanform record, @Param("example") LearningplanformExample example);

    int updateByExample(@Param("record") Learningplanform record, @Param("example") LearningplanformExample example);

    int updateByPrimaryKeySelective(Learningplanform record);

    int updateByPrimaryKey(Learningplanform record);
}