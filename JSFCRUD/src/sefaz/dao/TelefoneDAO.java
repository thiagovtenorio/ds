package sefaz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

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
	public ArrayList<Telefone> findTelefonesByUsuarioId(int usuarioId) throws SQLException{
		ArrayList<Telefone> telefoneList=new ArrayList<Telefone>();
		stmtObj = getConnection().createStatement();    
		resultSetObj = stmtObj.executeQuery("select * from sefaz.telefoneusuario where idusuario ="+usuarioId);
		
		Telefone telefone=new Telefone();
		while(resultSetObj.next()) { 
			telefone=new Telefone();
			telefone.setId(resultSetObj.getInt("id"));
			telefone.setUsuarioId(resultSetObj.getInt("idusuario"));
			telefone.setDdd(resultSetObj.getInt("ddd"));
			telefone.setNumero(resultSetObj.getString("numero"));
			telefone.setTipo(resultSetObj.getString("tipo"));
			telefoneList.add(telefone);
		}
		connObj.close();
		return telefoneList;
	}
}
