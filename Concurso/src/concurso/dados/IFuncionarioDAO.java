package concurso.dados;

import java.util.List;

import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.geral.IDAOGenerico;

public interface IFuncionarioDAO extends IDAOGenerico<Funcionario> {

	List<Funcionario> pesquisarFuncionarioPorSetor(Setor obj);

}
