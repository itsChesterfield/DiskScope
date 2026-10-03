package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Directory extends FileNode{
	/**
	 * substructure speichert in eine Liste alle Unterordner und Dateien, von dem angegeben pfad.
	 */
	private List<FileNode> substructure = new ArrayList<>();

	/**
	 * Konstruktor den path an die Oberklasse gibt.
	 * @param path
	 */
	public Directory(String path){
		super(path);
	}

	/**
	 * Fügt ein neuen Knoten zur Liste hinzu.
	 * @param fn
	 * @throws NullPointerException
	 */
	public void addFileNode(FileNode fn)throws NullPointerException{
		if(fn == null) throw new NullPointerException("FileNode darf nicht als null übergeben werden");
		substructure.add(fn);
	}

	/**
	 * Gibt eine View auf substructure wieder, damit man nichts löschen oder ändern kann.
	 * @return
	 */
	public List<FileNode> getSubstructure(){
		return Collections.unmodifiableList(substructure);
	}

	/**
	 * Methode die entweder von einem File getSize aufruft und in size speichert oder rekursiv vom nächsten Verzeichnis aufgerufen wird.
	 * @return size, die Größe von sich selber und ggf. jeder Unterklasse.
	 */
	@Override
	public long getSize() {
		long size = 0;
		for(FileNode n : substructure){
			size += n.getSize();
		}
		return size;
	}
}
