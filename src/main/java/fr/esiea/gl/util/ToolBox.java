package fr.esiea.gl.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


/*
 * Operationnel : permet de recupérer sur le serv le tirage du loto + dézipper
 * J'evite de l'utiliser en entreprise car le proxy se vérrouille sur les tests.
 * Le nom des fichiers =  loto.zip & loto.csv
 * Nico
 */


/**
 * 
 * Singleton !
 * Boite a outils
 * @author lebec
 * 
 */

public class ToolBox {

	private static ToolBox instance;
	
	public static ToolBox getInstance() {

		if (instance == null)
			return new ToolBox();
		else
			return instance;
	}

	private ToolBox() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * Façade qui réalise connexion au serveur de la FDJ pour récupérer les CSV et corrige les ";"
	 * @param host
	 * @param repertoireSource
	 * @param repertoireDestination
	 * @param nomfichier
	 * @return
	 * @throws IOException
	 */
	
	public boolean miseEnPlaceFichier(String host, File repertoireSource ,File repertoireDestination,String nomfichier)
			throws IOException {
		
		
		
		try {
				
			getFichierFromServeur(host,repertoireSource);
			unzipFichier(new File(repertoireSource.getPath()+nomfichier+".zip"), repertoireDestination, true);
			return true;
		} catch (Exception e) {
			return false;
		}
		finally{
			CsvFileCorrecteur.getInstance().corrigerFichier(new File(repertoireDestination.getPath()+nomfichier+".csv"));
		}
			
			
			
	}

	public void unzipFichier(File fichierZip, final File folder,
			final boolean deleteZipAfter) throws IOException {

		ZipInputStream zis = new ZipInputStream(new FileInputStream(fichierZip));
		ZipEntry ze;
		try {
			// Parcourt tous les fichiers
			while (null != (ze = zis.getNextEntry())) {
				final File f = new File(folder.getCanonicalPath(), ze.getName());
				if (f.exists())
					f.delete();

				// Création des dossiers
				if (ze.isDirectory()) {
					f.mkdirs();
					continue;
				}
				f.getParentFile().mkdirs();
				final OutputStream fos = new BufferedOutputStream(
						new FileOutputStream(f));

				// Ecriture des fichiers
				try {
					try {
						final byte[] buf = new byte[8192];
						int bytesRead;
						while (-1 != (bytesRead = zis.read(buf)))
							fos.write(buf, 0, bytesRead);
					} finally {
						fos.close();
					}
				} catch (final IOException ioe) {
					f.delete();
					throw ioe;
				}
			}
		} finally {
			zis.close();
		}
		if (deleteZipAfter)
			fichierZip.delete();

	}

	public void getFichierFromServeur(String host, File fichierDestination) {

		InputStream input = null;
		FileOutputStream writeFile = null;

		try {

	        
			URL url = new URL(host);
			URLConnection connection = url.openConnection();
			
			int fileLength = connection.getContentLength();

			if (fileLength == -1) {
				System.out.println("Invalide URL or file:"+host);
				return;
			}
			input = connection.getInputStream();
			String fileName = url.getFile().substring(
					url.getFile().lastIndexOf('/') + 1);
			writeFile = new FileOutputStream(fichierDestination+fileName);
			byte[] buffer = new byte[1024];
			int read;

			while ((read = input.read(buffer)) > 0)
				writeFile.write(buffer, 0, read);
			writeFile.flush();
		} catch (IOException e) {
			System.out.println("Error while trying to download the file.");
			e.printStackTrace();
		} finally {
			try {
				writeFile.close();
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
