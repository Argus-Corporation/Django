package net.argus.django.lang.operator;

import net.argus.django.lang.val.Value;

public abstract class Operator {
	
	private int priority;
	
	public Operator(int priority) {
		this.priority = priority;
	}
	
	/**
	 * return result of operator of a with b
	 * @param a
	 * @param b
	 * @return
	 */
	public abstract Value exec(Value a, Value b);
	
	public int getPriority() {
		return priority;
	}

}
