package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.ats.ASTReturn;
import net.argus.django.lang.val.Value;

public class Return {
	
	public static ASTReturn valueOf(List<String> strs, ASTBody parentBody, AST ast) {
		strs.remove(0); // remove return
		
		Value val = DjangoValue.valueOf(strs.get(0), parentBody, ast);
		System.out.println(val);
		ASTReturn ret = new ASTReturn();

		ast.addValue(ret.getNodeId(), val);
		
		strs.remove(0); // remove value

		return ret;
	}
	
}
