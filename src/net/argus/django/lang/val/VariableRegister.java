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
	
	public void remove(String name) {
		remove(variables.get(index(name)));
	}
	
	public void remove(Variable variable) {
		variables.remove(variable);
	}
	
	
	public int index(String name) {
		return variables.indexOf(getVariable(name));
	}

	@Override
	public String toString() {
		return variables.toString();
	}
	
}
