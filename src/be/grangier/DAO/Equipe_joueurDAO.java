package be.grangier.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.grangier.POJO.Equipe;
import be.grangier.POJO.Equipe_joueur;
import be.grangier.POJO.Joueur;
import be.grangier.POJO.Personne;

public class Equipe_joueurDAO extends DAO<Equipe_joueur> {
	
	public Equipe_joueurDAO(Connection conn){
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
	
	
		public ArrayList<Equipe_joueur> findAlltype(int groupe){
				ArrayList<Equipe_joueur> listEquipe = new ArrayList<Equipe_joueur>();
				Equipe_joueur equipe_joueur = null;
				Personne personne = null;
				try
				{
					ResultSet result = this.connect.createStatement(
					
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT joueur,nom,prenom FROM Equipe a inner join Joueur b on a.joueur=b.num_joueur_PK inner join Personnne c on b.num_joueur_PK=c.num_pers_PK  where equipe_joueur='groupe';");
					/*select nom from personne a inner join joueur b on a.num_pers_pk=b.num_joueur.num_joueur_pk
							inner join equipe_joueur c on b.*/
				while(result.next())
				{	
					equipe_joueur = new Equipe_joueur();
					equipe_joueur.setJoueur(result.getInt("joueur"));
					personne = new Personne(result.getNom("nom"),result.getPrenom("prenom"));
					equipe_joueur.setEquipe(personne);
					listEquipe.add(equipe_joueur);
				}
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return listEquipe;
			}
		
		
}{

}
