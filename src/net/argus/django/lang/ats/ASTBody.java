package net.argus.django.lang.ats;

import java.util.List;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.ReturnValue;
import net.argus.django.lang.val.Variable;
import net.argus.django.lang.val.VariableRegister;
import net.argus.util.ArrayManager;

public class ASTBody extends ASTNode {
	
	private static int id = 1;
	
	private List<ASTNode> nodes;
	
	private VariableRegister register = new VariableRegister();
	
	public ASTBody(ASTNode ... nodes) {
		this(id++ + ASTId.BODY_ID, nodes);
	}
	
	public ASTBody(int nodeId, ASTNode ... nodes) {
		super(nodeId + ASTId.BODY_ID);
		this.nodes = ArrayManager.toList(nodes);
	}
	
	public void addVariable(Variable variable) {
		register.addVariable(variable);
	}
	
	public void addVariables(VariableRegister register) {
		for(Variable v : register.getVariables())
			this.register.addVariable(v);
	}
	
	public Variable getVariable(String name) {
		return register.getVariable(name);
	}
	
	public Variable getVariable(int index) {
		return register.getVariables().get(index);
	}
	
	public void setNodes(List<ASTNode> nodes) {
		this.nodes = nodes;
	}
	
	public List<ASTNode> getNodes() {
		return nodes;
	}
	
	public VariableRegister getRegister() {
		return register;
	}

	@Override
	public ReturnValue exec(RuntimeMemory runtime) {
		for(Variable v : register.getVariables()) {
			runtime.addLocalVariable(getNodeId(), v);
		}

		for(ASTNode node : nodes) {
			ReturnValue v = node.exec(runtime);
			if(v.isReturnValue()) {
				runtime.clearLocalVariable(getNodeId());
				return v;
			}
		}
		
		runtime.clearLocalVariable(getNodeId());
		return null;
	}
	
	@Override
	public String toString() {
		return "body@" + getNodeId();
	}

}
