package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Meetingrecord;
import cn.it.phw.ms.pojo.MeetingrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MeetingrecordMapper {
    long countByExample(MeetingrecordExample example);

    int deleteByExample(MeetingrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Meetingrecord record);

    int insertSelective(Meetingrecord record);

    List<Meetingrecord> selectByExampleWithBLOBs(MeetingrecordExample example);

    List<Meetingrecord> selectByExample(MeetingrecordExample example);

    Meetingrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Meetingrecord record, @Param("example") MeetingrecordExample example);

    int updateByExampleWithBLOBs(@Param("record") Meetingrecord record, @Param("example") MeetingrecordExample example);

    int updateByExample(@Param("record") Meetingrecord record, @Param("example") MeetingrecordExample example);

    int updateByPrimaryKeySelective(Meetingrecord record);

    int updateByPrimaryKeyWithBLOBs(Meetingrecord record);

    int updateByPrimaryKey(Meetingrecord record);
}