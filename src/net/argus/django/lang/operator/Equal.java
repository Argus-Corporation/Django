package net.argus.django.lang.operator;

import net.argus.django.lang.val.Value;

public class Equal extends Operator {

	public Equal() {
		super(0);
	}

	@Override
	public Value exec(Value a, Value b) {
		return new Value(a.getValue().equals(b.getValue()));

	}

}
