package fr.rg.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

public class ZipFileProperty extends FileProperty {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7097917410661216706L;
	private BufferedImage image;

	public ZipFileProperty(String path) throws ZipException, IOException {
		super(path); 
		setBufferedImage(new File(path));
	}

	public BufferedImage getBufferedImage () {
		return image;
	}
	
	public void setBufferedImage (File file) throws ZipException, IOException {
		image = getBufferedImage(file);
	}
	
	private static BufferedImage getBufferedImage (File file) throws ZipException, IOException {
		ZipFile zipFile = new ZipFile(file);
		ZipEntry entry = zipFile.getEntry("Thumbnails/thumbnails.png");
		BufferedImage image = ImageIO.read(zipFile.getInputStream(entry));	
		zipFile.close();
		return image;
	}
}
