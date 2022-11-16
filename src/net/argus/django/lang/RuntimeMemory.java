package net.argus.django.lang;

import java.util.HashMap;
import java.util.Map;

import net.argus.django.lang.ats.ASTId;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;
import net.argus.django.lang.val.VariableRegister;

public class RuntimeMemory {
	
	private Map<ASTId, Value[]> map = new HashMap<ASTId, Value[]>();
	private VariableRegister variableRegister = new VariableRegister();
	
	public void addValue(ASTId id, Value[] values) {
		map.put(id, values);
	}
	
	public Value[] getValues(ASTId id) {
		return map.get(id);
	}
	
	public void addVariable(Variable variable) {
		variableRegister.addVariable(variable);
	}
	
	public Variable getVariable(String name) {
		return variableRegister.getVariable(name);
	}
	
	public VariableRegister getVariableRegister() {
		return variableRegister;
	}
	
}
