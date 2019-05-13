package jm.student.app;

import jm.student.models.Role;
import jm.student.models.User;
import jm.student.services.RoleService;
import jm.student.services.UserService;

import java.util.HashSet;
import java.util.Set;


public class TestDataInit {

	private UserService userService;

	private RoleService roleService;

	public TestDataInit(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}

	private void init() throws Exception {

		Role roleAdmin = new Role();
		roleAdmin.setRole("ADMIN");
		roleService.addRole(roleAdmin);

		Role roleUser = new Role();
		roleUser.setRole("USER");
		roleService.addRole(roleUser);

		User admin = new User();
		admin.setLogin("admin");
		admin.setPassword("admin");
		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(roleAdmin);
		adminRoles.add(roleUser);
		admin.setRoles(adminRoles);

		userService.addUser(admin);

		User user = new User();
		user.setLogin("user");
		user.setPassword("user");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(roleUser);
		user.setRoles(userRoles);

		userService.addUser(user);

	}
}
