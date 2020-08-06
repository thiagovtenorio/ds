package sefaz.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sefaz.dominio.Usuario;
import sefaz.manager.UsuarioManager;


@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private UsuarioManager usuarioManager;
	private String nomeColaborador;
	
	@PostConstruct
    public void init() {
		this.usuarioManager=new UsuarioManager();
		this.usuario=new Usuario();
	}
	
	public String cadastrar() {
		this.usuarioManager.insert(this.usuario);
		return "sgadLogin.xhtml";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNomeColaborador() {
		return nomeColaborador;
	}
	public void setNomeColaborador(String nomeColaborador) {
		this.nomeColaborador = nomeColaborador;
	}
}
