package be.grangier.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.grangier.POJO.Arbitre;
import be.grangier.POJO.Joueur;



public class ArbitreDAO extends DAO<Arbitre> {
	
	public ArbitreDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Arbitre obj){
		return false;
	}
	
	public boolean delete(Arbitre obj){
		return false;
	}
	
	public boolean update(Arbitre obj){
		return false;
	}

	//List
		public List<Arbitre> list(){
			List<Arbitre> list = new ArrayList<Arbitre>();
			try
			{
				ResultSet result = this.connect.createStatement(
				
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Arbitre");
				
				while(result.next()) 
				{
					//list.add(new Arbitre();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
			return list;
		}
		
		public ArrayList<Arbitre> findAll(){
			ArrayList<Arbitre> listArbitre = new ArrayList<Arbitre>();
			Arbitre arbitre = null;
			try
			{
				ResultSet result = this.connect.createStatement(
				
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT num_arbitre_PK,carrière, nom,prenom,age,sexe,pays FROM Arbitre a inner join Personne b on a.num_arbitre_PK=b.num_pers_PK;");
				/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
						inner join equipe_joueur c on b.*/
			while(result.next())
			{	
				arbitre = new Arbitre();
				arbitre.setId(result.getInt("num_arbitre_PK"));
				arbitre.setCarrier(result.getInt("carrière"));
				arbitre.setPrenom(result.getString("prenom"));
				arbitre.setAge(result.getInt("age"));
				arbitre.setSexe(result.getString("sexe"));
				arbitre.setPays(result.getString("pays"));
				listArbitre.add(arbitre);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listArbitre;
		}
}
