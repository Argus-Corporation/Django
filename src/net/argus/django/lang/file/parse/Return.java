package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.ats.ASTReturn;
import net.argus.django.lang.val.Value;

public class Return {
	
	public static ASTReturn valueOf(List<String> strs, ASTBody parentBody, AST ast) {
		strs.remove(0); // remove return
		
		while(strs.get(1).startsWith("(")) {
			strs.set(0, strs.get(0) + strs.get(1));
			strs.remove(1);
		}
		
		Value val = DjangoValue.valueOf(strs.get(0), parentBody, ast);

		ASTReturn ret = new ASTReturn();

		ast.addValue(ret.getNodeId(), val);
		
		strs.remove(0); // remove value

		return ret;
	}
	
}
