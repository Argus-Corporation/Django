package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTAssign;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.Variable;

public class Let {
	
	public static ASTAssign valueOf(List<String> strs, ASTBody parentBody, AST ast) {
		strs.remove(0); // remove let
		
		String str = strs.get(0);
		
		String name = str.substring(0, str.indexOf('='));
		
		Value value = DjangoValue.valueOf(str.substring(str.indexOf('=') + 1), parentBody, ast);

		ASTAssign assign = new ASTAssign();
		
		Variable variable = new Variable(name, null);
		parentBody.addVariable(variable);
		ast.addValue(assign.getNodeId(), variable, value);
		
		strs.remove(0); // remove value
		return assign;
	}

}
