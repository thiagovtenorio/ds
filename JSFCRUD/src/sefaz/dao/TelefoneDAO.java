package sefaz.dao;

import sefaz.dominio.Telefone;

public class TelefoneDAO extends DAO{
	public void insert(Telefone telefone) {
		try {
			 pstmt = getConnection().prepareStatement("insert into sefaz.telefoneusuario(idusuario, ddd, numero, tipo) values (?, ?, ?, ?)"); 
			 pstmt.setInt(1, telefone.getUsuarioId());
			 pstmt.setInt(2, telefone.getDdd());
			 pstmt.setString(3, telefone.getNumero());
			 pstmt.setString(4, telefone.getTipo());
			 pstmt.executeUpdate();
	         connObj.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
