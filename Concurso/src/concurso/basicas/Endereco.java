package concurso.basicas;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable 
public class Endereco {
	
	@Column(name="Logradouro", length=50)
	private String logradouro;
	@Column(name="UF", length=2)
	private short UF;
	@Column(name="CEP", length=10)
	private String CEP;
	@Column(name="Bairro", length=20)
	private String bairro;
	@Column(name="Cidade", length=20)
	private String cidade;
	@Column(name="Complemento", length=50)
	private String complemento;
	@Column(name="Numero", length=10)
	private String numero;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public short getUF() {
		return UF;
	}

	public void setUF(short uF) {
		UF = uF;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
