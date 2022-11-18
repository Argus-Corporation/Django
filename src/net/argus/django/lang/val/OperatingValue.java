package net.argus.django.lang.val;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.argus.django.lang.exception.DjangoException;
import net.argus.util.StringManager;

public class OperatingValue extends Value {
	
	public static final ScriptEngine ENGINE = new ScriptEngineManager().getEngineByName("js");
	
	private String value;
	
	public OperatingValue(String value) {
		super(null);
		this.value = value;
	}
	
	@Override
	public Object getValue(VariableRegister variableRegister) {
		String v = value;
		try {
			if(variableRegister != null)
				for(Variable var : variableRegister.getVariables()) {
					
					if(var.getName() == null)
						continue;
					
					int index = v.indexOf(var.getName());
					if(index < 0)
						continue;
					
					v = StringManager.remplace(v, var.getName(), var.getValue().toString());
				}
			return new ReturnValue(new Value(ENGINE.eval(v)), true);
		} catch (ScriptException e) {
			throw new DjangoException(v, e);
		}
	}
	
	@Override
	public String toString() {
		return "[" + value + "] => " + getValue();
	}
	
}