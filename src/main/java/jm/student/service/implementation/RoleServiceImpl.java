package jm.student.service.implementation;

import jm.student.dao.RoleDao;
import jm.student.models.Role;
import jm.student.service.abstraction.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) { this.roleDao = roleDao; }

    @Override
    public Role getRoleById(Long id) { return roleDao.getRoleById(id); }

    @Override
    public void addRole(Role role) { roleDao.addRole(role); }

    @Override
    public void editRole(Role role) { roleDao.editRole(role); }

    @Override
    public void removeRole(Long id) { roleDao.removeRole(id); }

    @Override
    public List<Role> getAllRoles() { return roleDao.getAllRoles(); }
}
