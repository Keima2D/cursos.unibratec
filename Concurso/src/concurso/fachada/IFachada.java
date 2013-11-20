package concurso.fachada;

import java.util.List;

import javax.security.auth.login.LoginException;

import concurso.negocio.NegocioException;
import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Disciplina;
import concurso.basicas.Funcionario;
import concurso.basicas.Orgao;
import concurso.basicas.Setor;

public interface IFachada {
	
	/**
	 * Setores
	 */
	List<Setor> consultarTodosSetores();
	
	void inserir(Setor setor);

	void alterar(Setor setor);

	void remover(Setor obj) throws NegocioException;

	Setor consultarSetorPorId(Integer id);
	
	/**
	 * Funcionarios
	 */
	List<Funcionario> consultarTodosFuncionarios();

	void inserir(Funcionario funcionario);

	void alterar(Funcionario funcionario);

	void remover(Funcionario obj) throws NegocioException;
	
	
	/**
	 * Cargos
	 */	
	List <Cargo> consultarTodosCargos();
	
	void inserir(Cargo cargo);
	
	void alterar(Cargo cargo);
		
	void remover(Cargo obj) throws NegocioException;
	
	Cargo consultarCargoPorId (Integer id);
	
	/**
	 * Dependente
	 */	
	List <Dependente> consultarTodosDependentes();
	
	void inserir(Dependente dependente);
	
	void alterar(Dependente dependente);

	Funcionario efetuarLogin(String email, String senha)throws LoginException;
	
	/**
	 * Disciplina
	 */	
	List <Disciplina> consultarTodasDisciplinas();
	
	void inserir(Disciplina disciplina);
	
	void alterar(Disciplina disciplina);
		
	void remover(Disciplina obj) throws NegocioException;
	
	Disciplina consultarDisciplinaPorId (Integer id);
	
	void remover(Dependente obj) throws NegocioException;
	
	/**
	 * Orgao
	 */	
	List <Orgao> consultarTodosOrgaos();
	
	void inserir(Orgao orgao);
	
	void alterar(Orgao orgao);
	
	void remover(Orgao obj) throws NegocioException;
}
