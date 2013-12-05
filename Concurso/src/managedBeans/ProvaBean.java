package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import concurso.basicas.Prova;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class ProvaBean {
	private Prova prova = new Prova();
	private IFachada fachada = Fachada.getInstancia();
	private Integer orgaoSelecionado = null;
	
	public Prova getProva() {
		return this.prova;
	}
	public List<Prova> getProvas() {
		return fachada.consultarTodasProvas();
	}
	
	public Integer getOrgaoSelecionado () {
		if (this.orgaoSelecionado == null && this.prova.getOrgao() != null) {
			this.orgaoSelecionado = this.prova.getOrgao().getId();
		}

		return orgaoSelecionado;
	}

	public void setOrgaoSelecionado (Integer orgaoSelecionado) {
		this.orgaoSelecionado = orgaoSelecionado;
	}
	
	
	public String salvar () {
		this.prova.setOrgao(Fachada.getInstancia().consultarOrgaoPorId(this.orgaoSelecionado));
		
		if (prova.getId() == null || prova.getId() == 0){
			prova.setId(null);
			fachada.inserir(prova);
		} else {
			fachada.alterar(prova);
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Prova obj){
		this.prova = obj;
		return "form.xhtml";
	}
	
	public String excluir(Prova obj) throws NegocioException{
		try{
			fachada.remover(obj);
			return "provas/index.xhtml?faces-redirect=true";
		}catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover a Prova " + obj.getNome(), e.getMessage()));
			return null;
		}
		
	}
}

