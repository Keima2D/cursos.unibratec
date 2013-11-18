package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import concurso.basicas.Cargo;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class CargoBean {
	
	private Cargo cargo = new Cargo();
	private IFachada fachada = Fachada.getInstancia();

	public Cargo getCargo() {
		return this.cargo;
	}

	public List<Cargo> getCargos() {
		return fachada.consultarTodosCargos();
	}
	
	public String salvar () {
		if (cargo.getId() == null || cargo.getId() == 0){
			cargo.setId(null);
			fachada.inserir(cargo);
		} else {
			fachada.alterar(cargo);
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Cargo obj){
		this.cargo = obj;
		return "form.xhtml";
	}
	
	public String excluir(Cargo obj){
		try {
			fachada.remover(obj);
			return "cargos/index.xhtml?faces-redirect=true";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover o Cargo " + obj.getDescricao(), e.getMessage()));
			return null;
		}
	}
}