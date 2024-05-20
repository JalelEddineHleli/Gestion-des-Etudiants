package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import metier.Etudiant;

public class TableModele extends AbstractTableModel{
	
	private List<Etudiant>liste=new ArrayList<Etudiant>();
	private String titres[]= {"Id","Nom","Prenom","Filiere","Sexe"};

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return liste.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titres.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		switch(columnIndex)
		{
		case 0:return liste.get(rowIndex).getId();
		case 1:return liste.get(rowIndex).getNom();
		case 2:return liste.get(rowIndex).getPrenom();
		case 3:return liste.get(rowIndex).getFiliere();
		case 4:return liste.get(rowIndex).getSexe();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return titres[column];
	}
	
	public void charger(List<Etudiant> l)
	{
		this.liste=l;
		fireTableDataChanged();
	}

}
