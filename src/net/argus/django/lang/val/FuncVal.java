package net.argus.django.lang.val;

public class FuncVal {
	
	private String funcName;
	private OperatingValue value;
	
	public FuncVal(String funcName, OperatingValue value) {
		this.funcName = funcName;
		this.value = value;
	}
	
	public String getFunctionName() {
		return funcName;
	}
	
	public OperatingValue getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return funcName + "(" + value + ")";
	}

}
