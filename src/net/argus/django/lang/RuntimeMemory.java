package net.argus.django.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.argus.django.lang.ats.ASTId;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;
import net.argus.django.lang.val.VariableRegister;

public class RuntimeMemory {
	
	private Map<ASTId, Value[]> map = new HashMap<ASTId, Value[]>();
	private VariableRegister variableRegister = new VariableRegister();
	private Map<ASTId, List<Variable>> local = new HashMap<ASTId, List<Variable>>();
	
	public void addValue(ASTId id, Value[] values) {
		map.put(id, values);
	}
	
	public Value[] getValues(ASTId id) {
		return map.get(id);
	}
	
	public void addVariable(Variable variable) {
		variableRegister.addVariable(variable);
	}
	
	public void addLocalVariable(ASTId nodeId, Variable variable) {
		variableRegister.addVariable(variable);
		if(local.get(nodeId) != null)
			local.get(nodeId).add(variable);
		else {
			List<Variable> v = new ArrayList<Variable>();
			v.add(variable);
			local.put(nodeId, v);
		}
	}
	
	public Variable getVariable(String name) {
		return variableRegister.getVariable(name);
	}
	
	public VariableRegister getVariableRegister() {
		return variableRegister;
	}
	
	public void clearLocalVariable(ASTId nodeId) {
		if(!local.containsKey(nodeId))
			return;
		
		for(Variable v : local.get(nodeId))
			variableRegister.remove(v);
	}
	
}
