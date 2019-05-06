package fr.irisa.cairn.jnimap.cloog.jni.platform;

import java.io.File;

public class JNICloogLinux_32 extends JNICloogAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.linux_32";
	}

	public void loadPlatformLibraries() {
		// Get input stream from jar resource
		String lib = "linux_32_libjnicloog.so";
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy CLOOG
			copyLibToTemp("Cloog_linux_32" + File.separator, "libcloog-isl.so.4");
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading Cloog:",e);
		}
	}
}
