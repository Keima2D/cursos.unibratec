package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import concurso.basicas.Setor;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class SetorBean {
	
	private Setor setor = new Setor();
	private IFachada fachada = Fachada.getInstancia();

	public Setor getSetor() {
		return this.setor;
	}
	
	public List<Setor> getSetores() {
		return fachada.consultarTodosSetores();
	}
	
	public String salvar(){
		if (setor.getId() == null || setor.getId() == 0){
			setor.setId(null);
			fachada.inserir(setor);
		} else {
			fachada.alterar(setor);
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Setor obj){
		this.setor = obj;
		return "form.xhtml";
	}
	
	public String excluir(Setor obj){
		try {
			fachada.remover(obj);
			return "setores/index.xhtml?faces-redirect=true";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover o setor " + obj.getNome(), e.getMessage()));
			return null;
		}
	}
}