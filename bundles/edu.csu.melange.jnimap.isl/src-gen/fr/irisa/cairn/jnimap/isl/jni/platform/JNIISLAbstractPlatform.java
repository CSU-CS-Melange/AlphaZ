package fr.irisa.cairn.jnimap.isl.jni.platform;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public abstract class JNIISLAbstractPlatform {

	abstract public void loadPlatformLibraries();

	abstract protected String getDllPath();

	protected File copyLibToTemp(String location, String libName) {
		String path = File.separator+location+libName;
		try {
			File dir = new File(getDllPath()).getAbsoluteFile();
			dir.mkdirs();
			dir.deleteOnExit();
			URL resource = JNIISLAbstractPlatform.class.getResource(path);
			InputStream inputStream = resource.openStream();
			
			// Copy resource to filesystem in a temp folder with a unique name
			String dllPath = dir.getAbsolutePath()+File.separator+libName;
			File temporaryDll = new File(dllPath);
			FileOutputStream outputStream = new FileOutputStream(temporaryDll);
			byte[] array = new byte[8192];
			int read = 0;
			while ( (read = inputStream.read(array)) > 0)
				outputStream.write(array, 0, read);
			outputStream.close();  
	
			// Delete on exit the dll
			temporaryDll.deleteOnExit();
			
			return temporaryDll;
		} catch (Exception e) {
			throw new RuntimeException("Could not copy library : " + path,e);
		}
	}
}
