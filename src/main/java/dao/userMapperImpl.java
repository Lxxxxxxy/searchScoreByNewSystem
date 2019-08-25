package dao;

import entity.User;
import mapper.userMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.ArrayList;

/**
 * @author lxxxxxxy
 * @time 2019/3/5 22:54
 */
public class userMapperImpl extends SqlSessionDaoSupport implements userMapper {

    @Override
    public User insertUser(String stu_id) {
        SqlSession sqlsession=super.getSqlSession();
        User user = sqlsession.selectOne("test.insertUser", stu_id);
        return user;
    }
}
