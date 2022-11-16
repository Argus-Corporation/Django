package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.ats.ASTWhile;
import net.argus.django.lang.val.Value;

public class While {
	
	public static ASTWhile valueOf(List<String> strs, ASTBody parentBody, AST ast) {
		strs.remove(0); // remove while
		Value condition = DjangoValue.valueOf(strs.get(0), parentBody, ast);
		
		strs.remove(0); // remove (condition)
		ASTBody body = DjangoBody.valueOf(strs, parentBody.getRegister(), ast);

		return new ASTWhile(condition, body);
	}

}
