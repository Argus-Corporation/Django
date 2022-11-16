package net.argus.django.lang.operator;

import net.argus.django.lang.exception.DjangoException;
import net.argus.django.lang.val.Value;

public class Multiply extends Operator {
	
	public Multiply() {
		super(2);
	}

	@Override
	public Value exec(Value a, Value b) {
		if(!(a.getValue() instanceof Integer))
			throw new DjangoException(a.getValue()  + " is not an integer");
		if(!(b.getValue() instanceof Integer))
			throw new DjangoException(b.getValue()  + " is not an integer");
		
		return new Value((int) a.getValue() * (int) b.getValue());
	}

}
