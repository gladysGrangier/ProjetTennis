package be.grangier.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.grangier.POJO.Equipe;
import be.grangier.POJO.Joueur;

public class EquipeDAO extends DAO<Equipe> {
	
	public EquipeDAO(Connection conn){
		super(conn);
	}
	
	public boolean create(Joueur obj){
		return false;
	}
	
	public boolean delete(Joueur obj){
		return false;
	}
	
	public boolean update(Joueur obj){
		return false;
	}

	//List
	public int totalgroupe(String type){
			int total = 0;
			try
			{
				ResultSet result = this.connect.createStatement(
				
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT count(*) FROM Equipe where genre ='type';");
				/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
						inner join equipe_joueur c on b.*/
			while(result.next())
			{	
				//
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return total;
		}
	
		public ArrayList<Equipe> findAlltype(String type){
				ArrayList<Equipe> listEquipe = new ArrayList<Equipe>();
				Equipe equipe = null;
				try
				{
					ResultSet result = this.connect.createStatement(
					
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id_equipe_Pk FROM Equipe where genre='type';");
					/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
							inner join equipe_joueur c on b.*/
				while(result.next())
				{	
					equipe = new Equipe();
					equipe.setIdE(result.getInt("id_equipe_Pk"));
					listEquipe.add(equipe);
				}
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return listEquipe;
			}
		
		
}
