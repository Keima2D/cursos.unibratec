package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import utils.MD5;
import concurso.basicas.Endereco;
import concurso.basicas.Funcionario;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@SessionScoped
@ManagedBean
public class FuncionarioBean {
	private Funcionario funcionario = new Funcionario();
	private IFachada fachada = Fachada.getInstancia();
	private Integer setorSelecionado = null;
	private Integer cargoSelecionado = null;
	private String novaSenha;
	private String senhaOriginal;
	
	public Funcionario getFuncionario () {
		if (this.funcionario.getEndereco() == null) {
			this.funcionario.setEndereco(new Endereco());
		}
		return this.funcionario;
	}
	
	public List<Funcionario> getFuncionarios () {
		return fachada.consultarTodosFuncionarios();
	}
	
	public Integer getSetorSelecionado () {
		if (this.setorSelecionado == null && this.funcionario.getSetor() != null) {
			this.setorSelecionado = this.funcionario.getSetor().getId();
		}

		return setorSelecionado;
	}

	public void setSetorSelecionado (Integer setorSelecionado) {
		this.setorSelecionado = setorSelecionado;
	}

	public Integer getCargoSelecionado () {
		if (this.cargoSelecionado == null && this.funcionario.getCargo() != null) {
			this.cargoSelecionado = this.funcionario.getCargo().getId();
		}
		
		return cargoSelecionado;
	}

	public void setCargoSelecionado (Integer cargoSelecionado) {
		this.cargoSelecionado = cargoSelecionado;
	}

	public String getNovaSenha () {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
	public String salvar () {
		this.funcionario.setSetor(Fachada.getInstancia().consultarSetorPorId(this.setorSelecionado));
		this.funcionario.setCargo(Fachada.getInstancia().consultarCargoPorId(this.cargoSelecionado));
		
		if (this.novaSenha != null && this.novaSenha.length() > 0) {
			MD5 hash = new MD5(this.novaSenha);
			this.funcionario.setSenha(hash.getHash());
		} else {
			if (this.funcionario.getId() != null || this.funcionario.getId() != 0){
				this.funcionario.setSenha(this.senhaOriginal);
			}
		}
		
		if (funcionario.getId() == null || funcionario.getId() == 0){
			funcionario.setId(null);
			fachada.inserir(funcionario);
		} else {
			fachada.alterar(funcionario);
		}
		
		this.funcionario = new Funcionario();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Funcionario obj){
		this.funcionario = obj;
		this.senhaOriginal = obj.getSenha();
		
		System.out.println(this.senhaOriginal);
		return "form.xhtml";
	}
	
	public String excluir(Funcionario obj) throws NegocioException{
		try{
			fachada.remover(obj);
			return "funcionarios/index.xhtml?faces-redirect=true";
		}catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover o Funcion�rio " + obj.getNome(), e.getMessage()));
			return null;
		}
	}
}
