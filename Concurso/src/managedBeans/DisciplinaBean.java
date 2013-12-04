package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import concurso.basicas.Disciplina;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;
import concurso.negocio.NegocioException;

@ManagedBean
public class DisciplinaBean {
	
	private Disciplina disciplina = new Disciplina();
	private IFachada fachada = Fachada.getInstancia();

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return fachada.consultarTodasDisciplinas();
	}
	
	public String salvar () {
		if (disciplina.getId() == null || disciplina.getId() == 0){
			disciplina.setId(null);
			fachada.inserir(disciplina);
		} else {
			fachada.alterar(disciplina);
		}
		return "index.xhtml?faces-redirect=true";
	}
	
	public String editar(Disciplina obj){
		this.disciplina = obj;
		return "form.xhtml?faces-redirect=true";
	}
	
	public String excluir(Disciplina obj){
		try {
			fachada.remover(obj);
			return "disciplinas/index.xhtml?faces-redirect=true";
		} catch (NegocioException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		}
	}
}