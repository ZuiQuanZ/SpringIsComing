package jm.student.dao.impl;

import jm.student.dao.RoleDao;
import jm.student.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    public RoleDaoImpl() {}

    @Override
    public Role getRoleById(Long id) { return entityManager.find(Role.class,id); }

    @Override
    public void addRole(Role role) { entityManager.persist(role); }

    @Override
    public void editRole(Role role) { entityManager.merge(role); }

    @Override
    public void removeRole(Long id) { entityManager.remove(entityManager.find((Role.class), id)); }

    @Override
    public List<Role> getAllRoles() { return entityManager.createQuery("FROM Role").getResultList(); }
}
