package concurso.basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="TBSetor")
public class Setor {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDSetor")
	private Integer id;
	@Column(name="Nome", length=50)
	private String nome;

	private Setor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}