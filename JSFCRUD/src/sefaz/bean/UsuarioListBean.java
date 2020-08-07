package sefaz.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sefaz.dominio.Usuario;
import sefaz.manager.UsuarioManager;

@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class UsuarioListBean {
	private UsuarioManager usuarioManager;
	
	private ArrayList<Usuario> usuarioList;
	
	private Usuario usuario;
	
	@PostConstruct
    public void init() {
		this.usuarioManager=new UsuarioManager();
		this.usuarioList=usuarioManager.list();
	}
	
	public String alterar() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMapObj.put("operacao", "alterar");
		sessionMapObj.put("usuario", usuario);
		return "/usuarioEdit.xhtml?faces-redirect=true";
	}
	public String detalhar() {
		return "";
	}
	
	public ArrayList<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(ArrayList<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
