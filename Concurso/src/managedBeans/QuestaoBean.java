package managedBeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import concurso.basicas.Questao;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class QuestaoBean {

	private Questao questao = new Questao();
	private IFachada fachada = Fachada.getInstancia();

	public Questao getQuestao() {
		return this.questao;
	}

	public List<Questao> getQuestoes() {
		return fachada.consultarTodasQuestoes();
	}
	
	public String salvar () {
		if (questao.getId() == null || questao.getId() == 0){
			questao.setId(null);
			fachada.inserir(questao);
		} else {
			fachada.alterar(questao);
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Questao obj){
		this.questao = obj;
		return "form.xhtml";
	}
	
	public String excluir(Questao obj){
		try {
			fachada.remover(obj);
			return "questoes/index.xhtml?faces-redirect=true";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode remover a questao " + obj.getId(), e.getMessage()));
			return null;
		}
	}
	
}
