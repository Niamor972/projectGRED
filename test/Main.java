package fr.rg.test;

import java.io.File;

import fr.rg.logic.DocumentType;
import fr.rg.logic.FileProperty;
import fr.rg.logic.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(FileProperty.getProbeType(new File ("C:/Users/romai_000/Documents/L2S3/Anglais/zlol.odt")));
			Scanner scanner = new Scanner();
			scanner.listFile(DocumentType.OpenDocumentText, "C:/Users/romai_000/Documents/L2S3/Anglais");
			System.out.println(scanner.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
