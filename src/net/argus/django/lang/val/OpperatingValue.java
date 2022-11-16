package net.argus.django.lang.val;

import net.argus.django.lang.operator.Operator;

public class OpperatingValue extends Value {
	
	private Value a, b;
	private Operator operator;

	public OpperatingValue(Value a, Value b, Operator operator) {
		super(null);
		this.a = a;
		this.b = b;
		this.operator = operator;
	}
	
	public Operator getOperator() {
		return operator;
	}
	
	public Value getA() {
		return a;
	}
	
	public Value getB() {
		return b;
	}
	
	@Override
	public Object getValue() {
		value = operator.exec(a, b).getValue();
		return value;
	}
	
	@Override
	public String toString() {
		return getValue() + "  [" + a + " " + operator.getClass().getName() + " " + b + "]";
	}
	
}