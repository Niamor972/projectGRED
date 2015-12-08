package fr.rg.logic;

public enum DocumentType {
	OpenDocumentText ("Texte OpenDocument", "application/vnd.oasis.opendocument.text", ".odt"),
	OpenDocumentSheet ("Classeur OpenDocument", "application/vnd.oasis.opendocument.sheet", ".ods"),
	OpenDocumentPresentation ("Presentation OpenDocument", "application/vnd.oasis.opendocument.presentation", ".odp");
	
	private String type;
	private String probeType;
	private String extension;
	
	private DocumentType (String type, String probeType, String extension)
	{
		this.type = type;
		this.probeType = probeType;
		this.extension = extension;
	}
	
	public String getType () {
		return type;
	}
	
	public String getProbeType () {
		return probeType;
	}
	
	public String getExtension () {
		return extension;
	}
	
	
}
