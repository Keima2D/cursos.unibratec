package concurso.fachada;

import java.util.List;

import concurso.negocio.NegocioException;
import concurso.basicas.Cargo;
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
	
	public void inserir(Setor obj) {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Setor obj) {
		this.controlador.alterar(obj);
	}

	public void remover(Setor obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Setor> consultarTodosSetores() {
		return this.controlador.consultarTodosSetores();
	}
	
	/**
	 * Cargos
	 */ 
	public void inserir(Cargo obj){
		this.controlador.inserir(obj);
	}
	
	public void remover(Cargo obj) throws NegocioException {
		this.controlador.remover(obj);
	}
	
	public List<Cargo> consultarTodosCargos(){
		return this.controlador.consultarTodosCargos();
	}

	public void alterar(Cargo obj) {
		this.controlador.alterar(obj);
		
	}
}