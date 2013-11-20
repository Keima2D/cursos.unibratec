package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;

import utils.MD5;
import concurso.basicas.Funcionario;
import concurso.fachada.Fachada;
import concurso.fachada.IFachada;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String email;
	private String senha;
	private Funcionario usuarioLogado;
	private IFachada fachada = Fachada.getInstancia();
	
	public String efetuarLogin(){
		try {
			usuarioLogado = fachada.efetuarLogin(email, new MD5(senha).getHash());
		} catch (LoginException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login/Senha inexistente"));
		}
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String efetuarLogin2() throws LoginException{
		try {
			usuarioLogado = fachada.efetuarLogin(email, senha);
			return "/home.xhtml?faces-redirect=true";	
		} catch (LoginException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login/Senha inexistente"));
		}
		return "/index.xhtml?faces-redirect=true";
	}
	
	public String efetuarLogoff(){
		usuarioLogado = null;
		return "/index.xhtml?faces-redirect=true";
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
	public Funcionario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Funcionario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
