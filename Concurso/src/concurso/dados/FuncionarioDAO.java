package concurso.dados;

import java.util.List;
import javax.persistence.TypedQuery;
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
	
}