package net.argus.django.lang.val;

public class Variable extends Value {
	
	private String name;

	public Variable(String name, Object value) {
		super(value);
		this.name = name;
	}

	/**
	 * return name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set value
	 * @param value
	 */
	public void setValue(Object value) {
		if(value instanceof Value) {
			this.value = ((Value) value).getValue();
		}else
			this.value = value;
		
	}
	
	@Override
	public Object getValue() {
		return super.getValue();
	}
	
	@Override
	public String toString() {
		return name  + "=" + value;
	}
}
