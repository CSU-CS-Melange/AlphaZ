package org.polymodel.polyhedralIR.analysis.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.TYPE;
import org.polymodel.polyhedralIR.analysis.validator.IValidatorMessage.VERBOSITY;

public class ValidatorOutput {

	protected Map<AffineSystem, List<IValidatorMessage>> messages;
	private boolean isValid;
	
	public ValidatorOutput() {
		messages = new HashMap<AffineSystem, List<IValidatorMessage>>();
		isValid = true;
	}
	
	public boolean isValid() {
		return isValid;
	}
	
	public void addMessages(AffineSystem system, List<IValidatorMessage> msgs) {
		for (IValidatorMessage msg : msgs) {
			if (msg.getType() == TYPE.ERROR) {
				isValid = false;
			}
		}

		if (messages.containsKey(system)) {
			messages.get(system).addAll(msgs);
		} else {
			messages.put(system, msgs);
		}
	}
	
	public  Map<AffineSystem, List<IValidatorMessage>> getMessages() {
		return messages;
	}
	
	public List<IValidatorMessage> getMessages(AffineSystem system) {
		return messages.get(system);
	}
	
	public String toString(VERBOSITY max) {
		StringBuffer output = new StringBuffer();
		for (AffineSystem system : messages.keySet()) {
			output.append("System " + system.getName());
			if (messages.get(system).size() == 0) {
				output.append(" is valid\n");
			} else {
				output.append(" : " + messages.get(system).size() + " messages\n");
			}
			for (IValidatorMessage out : messages.get(system)) {
				output.append(out.toString(max));
				output.append("\n");
			}
			
		}
		return output.toString();
	}
	
	public String toString() {
		return toString(VERBOSITY.MIN);
	}
}
