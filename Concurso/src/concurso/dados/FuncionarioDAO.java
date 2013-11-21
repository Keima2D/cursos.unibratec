package concurso.dados;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.geral.DAOGenerico;

public class FuncionarioDAO extends DAOGenerico<Funcionario> implements IFuncionarioDAO{

	public List<Funcionario> pesquisarFuncionarioPorSetor (Setor setor){
		String jpql = "select f from Funcionario f where f.setor = :setor";
		TypedQuery<Funcionario> query = getEntityManager().createQuery(jpql, Funcionario.class);
		query.setParameter("setor", setor);
		return query.getResultList();
	}

	public Funcionario efetuarLogin(String email, String senha) throws LoginException{
		try {
			TypedQuery<Funcionario> query = getEntityManager().createNamedQuery("efetuarLogin", Funcionario.class);
			query.setParameter("email", email);
			query.setParameter("senha", senha);
			
			System.out.println(email);
			System.out.println(senha);
			
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println("u:" + email + " p:" + senha);
			System.out.println(e.getMessage());
			throw new LoginException();
		}
	}
	
}