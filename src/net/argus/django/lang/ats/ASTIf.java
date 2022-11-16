package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.Value;

public class ASTIf extends ASTNode {
	
	private static int id = 1;
	
	private Value condition;
	private ASTBody ifBody, elseBody;
	
	public ASTIf(Value condition, ASTBody ifBody, ASTBody elseBody) {
		this(id++ + ASTId.IF_ID, condition, ifBody, elseBody);
	}

	public ASTIf(int nodeId, Value condition, ASTBody ifBody, ASTBody elseBody) {
		super(nodeId + ASTId.IF_ID);
		this.condition = condition;
		this.ifBody = ifBody;
		this.elseBody = elseBody;

	}

	@Override
	public Value exec(RuntimeMemory runtime) {
		if(condition.isTrue())
			ifBody.exec(runtime);
		else if(elseBody != null)
			elseBody.exec(runtime);
		
		return null;
	}
	
	@Override
	public String toString() {
		return "if@" + getNodeId();
	}

}
