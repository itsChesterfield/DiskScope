package scan;

import model.FileNode;

import java.util.List;

public interface ScannerInterface {
	/**
	 * Ein Interface eine Baum Struktur bildet, anhand von einem Zielpfad.
	 * Sie ruft Rekursiv die Liste eines jeden Verzeichnisse auf.
	 * Am Ende wird eine Liste ausgegeben von Typ FileNode.
	 */
	public List<FileNode> treeStructure(String path);
}
