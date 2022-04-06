package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {
	String sql = "";
	
	public boolean isCorrect(String stringa) {
		
		sql = "SELECT id "
				+ "FROM parola p "
				+ "WHERE nome=?";
		
		boolean corretto=false;
		
		try {
			Connection conn = dbConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, stringa);
			
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				if (sql.compareTo("")==0) {
					corretto=false;
				}
				else {
					corretto=true;
				}
			}
			conn.close();
			st.close();
			rs.close();
			
			return corretto;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
}
