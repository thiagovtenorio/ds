package sefaz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import sefaz.dominio.Usuario;
import sefaz.filtro.FiltroUsuario;


public class UsuarioDAO extends DAO{
		
	
	 public ArrayList<Usuario> list() throws SQLException{
		 ArrayList<Usuario> usuarioList=new ArrayList<Usuario>();
		 
		 StringBuilder query=new StringBuilder();
		 query.append("select * from sefaz.usuario");
		 
		 stmtObj = getConnection().createStatement();    
 		 resultSetObj = stmtObj.executeQuery(query.toString());
 		 Usuario usuario=new Usuario();
 		 while(resultSetObj.next()) {
 			usuario=new Usuario();
 			usuario.setId(resultSetObj.getInt("idusuario"));
 			usuario.setNome(resultSetObj.getString("nome"));
 			usuario.setEmail(resultSetObj.getString("email"));
 			usuario.setLogin(resultSetObj.getString("login"));
 			usuario.setSenha(resultSetObj.getString("senha"));
 			usuarioList.add(usuario);
 		 }
		 return usuarioList;
	 }
	 public ArrayList<Usuario> findByFilter(FiltroUsuario filtro) throws SQLException{
		 ArrayList<Usuario> usuarioList=new ArrayList<Usuario>();
		 StringBuilder query=new StringBuilder();
		 query.append("select * from sefaz.usuario");
		 
		 if(filtro.getNome()!=null) {
			 query.append(" where nome like '");
			 query.append(filtro.getNome());
			 query.append("%'");
		 }
		 
		 stmtObj = getConnection().createStatement();    
 		 resultSetObj = stmtObj.executeQuery(query.toString());
 		 Usuario usuario=new Usuario();
 		 while(resultSetObj.next()) {
 			usuario=new Usuario();
 			usuario.setId(resultSetObj.getInt("idusuario"));
 			usuario.setNome(resultSetObj.getString("nome"));
 			usuario.setEmail(resultSetObj.getString("email"));
 			usuario.setLogin(resultSetObj.getString("login"));
 			usuario.setSenha(resultSetObj.getString("senha"));
 			usuarioList.add(usuario);
 		 }
		 return usuarioList;
	 }
	 
	 public int insert(Usuario usuario) {
		 int generatedKey = 0;
		 	try {
		    	 pstmt = getConnection().prepareStatement("insert into sefaz.usuario(nome, login, senha, email) values (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);         
		         pstmt.setString(1, usuario.getNome());
		         pstmt.setString(2, usuario.getLogin());
		         pstmt.setString(3, usuario.getSenha());
		         pstmt.setString(4, usuario.getEmail());
		         pstmt.execute();
		         
				 ResultSet rs = pstmt.getGeneratedKeys();
				 
				 if (rs.next()) {
				     generatedKey = rs.getInt(1);
				 }
		         
		         connObj.close();
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 return generatedKey;
	 }
	 public void update(Usuario usuario) throws SQLException {
		 pstmt = getConnection().prepareStatement("update sefaz.usuario set nome=?, login=?, senha=?, email=? where idusuario=?");
		 pstmt.setString(1, usuario.getNome());
		 pstmt.setString(2, usuario.getLogin());
		 pstmt.setString(3, usuario.getSenha());
		 pstmt.setString(4, usuario.getEmail());
		 pstmt.setInt(5, usuario.getId());
		 pstmt.executeUpdate();
         connObj.close();
	 }
	 public void delete(Usuario usuario) {
		 try {
			 pstmt = getConnection().prepareStatement("delete from sefaz.usuario where idusuario = "+usuario.getId());  
	         pstmt.executeUpdate();  
	         connObj.close();
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public Usuario login(String login, String senha) throws SQLException {
		 
		 StringBuilder query=new StringBuilder();
		 query.append("select * from sefaz.usuario where login='");
		 query.append(login);
		 query.append("'");
		 
		 stmtObj = getConnection().createStatement();    
         resultSetObj = stmtObj.executeQuery(query.toString());
         
         Usuario usuario=new Usuario();
         while(resultSetObj.next()) {
        	usuario.setNome(resultSetObj.getString("nome"));
        	usuario.setLogin(resultSetObj.getString("login"));
        	usuario.setSenha(resultSetObj.getString("senha"));
         }
         connObj.close();
         
		 return usuario;
	 }
}
