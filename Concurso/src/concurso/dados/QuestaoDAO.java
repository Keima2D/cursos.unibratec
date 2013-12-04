package concurso.dados;

import java.util.List;
import javax.persistence.TypedQuery;

import concurso.basicas.Disciplina;
import concurso.basicas.Questao;
import concurso.geral.DAOGenerico;

public class QuestaoDAO extends DAOGenerico<Questao> implements IQuestaoDAO {
	public List<Questao> pesquisarQuestoesPorDisciplina (Disciplina disciplina) {
		String jpql = "select q from Questao q where q.disciplina = :disciplina";
		TypedQuery<Questao> query = getEntityManager().createQuery(jpql, Questao.class);
		query.setParameter("disciplina", disciplina);
		return query.getResultList();
	}
}
