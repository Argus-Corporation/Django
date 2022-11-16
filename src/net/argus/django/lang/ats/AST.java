package net.argus.django.lang.ats;

import java.util.ArrayList;
import java.util.List;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;
import net.argus.util.ArrayManager;

public class AST {
	
	private List<ASTNode> nodes = new ArrayList<ASTNode>();
	
	private ASTModule module;
	
	private RuntimeMemory runtime = new RuntimeMemory();
	
	public AST(ASTModule module) {
		this.module = module;
	}
	
	public void addNode(ASTNode node) {
		nodes.add(node);
	}
	
	public void exec() {
		for(ASTNode n : nodes)
			n.exec(runtime);
	}
	
	public void addValue(ASTId id, Value ... values) {
		runtime.addValue(id, values);
	}
	
	public void addValue(ASTId id, List<Value> values) {
		addValue(id, ArrayManager.convert(values, new Value[values.size()]));
	}
	
	public void addValue(ASTId id, Object ... values) {
		List<Value> vals = new ArrayList<Value>();
		for(Object obj : values) {
			if(obj instanceof Value)
				vals.add((Value) obj);
			else
				vals.add(new Value(obj));
		}
		
		addValue(id, vals);
	}
	
	public void addVariable(Variable variable) {
		runtime.addVariable(variable);
	}
	
	public Variable getVariable(String name) {
		return runtime.getVariable(name);
	}
	
	public RuntimeMemory getRuntime() {
		return runtime;
	}
	
	public ASTModule getModule() {
		return module;
	}
	
	public ASTFunction getFunction(String name) {
		return module.getFunction(name);
	}

}
