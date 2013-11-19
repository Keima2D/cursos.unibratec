package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import concurso.basicas.Endereco;
import concurso.basicas.Orgao;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class OrgaoBean {
	
	private Orgao orgao = new Orgao();
	private IFachada fachada = Fachada.getInstancia();

	public Orgao getOrgao() {
		if (this.orgao.getEndereco() == null) {
			this.orgao.setEndereco(new Endereco());
		}
		
		return this.orgao;
	}

	public List<Orgao> getOrgaos() {
		return fachada.consultarTodosOrgaos();
	}
	
	public String salvar(){
		if (orgao.getId() == null || orgao.getId() == 0){
			orgao.setId(null);
			fachada.inserir(orgao);
		} else {
			fachada.alterar(orgao);
		}
		return "index.xhtml";
	}
	
	public String editar(Orgao obj){
		this.orgao = obj;
		return "form.xhtml";
	}
	
	public String excluir(Orgao obj){
		try {
			fachada.remover(obj);
			return "orgaos/index.xhtml";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover o Orgão " + obj.getNome(), e.getMessage()));
			return null;
		}
	}
}