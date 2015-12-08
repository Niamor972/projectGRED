package fr.rg.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Scanner {
	
	ArrayList<File> listFile;
	
	public Scanner () {
		listFile = new ArrayList<>();
	}
	
	public ArrayList<File> getList () {
		return listFile;
	}
	
	private boolean isType (DocumentType type, File file) throws IOException {
		boolean out = false;
	System.out.println("type = " + FileProperty.getType(file));
	System.out.println("selecType = " + type.getType());
		try {
			out = FileProperty.getProbeType(file).equals(type.getProbeType());
		} catch (NullPointerException e) {
			out = FileProperty.getType(file).equals(type.getType()) ||
					FileProperty.getExtension(file).equals(type.getExtension());
		}
		return out;
	}

	public void listFile (DocumentType selectedType, String rootPath) throws IOException {
		File root = new File(rootPath);
		if (!root.exists()) throw new IOException();
		if (root.isFile()) {
			if (isType(selectedType, root)) {
				listFile.add(root);
			}
		}
		else {
			for (File file : root.listFiles()) {
				if (file.isFile()) {
					if (isType(selectedType, file)) {
						listFile.add(file);
					}
				}
				else {
					for (File child : file.listFiles()) {
						listFile (selectedType, child.getAbsolutePath());
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Scanner [list=" + listFile + "]";
	}
}
