package be.grangier.DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.grangier.DAO.DAO;
import be.grangier.POJO.Personne;

public class PersonneDAO extends DAO<Personne> {
	
	public PersonneDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Personne obj){
		return false;
	}
	
	public boolean delete(Personne obj){
		return false;
	}
	
	public boolean update(Personne obj){
		return false;
	}

	//List
		public List<Personne> list(){
			List<Personne> list = new ArrayList<Personne>();
			try
			{
				ResultSet result = this.connect.createStatement(
				
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Personne");
				
				while(result.next()) 
				{
					//Personne personne = new Personne();
					//list.add(new Personne(result.getInt("Personne.num_pers_PK"),result.getString("Personne.nom"),result.getString("Personne.prenom"),result.getInt("Personne.age"),,result.getString("Personne.sexe"),result.getString("Personne.pays"));
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
			return list;
		}
		

}
