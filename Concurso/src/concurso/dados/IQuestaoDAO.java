package concurso.dados;

import java.util.List;

import concurso.basicas.Disciplina;
import concurso.basicas.Questao;
import concurso.geral.IDAOGenerico;

public interface IQuestaoDAO extends IDAOGenerico<Questao> {

	List<Questao> pesquisarQuestoesPorDisciplina(Disciplina obj);

}
