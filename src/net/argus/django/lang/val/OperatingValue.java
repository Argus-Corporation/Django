package net.argus.django.lang.val;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import net.argus.django.lang.exception.DjangoException;

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
			Bindings b = ENGINE.createBindings();
			if(variableRegister != null)
				for(Variable var : variableRegister.getVariables())
					b.put(var.getName(), var.getValue());
			
			
			/*
			for(String str : v.split("[()]|[*+-\\/=><]")) {
				if(str.isEmpty())
					continue;
				System.out.println(str);
			}*/
			
			return new ReturnValue(new Value(ENGINE.eval(v)), true);
		} catch (ScriptException e) {
			throw new DjangoException(value, e);
		}
	}
	
	public Object getExplicitValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[" + value + "] => " + getValue();
	}
	
}