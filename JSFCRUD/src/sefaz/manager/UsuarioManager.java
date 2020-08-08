package sefaz.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import sefaz.dao.TelefoneDAO;
import sefaz.dao.UsuarioDAO;
import sefaz.dominio.Telefone;
import sefaz.dominio.Usuario;

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
	
	public void insert(Usuario usuario) {
		int usuarioId=usuarioDAO.insert(usuario);
		
		for(Telefone telefone: usuario.getTelefones()) {
			telefone.setUsuarioId(usuarioId);
			this.telefoneDAO.insert(telefone);
		}
		
	}
	public void update(Usuario usuario) {
		try {
			this.usuarioDAO.update(usuario);
		}catch(Exception e) {
			
		}
	}
	public void delete(Usuario usuario) {
		this.usuarioDAO.delete(usuario);
	}
	
	public boolean login(String login, String senha) {
		try {
			return usuarioDAO.login(login, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}