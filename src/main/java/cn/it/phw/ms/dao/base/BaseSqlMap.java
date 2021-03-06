package cn.it.phw.ms.dao.base;

import cn.it.phw.ms.common.MyDaoException;

import java.util.List;

/**
 * 数据库基本接口
 * @param <T>
 */
public interface BaseSqlMap<T> extends SqlMap {

    public static final String SQL_INSERT = ".insert";

    public static final String SQL_UPDATE_BY_PK_WITH_BLOBS = ".updateByPrimaryKeyWithBLOBs";

    public static final String SQL_SELECT_BY_PK = ".selectByPrimaryKey";

    public static final String SQL_DELETE_BY_PK = ".deleteByPrimaryKey";


    /**
     * 根据id查找对象
     * @param id 索引
     * @return 实体类
     * @throws MyDaoException
     */
    T selectByPrimaryKey(Integer id) throws MyDaoException;

    /**
     * 插入一条记录
     * @param item 要插入的记录
     * @return 受影响的条数
     * @throws MyDaoException
     */
    Integer insertItem(T item) throws MyDaoException;

    /**
     * 更新一条记录
     * @param item 更新的记录
     * @return 受影响的条数
     * @throws MyDaoException
     */
    Integer updateItem(T item) throws MyDaoException;

    /**
     * 删除一条记录
     * @param id 要删除的记录索引
     * @return 受影响的条数
     * @throws MyDaoException
     */
    Integer deleteItem(Integer id) throws MyDaoException;

    List<T> selectByExample(T item);

}
