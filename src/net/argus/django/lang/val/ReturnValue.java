package net.argus.django.lang.val;

public class ReturnValue extends Value {
	
	public static final ReturnValue NULL = new ReturnValue(Value.NULL, false);
	
	private boolean retVal;

	public ReturnValue(Value val, boolean retVal) {
		super(val.getValue());
		this.retVal = retVal;
	}
	
	public boolean isReturnValue() {
		return retVal;
	}

}
