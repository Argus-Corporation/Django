package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.operator.Operator;
import net.argus.django.lang.val.Value;

public class ASTCompare extends ASTCondition {
	
	private Operator operator;
	
	public ASTCompare(int nodeId, Operator operator) {
		super(nodeId);
		this.operator = operator;
	}
	
	@Override
	public Value exec(RuntimeMemory runtime) {
		Value[] values = getValues(runtime);
		
		return operator.exec(values[0], values[1]);
	}
	
	
	/**
	 * return operator
	 * @return
	 */
	public Operator getOperator() {
		return operator;
	}

	@Override
	public String toString() {
		return "compare@" + getNodeId();
	}
	
}
