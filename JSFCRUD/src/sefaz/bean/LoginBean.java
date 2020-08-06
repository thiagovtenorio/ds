package sefaz.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import sefaz.manager.UsuarioManager;

@SuppressWarnings("restriction")
@ManagedBean @RequestScoped
public class LoginBean {
	private String login;
	private String senha;
	private UsuarioManager usuarioManager;
	
	@PostConstruct
    public void init() {
		usuarioManager=new UsuarioManager();
	}
	public String entrar() {
		if(usuarioManager.login(this.login, this.senha)) {
			return "sgadPaginaPrincipal.xhtml";
		}else {
			return "sgadLogin.xhtml";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
