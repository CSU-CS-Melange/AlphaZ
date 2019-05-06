package fr.irisa.cairn.jnimap.isl.jni.platform;

import java.io.File;

public class JNIISLCygwin_32 extends JNIISLAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.cygwin_32";
	}

	public void loadPlatformLibraries() {
		// Get input stream from jar resource
		String lib = "cygwin_32_libjniisl.so";
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading ISL:",e);
		}
	}
}
