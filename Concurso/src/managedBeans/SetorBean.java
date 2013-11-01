package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import concurso.basicas.Setor;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;

@ManagedBean
public class SetorBean {
	
	private List<Setor> setores;
	private IFachada fachada = Fachada.getInstancia();

	public SetorBean () {
		this.setores = fachada.consultarTodosSetores();
	}
	
	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}
}
