package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.Bookusedinfo;
import cn.it.phw.ms.pojo.BookusedinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookusedinfoMapper {
    long countByExample(BookusedinfoExample example);

    int deleteByExample(BookusedinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bookusedinfo record);

    int insertSelective(Bookusedinfo record);

    List<Bookusedinfo> selectByExample(BookusedinfoExample example);

    Bookusedinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bookusedinfo record, @Param("example") BookusedinfoExample example);

    int updateByExample(@Param("record") Bookusedinfo record, @Param("example") BookusedinfoExample example);

    int updateByPrimaryKeySelective(Bookusedinfo record);

    int updateByPrimaryKey(Bookusedinfo record);
}