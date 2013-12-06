package concurso.fachada;

import java.util.List;

import javax.security.auth.login.LoginException;

import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Disciplina;
import concurso.basicas.Funcionario;
import concurso.basicas.NivelQuestao;
import concurso.basicas.Orgao;
import concurso.basicas.Prova;
import concurso.basicas.Questao;
import concurso.basicas.Setor;
import concurso.negocio.Controlador;
import concurso.negocio.NegocioException;

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
	public Funcionario efetuarLogin(String email, String senha) throws LoginException {
		return controlador.efetuarLogin(email, senha);
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
	 * Disciplina
	 */ 
	public void inserir(Disciplina obj){
		this.controlador.inserir(obj);
	}
	
	public void remover(Disciplina obj) throws NegocioException {
		this.controlador.remover(obj);
	}
	
	public List<Disciplina> consultarTodasDisciplinas(){
		return this.controlador.consultarTodasDisciplinas();
	}

	public void alterar(Disciplina obj) {
		this.controlador.alterar(obj);		
	}

	public Disciplina consultarDisciplinaPorId(Integer id) {
	return this.controlador.consultarDisciplinaPorId(id);
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
	
	public Orgao consultarOrgaoPorId(Integer id) {
		return this.controlador.consultarOrgaoPorId(id);
	}
	
	/**
	 * Prova
	 */
	public void inserir(Prova obj) throws NegocioException {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Prova obj) throws NegocioException {
		this.controlador.alterar(obj);
	}

	public void remover(Prova obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Prova> consultarTodasProvas() {
		return this.controlador.consultarTodasProvas();
	}
		
	public Prova consultarProvaPorId(Integer id) {
		return this.controlador.consultarProvaPorId(id);
	}


	/**
	 * Questoes
	 */
	public void inserir(Questao obj) {
		this.controlador.inserir(obj);
		
	}
	
	public void alterar(Questao obj) {
		this.controlador.alterar(obj);
	}

	public void remover(Questao obj) throws NegocioException {
		this.controlador.remover(obj);
	}

	public List<Questao> consultarTodasQuestoes() {
		return this.controlador.consultarTodasQuestoes();
	}

	public List<Questao> getQuestoesPorDisciplinaENivel(Disciplina disciplina, NivelQuestao nvl, Integer limit) {
		return this.controlador.getQuestoesPorDisciplinaENivel(disciplina, nvl, limit);
	}
		
	public Questao consultarQuestaoPorId(Integer id) {
		return this.controlador.consultarQuestaoPorId(id);
	}
}
