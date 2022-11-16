package net.argus.django.lang.ats;

import java.util.ArrayList;
import java.util.List;

public class ASTModule {
	
	private List<ASTFunction> functions = new ArrayList<ASTFunction>();
	
	public void addFunction(ASTFunction function) {
		this.functions.add(function);
	}
	
	public ASTFunction getFunction(String name) {
		for(ASTFunction f : functions)
			if(f.getName().equals(name))
				return f;
		return null;
	}
	
	public List<ASTFunction> getFunctions() {
		return functions;
	}
	
	@Override
	public String toString() {
		return "module@" + functions;
	}

}
