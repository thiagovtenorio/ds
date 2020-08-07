package sefaz.bean;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sefaz.dominio.Telefone;
import sefaz.dominio.Usuario;
import sefaz.manager.UsuarioManager;


@SuppressWarnings("restriction")
@ManagedBean @ViewScoped
public class UsuarioEditBean {
	private Usuario usuario;
	private Telefone telefone;
	private UsuarioManager usuarioManager;
	private String nomeColaborador;
	private String operacao;
	
	@PostConstruct
    public void init() {
		inicializarOperacao();
		
		if(isOperacaoAlteracao()) 
		{
			this.usuario=getUsuarioFromAnotherBean();
		}else if(isOperacaoDetalhamento()) {
			this.usuario=getUsuarioFromAnotherBean();
		}else {
			this.usuario=new Usuario();
			this.usuario.setTelefones(new ArrayList<Telefone>());
		}
		
		this.usuarioManager=new UsuarioManager();
		this.telefone=new Telefone();
	}
	public boolean isOperacaoAlteracao() {
		return operacao.equals("alterar");
	}
	public boolean isOperacaoDetalhamento() {
		return operacao.equals("detalhar");
	}
	
	
	public Usuario getUsuarioFromAnotherBean() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		return (Usuario)sessionMapObj.get("usuario");
	}
	
	public void inicializarOperacao() {
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		this.operacao=(sessionMapObj.get("operacao")==null? "":(String) sessionMapObj.get("operacao"));
	}
	
	public void adicionarTelefone() {
		this.usuario.getTelefones().add(this.telefone);
		this.telefone=new Telefone();
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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

}
