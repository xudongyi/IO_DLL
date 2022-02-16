import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.Buffer;
import java.security.CodeSource;
import javax.swing.JOptionPane;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

public class RecoIO_Demo {

	/**
	 * @param args
	 */
	private static final int CF_DIB = 8;
	public static int Session;
	public static int DIBHandle;
	private static  int Pages = 0;
	public static RecoIOAPI dlltest=RecoIOAPI.INSTANCE;
	static ClpBrd dllClpbrd=ClpBrd.INSTANCE;
	static Pointer DIBHandles = new Pointer(512);


	/* funzione per estrarre la DLL da richiamare fuori dal .jar.
	  jna non permette di richiamare le librerie direttamente dal jar*/
	private static boolean extract_File(String fileToExtract){
		try {
			  InputStream in = RecoIO_Demo.class.getResourceAsStream(fileToExtract);
			  File fileOut = new File("."+fileToExtract);
			  if (fileOut.exists()){
				  System.out.println(fileToExtract+" --> exported");
			  }else
			  {
			  DataOutputStream writer = new DataOutputStream(new FileOutputStream(fileOut));
			  long oneChar = 0;
			  while((oneChar = in.read()) != -1){
			    writer.write((int)oneChar);
			  }
			  writer.close();}
			  in.close();
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
		return true;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodeSource codeSource = RecoIO_Demo.class.getProtectionDomain().getCodeSource();
		try{
			String libpath = System.getProperty("jna.library.path");
		    File jarFile = new File(codeSource.getLocation().toURI().getPath());
		    String jarDir = jarFile.getParentFile().getPath();
			jarDir=jarDir+";"+libpath;
		    System.setProperty("jna.library.path", jarDir);

			libpath = System.getProperty("jna.library.path");
			System.out.println("jna library path --> "+libpath);
			System.out.println("jar         path --> "+jarDir);
		}catch (Exception e) {}

		boolean creato =extract_File("/recoio.dll");



		//RecoIOAPI dlltest=RecoIOAPI.INSTANCE;
		//ClpBrd dllClpbrd=ClpBrd.INSTANCE;

		// Init the IO session
		Session= dlltest.IO_Init("company", "company");
		dlltest.IO_SelectScanner(Session,0);
		int i = dlltest.IO_ScanImage(Session,0);
		while (true){
			dlltest.IO_SaveJPGImage(Session, i, "D://scanner/text.png",100);
			 i = dlltest.IO_GetNextAsyncScannedImage(Session);
			if(i==-1){
				break;
			}
		}

		dlltest.IO_Done(Session);
	}

}
