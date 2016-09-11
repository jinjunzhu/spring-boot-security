package repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractMybatisDaoSupport<T>{
    
    @Autowired
	protected SqlSession sqlSession;
	
	protected List<T> selectList(String statement,Object parameter){
		return sqlSession.selectList(statement, parameter);
	}

	protected T selectOne(String statement,Object parameter){
		return sqlSession.selectOne(statement,parameter);
	}
	
	protected void insert(String statement,T parameter){
		sqlSession.insert(statement, parameter); 
	}
	
	protected void update(String statement,T parameter){
		sqlSession.update(statement, parameter); 
	}
	

}
