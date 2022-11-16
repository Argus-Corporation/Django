package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
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
	public Value exec(RuntimeMemory runtime) {
		System.out.println(runtime.getValues(getNodeId())[0]);
		return runtime.getValues(getNodeId())[0];
	}
	
	@Override
	public String toString() {
		return "return@" + getNodeId();
	}

}
