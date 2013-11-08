package concurso.fachada;

import java.util.List;

import concurso.negocio.NegocioException;
import concurso.basicas.Cargo;
import concurso.basicas.Funcionario;
import concurso.basicas.Setor;

public interface IFachada {
	
	/**
	 * Setores
	 */
	void inserir(Setor setor);

	void alterar(Setor setor);

	List<Setor> consultarTodosSetores();

	void remover(Setor obj) throws NegocioException;

	/**
	 * Funcionarios
	 */
	
	List<Funcionario> consultarTodosFuncionarios();

	void inserir(Funcionario funcionario);

	void alterar(Funcionario funcionario);

	void remover(Funcionario obj);
	
	/**
	 * Cargos
	 */ 
	
	void inserir (Cargo cargo);
	
	void alterar (Cargo cargo);
	
	List <Cargo> consultarTodosCargos();
	
	void remover (Cargo obj) throws NegocioException;
	
}
