package sefaz.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import sefaz.dominio.Usuario;
import sefaz.filtro.FiltroUsuario;
import sefaz.manager.UsuarioManager;

@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class UsuarioListBean {
	private UsuarioManager usuarioManager;
	
	private ArrayList<Usuario> usuarioList;
	
	private Usuario usuario;
	
	private FiltroUsuario filtro;
	
	@PostConstruct
    public void init() {
		this.usuarioManager=new UsuarioManager();
		this.usuarioList=usuarioManager.list();
		this.filtro=new FiltroUsuario();
	}
	public void pesquisar() {
		this.usuarioList=usuarioManager.findByFilter(filtro);
	}
	
	public String excluir() {
		this.usuarioManager.delete(this.usuario);
		return "/usuarioList.xhtml?faces-redirect=true";
	}
	
	public String alterar() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMapObj.put("operacao", "alterar");
		sessionMapObj.put("usuario", usuario);
		return "/usuarioEdit.xhtml?faces-redirect=true";
	}
	public String detalhar() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMapObj.put("operacao", "detalhar");
		sessionMapObj.put("usuario", usuario);
		return "/usuarioEdit.xhtml?faces-redirect=true";
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
	public FiltroUsuario getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroUsuario filtro) {
		this.filtro = filtro;
	}
	
}
