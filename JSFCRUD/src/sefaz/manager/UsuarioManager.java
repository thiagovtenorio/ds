package sefaz.manager;

import java.sql.SQLException;

import sefaz.dao.UsuarioDAO;
import sefaz.dominio.Usuario;

public class UsuarioManager { 
	private UsuarioDAO usuarioDAO;
	
	public UsuarioManager(){
		this.usuarioDAO=new UsuarioDAO();
	}
	public void insert(Usuario usuario) {
		this.usuarioDAO.insert(usuario);
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