package org.polymodel.polyhedralIR.analysis.verifier;

import java.util.List;

import org.polymodel.polyhedralIR.analysis.verifier.IVerifierMessage.VERBOSITY;

public class VerifierOutput {

	protected List<IVerifierMessage> messages;
	public final boolean isValid;
	
	public VerifierOutput(List<IVerifierMessage> msgs) {
		messages = msgs;
		isValid = messages.size() == 0;
	}
	
	public List<IVerifierMessage> getMessages() {
		return this.messages;
	}
	
	public String toString(VERBOSITY verbosity) {
		StringBuffer output = new StringBuffer();
		
		if(messages.size() > 0) {
			for (IVerifierMessage out : messages) {
				output.append(out.toString(verbosity));
				output.append("\n");
			}
			output.append("Its an invalid target mapping.\n");
		}else {
			output.append("Its a valid target mapping.\n");
		}
		
		return output.toString();
	}
}
