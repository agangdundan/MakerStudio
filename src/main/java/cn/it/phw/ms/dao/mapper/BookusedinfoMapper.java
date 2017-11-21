package cn.it.phw.ms.dao.mapper;

import cn.it.phw.ms.pojo.BookusedinfoExample;
import cn.it.phw.ms.pojo.Bookusedinfo;
import cn.it.phw.ms.pojo.BookusedinfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookusedinfoMapper {
    long countByExample(BookusedinfoExample example);

    int deleteByExample(BookusedinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookusedinfoWithBLOBs record);

    int insertSelective(BookusedinfoWithBLOBs record);

    List<BookusedinfoWithBLOBs> selectByExampleWithBLOBs(BookusedinfoExample example);

    List<Bookusedinfo> selectByExample(BookusedinfoExample example);

    BookusedinfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookusedinfoWithBLOBs record, @Param("example") BookusedinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BookusedinfoWithBLOBs record, @Param("example") BookusedinfoExample example);

    int updateByExample(@Param("record") Bookusedinfo record, @Param("example") BookusedinfoExample example);

    int updateByPrimaryKeySelective(BookusedinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(BookusedinfoWithBLOBs record);

    int updateByPrimaryKey(Bookusedinfo record);
}