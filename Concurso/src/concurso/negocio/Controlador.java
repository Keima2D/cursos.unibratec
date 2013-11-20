package concurso.negocio;

import java.util.List;

import javax.security.auth.login.LoginException;

import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Disciplina;
import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.dados.CargoDAO;
import concurso.dados.DependenteDAO;
import concurso.dados.FuncionarioDAO;
import concurso.dados.ICargoDAO;
import concurso.dados.IDependenteDAO;
import concurso.dados.IFuncionarioDAO;
import concurso.dados.IDisciplinaDAO;
import concurso.dados.ISetorDAO;
import concurso.dados.SetorDAO;
import concurso.dados.DisciplinaDAO;
public class Controlador {
	private ISetorDAO setorDAO;
	private IFuncionarioDAO funcionarioDAO;
	private ICargoDAO cargoDAO;
	private IDependenteDAO dependenteDAO;
	private IDisciplinaDAO disciplinaDAO;
	
	public Controlador() {
		this.cargoDAO = new CargoDAO();
		this.setorDAO = new SetorDAO();
		this.funcionarioDAO = new FuncionarioDAO();
		this.dependenteDAO = new DependenteDAO();
		this.disciplinaDAO = new DisciplinaDAO();
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
	
	public void remover(Disciplina obj) {
		this.disciplinaDAO.remover(obj);
	}

	public Disciplina consultarDisciplinaPorId(Integer id) {
		return disciplinaDAO.consultarPorId(id);
	}
	
}