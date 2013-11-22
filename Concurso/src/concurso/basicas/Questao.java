package concurso.basicas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questoes")
public class Questao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Disciplina disciplina;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Funcionario professor;
	
	private String introducao;
	
	private String pergunta;
	
	@Column(name="alternativa_a")
	private String alternativaA;
	
	@Column(name="alternativa_b")
	private String alternativaB;

	@Column(name="alternativa_c")
	private String alternativaC;
	
	@Column(name="alternativa_d")
	private String alternativaD;
	
	@Column(name="alternativa_e")
	private String alternativaE;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="alternativa_correta")
	private Alternativa alternativaCorreta;
	
	@Enumerated(EnumType.ORDINAL)
	private NivelQuestao nivel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Funcionario getProfessor() {
		return professor;
	}

	public void setProfessor(Funcionario professor) {
		this.professor = professor;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public String getAlternativaE() {
		return alternativaE;
	}

	public void setAlternativaE(String alternativaE) {
		this.alternativaE = alternativaE;
	}

	public Alternativa getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Alternativa alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public NivelQuestao getNivel() {
		return nivel;
	}

	public void setNivel(NivelQuestao nivel) {
		this.nivel = nivel;
	}
}