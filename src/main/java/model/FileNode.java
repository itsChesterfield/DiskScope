package model;
import java.util.ArrayList;
import java.util.List;

public class FileNode {
	/**
	 * pfad speichert wo die Datei / Struktur liegt.
	 */
	String pfad;
	/**
	 * file speichert ob es sich um eine Datei handelt.
	 */
	boolean file;
	/**
	 * directory speucehrt ob es sich um ein Verzeichnis handelt.
	 */
	boolean directory;
	/**
	 * size speichert die Datei / Verzeichnis Größe.
	 */
	long size;
	/**
	 * substructure speichert in eine Liste alle Unterordner und Dateien, von dem angegeben pfad.
	 */
	List<FileNode> substructure = new ArrayList<>();
}
