package concurso.negocio;

import java.util.List;

import javax.security.auth.login.LoginException;

import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Disciplina;
import concurso.basicas.Funcionario;
import concurso.basicas.Orgao;
import concurso.basicas.Prova;
import concurso.basicas.Questao;
import concurso.basicas.Setor;
import concurso.dados.CargoDAO;
import concurso.dados.DependenteDAO;
import concurso.dados.DisciplinaDAO;
import concurso.dados.FuncionarioDAO;
import concurso.dados.ICargoDAO;
import concurso.dados.IDependenteDAO;
import concurso.dados.IDisciplinaDAO;
import concurso.dados.IFuncionarioDAO;
import concurso.dados.IOrgaoDAO;
import concurso.dados.IProvaDAO;
import concurso.dados.IQuestaoDAO;
import concurso.dados.ISetorDAO;
import concurso.dados.OrgaoDAO;
import concurso.dados.ProvaDAO;
import concurso.dados.QuestaoDAO;
import concurso.dados.SetorDAO;
public class Controlador {
	private ISetorDAO setorDAO;
	private IFuncionarioDAO funcionarioDAO;
	private ICargoDAO cargoDAO;
	private IDependenteDAO dependenteDAO;
	private IDisciplinaDAO disciplinaDAO;
	private IOrgaoDAO orgaoDAO;
	private IProvaDAO provaDAO;
	private IQuestaoDAO questaoDAO;
	
	
	public Controlador() {
		this.cargoDAO = new CargoDAO();
		this.setorDAO = new SetorDAO();
		this.funcionarioDAO = new FuncionarioDAO();
		this.dependenteDAO = new DependenteDAO();
		this.disciplinaDAO = new DisciplinaDAO();
		this.orgaoDAO = new OrgaoDAO();
		this.provaDAO = new ProvaDAO();
		this.questaoDAO = new QuestaoDAO();
	}
	
	/**
	 * Setores
	 */ 
	public List<Setor> consultarTodosSetores() {
		return this.setorDAO.consultarTodos();
	}
	
	public void inserir(Setor obj) {
		this.setorDAO.inserir(obj);
	}

	public void alterar(Setor obj) {
		this.setorDAO.alterar(obj);
	}
	
	public void remover(Setor obj) throws NegocioException {
		
		List<Funcionario> resultado = funcionarioDAO.pesquisarFuncionarioPorSetor(obj);

		if (resultado.isEmpty()){
			this.setorDAO.remover(obj);	
		} else {
			throw new NegocioException("Existem funcionarios cadastrados com este setor");
		}
	}	

	public Setor consultarSetorPorId(Integer id) {
		return setorDAO.consultarPorId(id);
	}
	
	/**
	 * Funcionarios
	 */ 
	public List<Funcionario> consultarTodosFuncionarios() {
		return this.funcionarioDAO.consultarTodos();
	}
	
	public void inserir(Funcionario obj) {
		this.funcionarioDAO.inserir(obj);
	}

	public void alterar(Funcionario obj) {
		this.funcionarioDAO.alterar(obj);
	}
	
	public void remover(Funcionario obj)  throws NegocioException {
		this.funcionarioDAO.remover(obj);
		throw new NegocioException("");
	}
	public Funcionario efetuarLogin(String email, String senha)
			throws LoginException {
		return funcionarioDAO.efetuarLogin(email, senha);
	}
	
	/**
	 * Cargos
	 */ 
	public List<Cargo> consultarTodosCargos() {
		return this.cargoDAO.consultarTodos();
	}
	
	public void inserir(Cargo obj) {
		this.cargoDAO.inserir(obj);
	}

	public void alterar(Cargo obj) {
		this.cargoDAO.alterar(obj);
	}
	
	public void remover(Cargo obj) {
		this.cargoDAO.remover(obj);
	}

	public Cargo consultarCargoPorId(Integer id) {
		return cargoDAO.consultarPorId(id);
	}
	
	/**
	 * Dependente
	 */ 
	public List<Dependente> consultarTodosDependentes() {
		return this.dependenteDAO.consultarTodos();
	}
	
	public void inserir(Dependente obj) {
		this.dependenteDAO.inserir(obj);
	}

	public void alterar(Dependente obj) {
		this.dependenteDAO.alterar(obj);
	}
	
	public void remover(Dependente obj) {
		this.dependenteDAO.remover(obj);
	}
	/**
	 * Orgao
	 */ 
	public List<Orgao> consultarTodosOrgaos() {
		return this.orgaoDAO.consultarTodos();
	}
	
	public void inserir(Orgao obj) {
		this.orgaoDAO.inserir(obj);
	}

	public void alterar(Orgao obj) {
		this.orgaoDAO.alterar(obj);
	}
	
	public void remover(Orgao obj) {
		this.orgaoDAO.remover(obj);
	}
	public Orgao consultarOrgaoPorId(Integer id) {
		return orgaoDAO.consultarPorId(id);
	}
	
	/**
	 * Disciplina
	 */ 
	public List<Disciplina> consultarTodasDisciplinas() {
		return this.disciplinaDAO.consultarTodos();
	}
	
	public void inserir(Disciplina obj) {
		this.disciplinaDAO.inserir(obj);
	}

	public void alterar(Disciplina obj) {
		this.disciplinaDAO.alterar(obj);
	}
	
	public void remover(Disciplina obj) throws NegocioException {
		List<Questao> listQ = this.questaoDAO.pesquisarQuestoesPorDisciplina(obj);
		
		if (!listQ.isEmpty()) {
			throw new NegocioException("J‡ existem quest›es cadastradas nessa disciplina");
		} else {
			this.disciplinaDAO.remover(obj);
		}
	}

	public Disciplina consultarDisciplinaPorId(Integer id) {
		return disciplinaDAO.consultarPorId(id);
	}
	
	/**
	 * Prova
	 */ 
	public List<Prova> consultarTodasProvas() {
		return this.provaDAO.consultarTodos();
	}
	
	public void inserir(Prova obj) {
		this.provaDAO.inserir(obj);
	}

	public void alterar(Prova obj) {
		this.provaDAO.alterar(obj);
	}
	
	public void remover(Prova obj) {
		this.provaDAO.remover(obj);
	}

	public Prova consultarProvaPorId(Integer id) {
		return provaDAO.consultarPorId(id);
	}
	
	/**
	 * Questoes
	 */ 
	public List<Questao> consultarTodasQuestoes() {
		return this.questaoDAO.consultarTodos();
	}
	
	public void inserir(Questao obj) {
		this.questaoDAO.inserir(obj);
	}

	public void alterar(Questao obj) {
		this.questaoDAO.alterar(obj);
	}
	
	public void remover(Questao obj) {
		this.questaoDAO.remover(obj);
	}

	public Questao consultarQuestaoPorId(Integer id) {
		return questaoDAO.consultarPorId(id);
	}
}
