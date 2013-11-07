package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import concurso.basicas.Funcionario;
import concurso.basicas.Setor;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class FuncionarioBeans {
	private Funcionario funcionario = new Funcionario();
	private IFachada fachada = Fachada.getInstancia();

	public Funcionario getFuncionario() {
		return this.funcionario;
	}
	
	public List<Funcionario> getFuncionarios() {
		return fachada.consultarTodosFuncionarios();
	}
	
	public String salvar(){
		if (funcionario.getId() == null || funcionario.getId() == 0){
			funcionario.setId(null);
			fachada.inserir(funcionario);
		} else {
			fachada.alterar(funcionario);
		}
		return "index.xhtml";
	}
	
	public String editar(Funcionario obj){
		this.funcionario = obj;
		return "form.xhtml";
	}
	
	public String excluir(Funcionario obj){
		try {
			fachada.remover(obj);
			return "setores/index.xhtml";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover setor " + obj.getNome(), e.getMessage()));
			return null;
		}
	}
}
