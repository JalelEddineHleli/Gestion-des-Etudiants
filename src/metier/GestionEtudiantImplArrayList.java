package metier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.IGestionEtudiant;

public class GestionEtudiantImplArrayList implements IGestionEtudiant{

	private List<Etudiant> liste=new ArrayList<Etudiant>();
	@Override
	public void ajouterEtudiant(Etudiant e) {
		liste.add(e);
		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return liste;
	}

	@Override
	public List<Etudiant> getEtudiantsByMC(String mc) {
		List<Etudiant> l=new ArrayList<Etudiant>();
		for(Etudiant e:liste)
			if(e.getNom().contains(mc)|| e.getPrenom().contains(mc))
				l.add(e);
		return l;
	}

	@Override
	public void trierEtudiantsParNom() {
		liste.sort((a,b)->a.getNom().compareTo(b.getNom()));
		
	}

	@Override
	public void supprimerEtudiant(int id) {
		
		for(Iterator<Etudiant>i=liste.iterator();i.hasNext();)
		{
			Etudiant e=i.next();
			if(e.getId()==id)
				i.remove();
		}
		
	}

}
