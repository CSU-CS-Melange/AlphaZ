package fr.irisa.cairn.jnimap.cloog.jni.platform;

import java.io.File;

public class JNICloogCygwin_32 extends JNICloogAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.cygwin_32";
	}

	public void loadPlatformLibraries() {
		// Get input stream from jar resource
		String lib = "cygwin_32_libjnicloog.so";
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading Cloog:",e);
		}
	}
}
