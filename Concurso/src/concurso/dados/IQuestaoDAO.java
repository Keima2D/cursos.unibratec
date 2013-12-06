package concurso.dados;

import java.util.List;

import concurso.basicas.Disciplina;
import concurso.basicas.NivelQuestao;
import concurso.basicas.Questao;
import concurso.geral.IDAOGenerico;

public interface IQuestaoDAO extends IDAOGenerico<Questao> {

	List<Questao> pesquisarQuestoesPorDisciplina(Disciplina obj);

	List<Questao> getQuestoesPorDisciplinaENivel(Disciplina disciplina, NivelQuestao nvl, Integer limit);

}
