package concurso.fachada;

import java.util.List;

import concurso.negocio.NegocioException;
import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Funcionario;
import concurso.basicas.Orgao;
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

	public Setor consultarSetorPorId(Integer id) {
		return this.controlador.consultarSetorPorId(id);
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

	public Cargo consultarCargoPorId(Integer id) {
		return this.controlador.consultarCargoPorId(id);
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
	
	/**
	 * Dependente
	 */
	public void inserir(Dependente obj) {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Dependente obj) {
		this.controlador.alterar(obj);
	}

	public void remover(Dependente obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Dependente> consultarTodosDependentes() {
		return this.controlador.consultarTodosDependentes();
	}
	
	/**
	 * Orgao
	 */
	public void inserir(Orgao obj) {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Orgao obj) {
		this.controlador.alterar(obj);
	}

	public void remover(Orgao obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Orgao> consultarTodosOrgaos() {
		return this.controlador.consultarTodosOrgaos();
	}
}
