package concurso.basicas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="dependentes")
public class Dependente {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="sexo", length=1)
	private Sexo sexo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dataNascimento")
	private Date dataNascimento;
	
	@Embedded
	private Endereco endereco;
	
	@Column(name="cpf", length=14)
	private String cpf;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public void setCPF(String cPF) {
		cpf = cPF;
	}


}