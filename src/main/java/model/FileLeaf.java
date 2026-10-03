package model;

public class FileLeaf extends FileNode{
	/**
	 * privates Attribut das die Größe einer Datei speichert.
	 */
	private long size;

	/**
	 * Konstruktor der einen Dateipfad an die Oberklasse überreicht und die Datei Größe Initialisiert.
	 * @param path
	 * @param size
	 */
	public FileLeaf(String path, long size){
		super(path);
		this.size = size;
	}

	/**
	 * Methode welche die Größe der Datei wiedergibt.
	 * @return
	 */
	@Override
	public long getSize() {
		return size;
	}
}
