package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.ReturnValue;
import net.argus.django.lang.val.Value;

public class ASTReturn extends ASTNode {
	
	private static int id = 1;
	
	public ASTReturn() {
		this(id++ + ASTId.RETURN_ID);
	}

	public ASTReturn(int nodeId) {
		super(nodeId + ASTId.RETURN_ID);
	}

	@Override
	public ReturnValue exec(RuntimeMemory runtime) {
		Value val = runtime.getValues(getNodeId())[0];
		if(val == null)
			return ReturnValue.NULL;
		
		return new ReturnValue((Value) val.getValue(runtime.getVariableRegister()), true);
	}
	
	@Override
	public String toString() {
		return "return@" + getNodeId();
	}

}
