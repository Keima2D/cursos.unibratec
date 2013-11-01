package concurso.fachada;

import java.util.List;
import concurso.basicas.Setor;
import concurso.negocio.Controlador;

public class Fachada implements IFachada {

	private static IFachada fachada;
	private Controlador controlador;
	
	private Fachada(){
		this.controlador = new Controlador();
	}

	public static IFachada getInstancia(){
		if (fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	@Override
	public void inserir(Setor entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Setor> consultarTodosSetores() {
		return this.controlador.consultarTodosSetores();
	}
}
