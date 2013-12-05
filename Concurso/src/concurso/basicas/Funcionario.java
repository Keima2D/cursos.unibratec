package concurso.basicas;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQuery(name="efetuarLogin", query="Select u from Funcionario u where u.email = :email and u.senha = :senha")
@Entity @Table(name="funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome", length=50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sexo", length=1)
	private Sexo sexo;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name="cpf", length=14)
	private String cpf;
	
	@Column(name="rg", length=12)
	private String rg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataNascimento", length=10)
	private Date dataNascimento;
	
	@Column(name="telefone", length=15)
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="senha", length=32)
	private String senha;
	
	@Column(name="nomePai", length=50)
	private String nomePai;
	
	@Column(name="nomeMae", length=50)
	private String nomeMae;
	
	@Column(name="observacao", length=255)
	private String observacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Cargo cargo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="setor_id")
	private Setor setor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataAdmissao")
	private Date dataAdmissao;
	
	@Column(name="dataDemissao")
	private Date dataDemissao;
	
	@ElementCollection
	@JoinTable(
		joinColumns=@JoinColumn(name="funcionario_id"),
		inverseJoinColumns=@JoinColumn(name="dependente_id")
	)
	private Collection <Dependente> dependentes;

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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getRG() {
		return rg;
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Collection<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Collection<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	
	
}
