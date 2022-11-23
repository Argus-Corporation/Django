package net.argus.django.lang.val;

public class ReturnValue extends Value {
	
	public static final ReturnValue NULL = new ReturnValue(Value.NULL, false);
	
	private boolean retVal;

	public ReturnValue(Value val, boolean retVal) {
		super(val!=null?val.getValue():null);
		this.retVal = retVal;
	}
	
	public boolean isReturnValue() {
		return retVal;
	}

}
