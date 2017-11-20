package cn.it.pwh.ms.dao.mapper;

import cn.it.pwh.ms.pojo.Meetingrecord;
import cn.it.pwh.ms.pojo.MeetingrecordExample;
import cn.it.pwh.ms.pojo.MeetingrecordWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MeetingrecordMapper {
    long countByExample(MeetingrecordExample example);

    int deleteByExample(MeetingrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MeetingrecordWithBLOBs record);

    int insertSelective(MeetingrecordWithBLOBs record);

    List<MeetingrecordWithBLOBs> selectByExampleWithBLOBs(MeetingrecordExample example);

    List<Meetingrecord> selectByExample(MeetingrecordExample example);

    MeetingrecordWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MeetingrecordWithBLOBs record, @Param("example") MeetingrecordExample example);

    int updateByExampleWithBLOBs(@Param("record") MeetingrecordWithBLOBs record, @Param("example") MeetingrecordExample example);

    int updateByExample(@Param("record") Meetingrecord record, @Param("example") MeetingrecordExample example);

    int updateByPrimaryKeySelective(MeetingrecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MeetingrecordWithBLOBs record);

    int updateByPrimaryKey(Meetingrecord record);
}