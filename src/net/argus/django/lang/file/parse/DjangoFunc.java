package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTFunction;
import net.argus.django.lang.val.Variable;
import net.argus.django.lang.val.VariableRegister;

public class DjangoFunc {
	
	public static ASTFunction valueOf(List<String> strs, AST ast) {
		strs.remove(0); // remove func

		String name = strs.get(0);
		String parameters = strs.get(1);
		parameters = parameters.substring(1, parameters.length()-1); // remove (    )
		
		strs.remove(0);  // remove name
		strs.remove(0);  // remove parameters
		
		VariableRegister register = new VariableRegister();
		for(Variable v : ast.getRuntime().getVariableRegister().getVariables())
			register.addVariable(v);
		
		for(String str : parameters.split(",")) {
			if(!str.isEmpty())
				register.addVariable(new Variable(str, null));
			
		}

		return new ASTFunction(name, DjangoBody.valueOf(strs, register, ast));
	}

}
