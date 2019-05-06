package fr.irisa.cairn.jnimap.cloog.jni.platform;

import java.io.File;

public class JNICloogLinux_64 extends JNICloogAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.linux_64";
	}

	public void loadPlatformLibraries() {
		// Get input stream from jar resource
		String lib = "linux_64_libjnicloog.so";
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy CLOOG
			copyLibToTemp("Cloog_linux_64" + File.separator, "libcloog-isl.so.4");
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading Cloog:",e);
		}
	}
}
