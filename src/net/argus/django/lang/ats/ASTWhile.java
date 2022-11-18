package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.ReturnValue;
import net.argus.django.lang.val.Value;

public class ASTWhile extends ASTNode {
	
	private static int id = 1;


	private Value condition;
	private ASTBody body;
	
	public ASTWhile(Value condition, ASTBody body) {
		this(id++ + ASTId.WHILE_ID, condition, body);
	}
	
	public ASTWhile(int nodeId, Value condition, ASTBody body) {
		super(nodeId + ASTId.WHILE_ID);
		this.condition = condition;
		this.body = body;
	}

	@Override
	public ReturnValue exec(RuntimeMemory runtime) {
		while(condition.isTrue(runtime.getVariableRegister())) {
			ReturnValue ret = body.exec(runtime);
			if(ret != null)
				return ret;
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		return "while@" + getNodeId();
	}
	
}
