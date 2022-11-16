package net.argus.django.lang.file.parse;

import net.argus.django.lang.operator.Operator;

public class DjangoOperator {
	
	private String op;
	private Operator operator;
	
	public DjangoOperator(String op, Operator operator) {
		this.op = op;
		this.operator = operator;
	}
	
	public String getOp() {
		return op;
	}
	
	public int getPriority() {
		return operator.getPriority();
	}
	
	public Operator getOperator() {
		return operator;
	}
	

}
