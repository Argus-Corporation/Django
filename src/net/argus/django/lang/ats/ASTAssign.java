package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;

public class ASTAssign extends ASTNode {
	
	private static int id = 1;
	
	public ASTAssign() {
		this(id++ + ASTId.ASSIGN_ID);
	}
	
	public ASTAssign(int nodeId) {
		super(nodeId + ASTId.ASSIGN_ID);
	}

	@Override
	public Value exec(RuntimeMemory runtime) {
		Value[] values = getValues(runtime);
		Variable a = (Variable) values[0];

		a.setValue(values[1]);

		return null;
	}
	
	@Override
	public String toString() {
		return "assign@" + getNodeId();
	}

}
