package fr.irisa.cairn.jnimap.isl.jni;

/**
 * A RuntimeException that records outputs to stderr from ISL. 
 * 
 * @author tyuki
 *
 */
public class ISLErrorException extends RuntimeException {
	private static final long serialVersionUID = -5329742820789426663L;
	
	public final String islErrorMessage;
	
	public ISLErrorException(String islErr) {
		islErrorMessage = islErr;
	}

	public ISLErrorException(String islErr, String msg) {
		super(msg);
		islErrorMessage = islErr;
	}
}
