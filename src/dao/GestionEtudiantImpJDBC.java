package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Etudiant;

public class GestionEtudiantImpJDBC implements IGestionEtudiant{
	
	Connection connection;
	
	public GestionEtudiantImpJDBC() throws SQLException
	{
		connection=SingletonConnection.getInstance();
	}

	@Override
	public void ajouterEtudiant(Etudiant e) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(
				"insert into etudiant(nom,prenom,filiere,sexe) values(?,?,?,?)");
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			ps.setString(3, e.getFiliere());
			ps.setString(4, e.getSexe());
			ps.executeUpdate();
		
	}

	@Override
	public List<Etudiant> getAllEtudiants()throws SQLException {
		List<Etudiant> liste=new ArrayList<>();
		PreparedStatement ps=connection.prepareStatement("select * from etudiant");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			liste.add(new Etudiant(rs.getInt(1), rs.getString(2),rs.getString(3) , rs.getString(4),rs.getString(5)));
		
		return liste;
	}

	@Override
	public List<Etudiant> getEtudiantsByMC(String mc) throws SQLException{
		List<Etudiant> liste=new ArrayList<>();
		PreparedStatement ps=connection.prepareStatement("select * from etudiant where nom like ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
			liste.add(new Etudiant(rs.getInt(1), rs.getString(2),rs.getString(3) , rs.getString(4),rs.getString(5)));
		
		return liste;
	}

	@Override
	public void trierEtudiantsParNom() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEtudiant(int id)throws SQLException {
		PreparedStatement ps=connection.prepareStatement(
				"delete from etudiant where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		
	}

}
