package cn.it.phw.ms.dao;

import cn.it.phw.ms.BaseSpringJunitTest;
import cn.it.phw.ms.common.MyDaoException;
import cn.it.phw.ms.dao.mapper.UserMapper;
import cn.it.phw.ms.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserDao extends BaseSpringJunitTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindItemById() throws MyDaoException {
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
    }

}
