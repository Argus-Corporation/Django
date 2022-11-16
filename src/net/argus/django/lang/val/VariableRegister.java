package net.argus.django.lang.val;

import java.util.ArrayList;
import java.util.List;

public class VariableRegister {
	
	private List<Variable> variables = new ArrayList<Variable>();
	
	public void addVariable(Variable variable) {
		variables.add(variable);
	}
	
	public List<Variable> getVariables() {
		return variables;
	}
	
	public Variable getVariable(String name) {
		for(Variable v : variables)
			if(v.getName().equals(name))
				return v;
		return null;
	}
	
	public int index(String name) {
		return variables.indexOf(getVariable(name));
	}

	@Override
	public String toString() {
		return variables.toString();
	}
	
}
