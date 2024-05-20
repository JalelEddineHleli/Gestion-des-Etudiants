package dao;

import java.sql.SQLException;
import java.util.List;

import metier.Etudiant;

public interface IGestionEtudiant {

	public void ajouterEtudiant(Etudiant e)throws SQLException;

	public List<Etudiant> getAllEtudiants()throws SQLException;

	public List<Etudiant> getEtudiantsByMC(String mc)throws SQLException;

	public void trierEtudiantsParNom();

	public void supprimerEtudiant(int id)throws SQLException;

}
