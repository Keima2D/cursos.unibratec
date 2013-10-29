package concurso.basicas;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="TBFuncionario")
public class Funcionario {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDFuncionario")
	private Integer id;
	@Column(name="Nome", length=50)
	private String nome;
	@Enumerated(EnumType.STRING)
	@Column(name="Sexo", length=1)
	private Sexo sexo;
	@Embedded
	private Endereco endereco;
	@Column(name="CPF", length=14)
	private String CPF;
	@Column(name="RG", length=12)
	private String RG;
	@Temporal(TemporalType.DATE)
	@Column(name="DataNascimento", length=10)
	private Date dataNascimento;
	@Column(name="Telefone", length=15)
	private String telefone;
	@Column(name="Email", length=30)
	private String email;
	@Column(name="Senha", length=30)
	private String senha;
	@Column(name="NomePai", length=50)
	private String nomePai;
	@Column(name="NomeMae", length=50)
	private String nomeMae;
	@Column(name="Observacao", length=50)
	private String observacao;
	@ManyToOne
	@JoinColumn(name="IDCargo")
	private Cargo cargo;
	@ManyToOne
	@JoinColumn(name="IDSetor")
	private Setor setor;
	@Temporal(TemporalType.DATE)
	@Column(name="DataAdmissao", length=10)
	private Date dataAdmissao;
	@Column(name="DataDemissao", length=10)
	private Date dataDemissao;
	@ElementCollection
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
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
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
