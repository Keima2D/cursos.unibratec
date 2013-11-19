package concurso.negocio;

import java.util.List;

import concurso.basicas.Cargo;
import concurso.basicas.Dependente;
import concurso.basicas.Funcionario;
import concurso.basicas.Orgao;
import concurso.basicas.Setor;
import concurso.dados.CargoDAO;
import concurso.dados.DependenteDAO;
import concurso.dados.FuncionarioDAO;
import concurso.dados.ICargoDAO;
import concurso.dados.IDependenteDAO;
import concurso.dados.IFuncionarioDAO;
import concurso.dados.IOrgaoDAO;
import concurso.dados.ISetorDAO;
import concurso.dados.OrgaoDAO;
import concurso.dados.SetorDAO;

public class Controlador {
	private ISetorDAO setorDAO;
	private IFuncionarioDAO funcionarioDAO;
	private ICargoDAO cargoDAO;
	private IDependenteDAO dependenteDAO;
	private IOrgaoDAO orgaoDAO;
	
	public Controlador() {
		this.cargoDAO = new CargoDAO();
		this.setorDAO = new SetorDAO();
		this.funcionarioDAO = new FuncionarioDAO();
		this.dependenteDAO = new DependenteDAO();
		this.orgaoDAO = new OrgaoDAO();
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
	
}
