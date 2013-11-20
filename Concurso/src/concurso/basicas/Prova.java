package concurso.basicas;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity @Table(name="provas")
public class Prova {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome",length=45)
	private String nome;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="nivel")
	private Integer nivel;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_aplicacao")
	private Date data_aplicacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="orgao_id")
	private Orgao orgao;
	
	@ElementCollection
	@JoinTable(
		joinColumns=@JoinColumn(name="prova_id"),
		inverseJoinColumns=@JoinColumn(name="disciplina_id")
	)
	private Collection <Disciplina> disciplina;

	public Orgao getOrgao() {
		return orgao;
	}

	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Date getData_aplicacao() {
		return data_aplicacao;
	}

	public void setData_aplicacao(Date data_aplicacao) {
		this.data_aplicacao = data_aplicacao;
	}

	public Collection<Disciplina> getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Collection<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
}