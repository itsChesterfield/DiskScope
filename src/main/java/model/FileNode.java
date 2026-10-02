/**
 * @author Max Danigel
 */
package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileNode {
	/**
	 * pfad speichert wo die Datei / Struktur liegt.
	 */
	private String path;
	/**
	 * steht fileType auf true ist es eine Datei.
	 * Steht fileType auf false, ist es ein Verzeichnis
	 */
	private boolean fileType;
	/**
	 * size speichert die Datei / Verzeichnis Größe.
	 */
	private long size;
	/**
	 * substructure speichert in eine Liste alle Unterordner und Dateien, von dem angegeben pfad.
	 */
	private List<FileNode> substructure = new ArrayList<>();

	public FileNode(String pfad, boolean file, long size){
		this.path = pfad;
		this.fileType = file;
		this.size = size;
	}

	/**
	 * Setzt den Dateipfad und überprüft vorher ob der String null ist.
	 * @param path, ein String für den Dateipfad.
	 * @param fileType, wird angegeben ob es sich um eine Datei oder ein Verzeichnis handelt.
	 * @return path, damit man ggf. nochmals kontrollieren kann.
	 * @throws NullPointerException
	 */
	protected String setPath(String path, boolean fileType)throws NullPointerException{
		if(path == null) throw new NullPointerException("Es darf kein Path mit dem Wert null eingegeben werden");
		this.path = path;
		this.fileType = fileType;
		return path;
	}

	/**
	 * Falls eine Datei gefunden wurde, wird ihre Größe dem long Wert size hinzu addiert.
	 * @param size long Wert den man hinzu addiert.
	 * @return gibt den hinzu addierten Wert zurück, zum kontrollieren.
	 */
	protected long addSize(long size){
		this.size += size;
		return size;
	}

	/**
	 * gibt den Pfad wieder.
	 * @return
	 */
	public String getPath(){return path;}

	/**
	 * gibt die Größe wieder.
	 * @return
	 */
	public long getSize(){return size;}

	/**
	 * Gibt eine View auf die Collection substructure wieder.
	 * @return
	 */
	public List<FileNode> getList(){
		return Collections.unmodifiableList(substructure);
	}
}
