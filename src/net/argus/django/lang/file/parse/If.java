package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.ats.ASTIf;
import net.argus.django.lang.val.Value;

public class If {

	public static ASTIf valueOf(List<String> strs, ASTBody parentBody, AST ast) {
		strs.remove(0); // remove if
		Value condition = DjangoValue.valueOf(strs.get(0), parentBody, ast);
		
		strs.remove(0); // remove (condition)
		ASTBody ifBody = DjangoBody.valueOf(strs, parentBody.getRegister(), ast);
		ASTBody elseBody = null;
		
		if(strs.get(0).equals("else")) {
			strs.remove(0); // remove else
			elseBody = DjangoBody.valueOf(strs, parentBody.getRegister(), ast);
		}
		
		return new ASTIf(condition, ifBody, elseBody);
	}
	
}
