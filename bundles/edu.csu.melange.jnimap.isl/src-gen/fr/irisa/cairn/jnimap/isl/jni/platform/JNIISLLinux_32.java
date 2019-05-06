package fr.irisa.cairn.jnimap.isl.jni.platform;

import java.io.File;

public class JNIISLLinux_32 extends JNIISLAbstractPlatform {

	@Override
	protected String getDllPath() {
		return new File(".")+File.separator+"./.jnimap.temp.linux_32";
	}

	public void loadPlatformLibraries() {
		// Get input stream from jar resource
		String lib = "linux_32_libjniisl.so";
		try {
			//Copy other dynamic libraries from jar to temporary location
			//Copy ISL
			copyLibToTemp("ISL_linux_32" + File.separator, "libisl.so.13");
			//Copy GMP
			copyLibToTemp("ISL_linux_32" + File.separator, "libgmp.so.10");
			//Copy the binding object file from jar to temporary location
			File JNIDLL = copyLibToTemp("", lib);
			// Finally, load the dll
			System.load(JNIDLL.getAbsolutePath());
		} catch (Exception e) {
			throw new RuntimeException("Problem during native library loading ISL:",e);
		}
	}
}
