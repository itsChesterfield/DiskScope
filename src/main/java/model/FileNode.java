package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author Max Danigel
 */
public abstract class FileNode {
	/**
	 * Speichert einen String für den path, der von den Unterklassen übergeben wird.
	 */
		String path;
	public FileNode(String path) {
		this.path = path;
	}

	protected FileNode() {
	}

	/**
	 * Abstrakte Methode, die einen Pfad wieder gibt.
	 * @return
	 */
	public String getPath(){return path;}

	/**
	 * Abstrakte Methode, sie gibt die Größe wieder.
	 * @return
	 */
	abstract public long getSize();
}
