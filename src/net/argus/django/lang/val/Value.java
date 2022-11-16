package net.argus.django.lang.val;

public class Value {

	protected Object value;
	
	public Value(Object value) {
		this.value = value;
	}
	
	/**
	 * return value
	 * @return
	 */
	public Object getValue() {
		return value;
	}
	
	public boolean isTrue() {
		Object value = getValue();
		if(value instanceof Integer)
			return (int) value == 1;
		else if(value instanceof Boolean)
			return (boolean) value;
		
		return false;
	}
	
	@Override
	public String toString() {
		if(value != null)
			return value.toString();
		return getValue().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Value)
			return ((Value) obj).equals(getValue());
		else
			return getValue().equals(obj);
	}
}
