package dao;

import classes.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UsuarioDAO {

	private EntityManager em;

	public UsuarioDAO() {
	}

	public boolean salvar(Usuario user) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		}
	}

	public boolean atualizar(Usuario p) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}

	public boolean remover(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Usuario entity = em.find(Usuario.class, id);
			em.remove(entity);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false;
		} 
	}

	public Usuario buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Usuario usuario = em.find(Usuario.class, id);
			return usuario;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Usuario> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Usuario> query = em.createQuery("SELECT obj FROM Usuario obj", Usuario.class);
			List<Usuario> usuarios = query.getResultList();
			return usuarios;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
