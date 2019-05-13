package jm.student.services;

import jm.student.models.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);

    void addRole(Role role);

    void editRole(Role role);

    void removeRole(Long id);

    List<Role> getAllRoles();
}
