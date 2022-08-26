package fr.irisa.cairn.jnimap.cloog.jni.platform;

import java.io.File;

public class JNICloogMacosx_64 extends JNICloogAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.macosx_64";
	}

	public void loadPlatformLibraries() {
		
		// Get input stream from jar resource
		String lib;
		String libDirectory;
		if (System.getProperty("os.arch").equals("aarch64")) {
			// M1 macs
			lib = "macosx_arm64_libjnicloog.so";
			libDirectory = "Cloog_macosx_arm64";
		} else {
			// Intel macs
			lib = "macosx_64_libjnicloog.so";
			libDirectory = "Cloog_macosx_64";
		}
		
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy CLOOG
			copyLibToTemp(libDirectory + File.separator, "libcloog-isl.4.dylib");
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading Cloog:",e);
		}
	}
}
