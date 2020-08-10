package sefaz.bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sefaz.dominio.Usuario;
import sefaz.manager.UsuarioManager;

@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class LoginBean {
	private String login;
	private String senha;
	private UsuarioManager usuarioManager;
	
	@PostConstruct
    public void init() {
		usuarioManager=new UsuarioManager();
	}
	public String entrar() {
		
		Usuario usuarioLogado=usuarioManager.login(this.login, this.senha);
		
		if(this.senha.equals(usuarioLogado.getSenha())) {
			Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			sessionMapObj.put("usuarioLogado", usuarioLogado);
			return "sefazPaginaPrincipal.xhtml";
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Usuário ou senha inválida."));
			return "sefazLogin.xhtml";
		}
	}
	public String getNomeUsuarioLogado() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario usuario=(Usuario)sessionMapObj.get("usuarioLogado");
		return usuario.getNome();
	}
	public String cadastrar() {
		return "usuarioNaoLogadoEdit.xhtml";
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
