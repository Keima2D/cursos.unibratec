package concurso.fachada;

import java.util.List;
import concurso.basicas.Setor;

public interface IFachada {
	public  void inserir(Setor entidade);
	public List<Setor> consultarTodosSetores();
}
