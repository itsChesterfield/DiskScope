package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Max Danigel
 */
public abstract class FileNode {
	/**
	 * pfad speichert wo die Datei / Struktur liegt.
	 */
	private String path;

	private long size;
	/**
	 * substructure speichert in eine Liste alle Unterordner und Dateien, von dem angegeben pfad.
	 */
	private List<FileNode> substructure = new ArrayList<>();

	public FileNode(String pfad, long size){
		this.path = pfad;
		this.size = size;
	}

	/**
	 * gibt den Pfad wieder.
	 * @return
	 */
	public String getPath(){return path;}

	/**
	 * Abstrakte Methode, sie gibt die Größe wieder.
	 * @return
	 */
	abstract public long getSize();
}
