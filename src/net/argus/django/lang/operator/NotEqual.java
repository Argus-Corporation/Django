package net.argus.django.lang.operator;

import net.argus.django.lang.val.Value;

public class NotEqual extends Operator {

	public NotEqual() {
		super(0);
	}

	@Override
	public Value exec(Value a, Value b) {
		return new Value(!a.getValue().equals(b.getValue()));
	}

}
