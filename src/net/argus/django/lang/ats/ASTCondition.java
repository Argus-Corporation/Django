package net.argus.django.lang.ats;

public abstract class ASTCondition extends ASTNode {

	public ASTCondition(int nodeId) {
		super(nodeId + ASTId.CONDITION_ID);
	}

}
