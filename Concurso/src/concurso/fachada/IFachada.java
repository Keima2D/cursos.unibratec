package concurso.fachada;

import java.util.List;
import concurso.negocio.NegocioException;
import concurso.basicas.Setor;

public interface IFachada {

	void inserir(Setor setor);

	void alterar(Setor setor);

	List<Setor> consultarTodosSetores();

	void remover(Setor obj) throws NegocioException;
	
}
