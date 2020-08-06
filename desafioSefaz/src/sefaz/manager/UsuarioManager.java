package sefaz.manager;

import java.sql.SQLException;
import sefaz.dao.UsuarioDAO;

public class UsuarioManager { 
	private UsuarioDAO usuarioDAO;
	
	public UsuarioManager(){
		this.usuarioDAO=new UsuarioDAO();
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