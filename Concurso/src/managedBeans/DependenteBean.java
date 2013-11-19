package managedBeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import concurso.basicas.Dependente;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;

@ManagedBean
public class DependenteBean {
	
	private Dependente dependente = new Dependente();
	private IFachada fachada = Fachada.getInstancia();

	public Dependente getDepedente() {
		return this.dependente;
	}

	public List<Dependente> getDependentes() {
		return fachada.consultarTodosDependentes();
	}
	
	public String salvar(){
		if (dependente.getId() == null || dependente.getId() == 0){
			dependente.setId(null);
			fachada.inserir(dependente);
		} else {
			fachada.alterar(dependente);
		}
		return "index.xhtml";
	}
	
	public String editar(Dependente obj){
		this.dependente = obj;
		return "form.xhtml";
	}
	
}