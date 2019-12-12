package be.grangier.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import be.grangier.POJO.Joueur;
import be.grangier.POJO.Personne;


public class JoueurDAO extends DAO<Joueur> {
	
	public JoueurDAO(Connection conn){
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
	public ArrayList<Joueur> findAll(){
			ArrayList<Joueur> listJoueur = new ArrayList<Joueur>();
			Joueur joueur = null;
			try
			{
				ResultSet result = this.connect.createStatement(
				
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT num_joueur_PK,classement, nom,prenom,age,sexe,pays FROM Joueur a inner join Personne b on a.num_joueur_PK=b.num_pers_PK;");
				/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
						inner join equipe_joueur c on b.*/
			while(result.next())
			{	
				joueur = new Joueur();
				joueur.setId(result.getInt("num_joueur_PK"));
				joueur.setClassement(result.getInt("classement"));
				joueur.setPrenom(result.getString("prenom"));
				joueur.setAge(result.getInt("age"));
				joueur.setSexe(result.getString("sexe"));
				joueur.setPays(result.getString("pays"));
				listJoueur.add(joueur);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return listJoueur;
		}
	
	public ArrayList<Joueur> findAllMas(){
		ArrayList<Joueur> listJoueurm = new ArrayList<Joueur>();
		Joueur joueur = null;
		try
		{
			ResultSet result = this.connect.createStatement(
			
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT num_joueur_PK,classement, nom,prenom,age,sexe,pays FROM Joueur a inner join Personne b on a.num_joueur_PK=b.num_pers_PK; where sexe='M' ;");
			/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
					inner join equipe_joueur c on b.*/
		while(result.next())
		{	
			joueur = new Joueur();
			joueur.setId(result.getInt("num_joueur_PK"));
			joueur.setClassement(result.getInt("classement"));
			joueur.setPrenom(result.getString("prenom"));
			joueur.setAge(result.getInt("age"));
			joueur.setSexe(result.getString("sexe"));
			joueur.setPays(result.getString("pays"));
			listJoueurm.add(joueur);
		}
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return listJoueurm;
	}
	
	public ArrayList<Joueur> findAllFem(){
		ArrayList<Joueur> listJoueurf = new ArrayList<Joueur>();
		Joueur joueur = null;
		try
		{
			ResultSet result = this.connect.createStatement(
			
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT num_joueur_PK,classement, nom,prenom,age,sexe,pays FROM Joueur a inner join Personne b on a.num_joueur_PK=b.num_pers_PK where sexe='F';");
			/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
					inner join equipe_joueur c on b.*/
		while(result.next())
		{	
			joueur = new Joueur();
			joueur.setId(result.getInt("num_joueur_PK"));
			joueur.setClassement(result.getInt("classement"));
			joueur.setPrenom(result.getString("prenom"));
			joueur.setAge(result.getInt("age"));
			joueur.setSexe(result.getString("sexe"));
			joueur.setPays(result.getString("pays"));
			listJoueurf.add(joueur);
		}
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
	return listJoueurf;
	}
	
}