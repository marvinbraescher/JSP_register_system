package dao;

import classes.Funcionario;
import classes.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class FuncionarioDAO {

	private EntityManager em;

	public FuncionarioDAO() {
	}

	public boolean salvar(Funcionario user) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			return true;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				System.out.println(e);
			}
			return false;
		}
	}

	public boolean atualizar(Funcionario p) {
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

	public Funcionario buscarID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Funcionario funcionario = em.find(Funcionario.class, id);
			return funcionario;
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return null;
		} 
	}

	public List<Funcionario> buscarTodos() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Funcionario> query = em.createQuery("SELECT obj FROM Funcionario obj", Funcionario.class);
			List<Funcionario> funcionario = query.getResultList();
			return funcionario;
		} catch (RuntimeException e) {
			//e.printStackTrace();
			return null;
		} 
	}
}
