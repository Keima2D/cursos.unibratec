package concurso.basicas;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@Column(name="descricao", columnDefinition="TEXT")
	private String descricao;
	
	@Column(name="observacao", columnDefinition="TEXT")
	private String observacao;
	
	@Column(name="nivel")
	private NivelQuestao nivel;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_aplicacao")
	private Date dataAplicacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="orgao_id")
	private Orgao orgao;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<QuestaoDisciplina> questoesPorDisciplina;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Questao> questoes;
	
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

	public NivelQuestao getNivel() {
		return nivel;
	}

	public void setNivel(NivelQuestao nivel) {
		this.nivel = nivel;
	}

	public Date getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(Date dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	public List<QuestaoDisciplina> getQuestoesPorDisciplina() {
		return questoesPorDisciplina;
	}

	public void setQuestoesPorDisciplina(
			List<QuestaoDisciplina> questoesPorDisciplina) {
		this.questoesPorDisciplina = questoesPorDisciplina;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

}