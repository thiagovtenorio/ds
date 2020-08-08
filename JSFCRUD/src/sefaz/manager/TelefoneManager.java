package sefaz.manager;

import java.util.ArrayList;

import sefaz.dao.TelefoneDAO;
import sefaz.dominio.Telefone;

public class TelefoneManager {
	private TelefoneDAO telefoneDAO;
	
	public TelefoneManager() {
		telefoneDAO=new TelefoneDAO();
	}
	public ArrayList<Telefone> findTelefonesByUsuarioId(int usuarioId) {
		try {
			return telefoneDAO.findTelefonesByUsuarioId(usuarioId);
		}catch(Exception e) {
			e.printStackTrace();
			return new ArrayList<Telefone>();
		}
	}
}
