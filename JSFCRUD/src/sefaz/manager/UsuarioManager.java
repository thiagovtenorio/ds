package sefaz.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import sefaz.dao.TelefoneDAO;
import sefaz.dao.UsuarioDAO;
import sefaz.dominio.Telefone;
import sefaz.dominio.Usuario;
import sefaz.filtro.FiltroUsuario;

public class UsuarioManager { 
	private UsuarioDAO usuarioDAO;
	private TelefoneDAO telefoneDAO;
	
	public UsuarioManager(){
		this.usuarioDAO=new UsuarioDAO();
		this.telefoneDAO=new TelefoneDAO();
	}
	public ArrayList<Usuario> list(){
		try {
			return usuarioDAO.list();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Usuario>();
	}
	public ArrayList<Usuario> findByFilter(FiltroUsuario filtro){
		 ArrayList<Usuario> usuarioList=new ArrayList<Usuario>();
		 try {
			 usuarioList=usuarioDAO.findByFilter(filtro);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return usuarioList;
	}
	
	public void insert(Usuario usuario) {
		int usuarioId=usuarioDAO.insert(usuario);
		
		for(Telefone telefone: usuario.getTelefones()) {
			telefone.setUsuarioId(usuarioId);
			this.telefoneDAO.insert(telefone);
		}
		
	}
	public void update(Usuario usuario) {
		try {
			
			for(Telefone telefone:usuario.getTelefones()) {
				if(telefone.getId()==0) {
					telefone.setUsuarioId(usuario.getId());
					telefoneDAO.insert(telefone);
				}
			}
			
			this.usuarioDAO.update(usuario);
			
		}catch(Exception e) {
			
		}
	}
	public void delete(Usuario usuario) {
		try {
			ArrayList<Telefone> telefonesUsuario=this.telefoneDAO.findTelefonesByUsuarioId(usuario.getId());
			for(Telefone telefone:telefonesUsuario) {
				this.telefoneDAO.delete(telefone);
			}
			this.usuarioDAO.delete(usuario);
			
		}catch(Exception e) {
			
		}
	}
	
	public Usuario login(String login, String senha) {
		try {
			return usuarioDAO.login(login, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}