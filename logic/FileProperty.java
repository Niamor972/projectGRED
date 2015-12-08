package fr.rg.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;

//import javax.swing.JFileChooser;

public class FileProperty implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3658805112076684600L;
	private String path;
	private String name;
	private long date;
	private String formatedDate;
	private long size;
	private String formatedSize;
	private String type;
	private String probeType;
	private String extension;
	
	public FileProperty (String path) throws IOException{
		File file = new File(path);
		if (!file.exists())
			throw new FileNotFoundException(); 
		setPath(file);
		setName (file);
		setDate(file);
		setSize(file);
		setType(file);
		setProbeType(file);
		setExtension(file);
	}
	
	private void setPath (File file) {
		path = file.getAbsolutePath();
	}
		
	public String getPath () {
		return path;
	}
	
	private void setName (File file) {
		name = file.getName();
	}
	
	public String getName () {
		return name;
	}
	
	private void setDate (File file) {
		date = file.lastModified();
		setFormatedDate();
	}
	
	public long getDate () {
		return date;
	}
	
	private void setFormatedDate () {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy H:mm:ss");
		formatedDate = sdf.format(date);
	}
	
	public String getFormatedDate () {
		return formatedDate;
	}
	
	private void setSize (File file) {
		size = file.length();
		setFormatedSize();
	}
	
	public long getSize () {
		return size;
	}
	
	private void setFormatedSize () {
		if (size > 1024*1024)
			formatedSize = (size /(1024*1024)) + " Mo";
		else if (size > 1024)
			formatedSize = (size / 1024) + " ko ";
		else 
			formatedSize = size + " o ";
	}
	
	public String getFormatedSize () {
		return formatedSize;
	}
	
	private void setType (File file) {
		type = getType (file);
	}
	
	public String getType () {
		return type;
	}
	
	public static String getType (File file) {
		JFileChooser chooser = new JFileChooser();
		return chooser.getTypeDescription(file);
	}
	
	private void setProbeType (File file) throws IOException {
		probeType = getProbeType(file);
	}	
	
	public String getProbeType () {
		return probeType;
	}
	
	public static String getProbeType (File file) throws IOException {
		return Files.probeContentType(file.toPath());
	}

	private void setExtension (File file) {
		extension = getExtension(file);
	}

	public String getExtension () {
		return extension;
	}
	
	public static String getExtension (File file) {
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		if (pos > -1)
			return name.substring(pos);
		else 
			return name;
	}

	@Override
	public String toString() {
		return "FileProperty [path=" + path + ", name=" + name + ", date=" + date + ", formatedDate=" + formatedDate
				+ ", size=" + size + ", formatedSize=" + formatedSize + ", type=" + probeType + ", extension=" + extension
				+ "]";
	}
}
