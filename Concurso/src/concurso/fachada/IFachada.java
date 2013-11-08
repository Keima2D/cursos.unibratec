package concurso.fachada;

import java.util.List;

import concurso.negocio.NegocioException;
import concurso.basicas.Cargo;
import concurso.basicas.Setor;

public interface IFachada {

	void inserir(Setor setor);

	void alterar(Setor setor);

	List<Setor> consultarTodosSetores();

	void remover(Setor obj) throws NegocioException;
	
	/**
	 * Cargos
	 */ 
	
	void inserir (Cargo cargo);
	
	void alterar (Cargo cargo);
	
	List <Cargo> consultarTodosCargos();
	
	void remover (Cargo obj) throws NegocioException;
	
}
