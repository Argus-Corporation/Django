package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.ReturnValue;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;

public class ASTFunction extends ASTNode {
	
	private static int id = 1;
	
	private String name;
	private ASTBody body;
	
	public ASTFunction(String name, ASTBody body) {
		this(id++ + ASTId.FUNCTION_ID, name, body);
	}

	public ASTFunction(int nodeId, String name, ASTBody body) {
		super(nodeId + ASTId.FUNCTION_ID);
		this.name = name;
		this.body = body;
	}

	@Override
	public ReturnValue exec(RuntimeMemory runtime) {
		Value[] values = runtime.getValues(getNodeId());
		
		if(values != null)
			for(int i = 0; i < values.length; i++) {
				Variable var = body.getVariable(i);
				if(var != null)
					var.setValue(values[i]);
			}
		
		return new ReturnValue(body.exec(runtime), false);
	}
	
	public ASTBody getBody() {
		return body;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "[function:" + name + "]@" + getNodeId();
	}

}
