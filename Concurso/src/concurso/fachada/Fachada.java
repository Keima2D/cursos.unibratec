package concurso.fachada;

import java.util.List;

import concurso.negocio.NegocioException;
import concurso.basicas.Funcionario;
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
	
	
	/**
	 * Setores
	 */
	
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
	 * Funcionarios
	 */
	public void inserir(Funcionario obj) {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Funcionario obj) {
		this.controlador.alterar(obj);
	}

	public void remover(Funcionario obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Funcionario> consultarTodosFuncionarios() {
		return this.controlador.consultarTodosFuncionarios();
	}
	
}