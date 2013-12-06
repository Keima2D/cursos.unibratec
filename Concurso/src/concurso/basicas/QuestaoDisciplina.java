package concurso.basicas;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questoes_disciplinas")
@AssociationOverrides({
	@AssociationOverride(name = "disciplina", joinColumns = @JoinColumn(name = "disciplina_id"))
})
public class QuestaoDisciplina {
	private Integer quantidade;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina;

	public QuestaoDisciplina () {
	}
	
	public QuestaoDisciplina (Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
