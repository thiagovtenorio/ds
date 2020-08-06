package sefaz.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import sefaz.dominio.Usuario;


public class UsuarioDAO extends DAO{
	
	 public void insert(Usuario usuario) {
	    	try {
		    	 pstmt = getConnection().prepareStatement("insert into sgad.usuario(nome, tipo, login, senha) values (?, ?, ?, ?)");         
		         pstmt.setString(1, usuario.getNome());
		         pstmt.setString(2, usuario.getTipo());
		         pstmt.setString(3, usuario.getLogin());
		         pstmt.setString(4, usuario.getSenha());
		         pstmt.executeUpdate();
		         connObj.close();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	  }
	 public ArrayList<Usuario> listColaboradorByNome(String nome) throws SQLException{
		 ArrayList<Usuario> listUsuario=new ArrayList<Usuario>();
		 
		 StringBuilder query=new StringBuilder();
		 query.append("select * from sgad.usuario where nome like '");
		 if(nome!=null) {
			 query.append(nome);
		 }
		 query.append("%'");
		 
		 stmtObj = getConnection().createStatement();    
 		 resultSetObj = stmtObj.executeQuery(query.toString());
 		 Usuario usuario=new Usuario();
 		 while(resultSetObj.next()) {
 			usuario=new Usuario();
 			usuario.setNome(resultSetObj.getString("nome"));
 			listUsuario.add(usuario);
 		 }
 		 
		 return listUsuario;
	 }
	 public boolean login(String login, String senha) throws SQLException {
		 
		 StringBuilder query=new StringBuilder();
		 query.append("select * from sgad.usuario where login='");
		 query.append(login);
		 query.append("'");
		 
		 stmtObj = getConnection().createStatement();    
         resultSetObj = stmtObj.executeQuery(query.toString());
         
         Usuario usuario=new Usuario();
         while(resultSetObj.next()) {
        	usuario.setLogin(resultSetObj.getString("login"));
        	usuario.setSenha(resultSetObj.getString("senha"));
         }
         connObj.close();
         
		 return senha.equals(usuario.getSenha());
	 }
}
