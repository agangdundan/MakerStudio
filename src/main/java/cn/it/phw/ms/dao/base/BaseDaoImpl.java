package cn.it.phw.ms.dao.base;

import cn.it.phw.ms.common.MyDaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

public class BaseDaoImpl<T> implements BaseSqlMap<T> {

    private static final Logger logger = LogManager.getLogger(BaseDaoImpl.class);

    @Autowired
    private SqlSessionTemplate sqlSession;

    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments() [0];
    }

    @Override
    public T findItemById(Integer id) throws MyDaoException {
        if (id == null) {
            throw new MyDaoException("数据库错误：查询失败，非法参数！");
        }
        return sqlSession.selectOne(entityClass.getName() + SQL_FIND_BY_ID, id);
    }

    @Override
    public Integer insertItem(T item) throws MyDaoException {
        int result = sqlSession.insert(entityClass.getName() + SQL_INSERT, item);
        if (result == 0) {
            throw new MyDaoException("数据库错误：插入失败！");
        }
        return result;
    }

    @Override
    public Integer updateItem(T item) throws MyDaoException {
        int result = sqlSession.update(entityClass.getName() + SQL_UPDATE, item);
        if (result == 0) {
            throw new MyDaoException("数据库错误：更新失败！");
        }
        return result;
    }

    @Override
    public Integer deleteItem(Integer id) throws MyDaoException {
        int result = sqlSession.delete(entityClass.getName() + SQL_DELETE, id);
        if (result == 0) {
            throw new MyDaoException("数据库错误：删除失败！");
        }
        return result;
    }

}
