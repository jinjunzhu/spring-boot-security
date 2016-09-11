package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import domain.UserRole;

@Repository
public class UserRoleRepository extends AbstractMybatisDaoSupport<UserRole>{

	public List<UserRole> getRoleByUser(Long userId){
		return selectList("UserRole.getUserRoles", userId);
	}
}
