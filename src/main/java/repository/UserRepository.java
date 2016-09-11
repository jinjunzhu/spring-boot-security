package repository;

import org.springframework.stereotype.Repository;
import domain.MyUser;

@Repository
public class UserRepository extends AbstractMybatisDaoSupport<MyUser>{

	public MyUser findByName(String username) {
		return selectOne("User.getByName", username);
	}
}
