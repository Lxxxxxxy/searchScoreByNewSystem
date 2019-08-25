package dao;

import entity.searchCount;
import mapper.searchCountMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * @author lxxxxxxy
 * @time 2019/3/6 09:21
 */
public class searchCountMapperImpl extends SqlSessionDaoSupport implements searchCountMapper {
    @Override
    public int add() {
        SqlSession sqlsession=super.getSqlSession();
        int row = sqlsession.update("test.add");
        return row;
    }

    @Override
    public searchCount selectCount() {
        SqlSession sqlsession=super.getSqlSession();
        searchCount searchCount = sqlsession.selectOne("test.selectCount");
        return searchCount;
    }
}
