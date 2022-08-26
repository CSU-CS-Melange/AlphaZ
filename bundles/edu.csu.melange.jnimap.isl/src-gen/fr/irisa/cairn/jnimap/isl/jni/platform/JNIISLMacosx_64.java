package fr.irisa.cairn.jnimap.isl.jni.platform;

import java.io.File;

public class JNIISLMacosx_64 extends JNIISLAbstractPlatform {

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
			lib = "macosx_arm64_libjniisl.so";
			libDirectory = "ISL_macosx_arm64";
		} else {
			// Intel macs
			lib = "macosx_64_libjniisl.so";
			libDirectory = "ISL_macosx_64";
		}
		
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy ISL
			copyLibToTemp(libDirectory + File.separator, "libisl.15.dylib");
			//Copy GMP
			copyLibToTemp(libDirectory + File.separator, "libgmp.10.dylib");
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading ISL:",e);
		}
	}
}
