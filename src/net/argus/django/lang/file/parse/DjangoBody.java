package net.argus.django.lang.file.parse;

import java.util.ArrayList;
import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.ats.ASTFunction;
import net.argus.django.lang.ats.ASTNode;
import net.argus.django.lang.val.Value;
import net.argus.django.lang.val.VariableRegister;

public class DjangoBody {
	
	public static ASTBody valueOf(List<String> strs, VariableRegister variableRegister, AST ast) {
		strs.remove(0); // remove {
		
		ASTBody body = new ASTBody();
		body.addVariables(variableRegister);
		
		List<ASTNode> nodes = new ArrayList<ASTNode>();
		
		for(int i = 0; i < strs.size();) {
			String str = strs.get(0);
			
			if(str.equals("}"))
				break;
			
			if(str.equals("")) {
				strs.remove(0);
				continue;
			}
			
			if(str.equals("let")) {
				nodes.add(Let.valueOf(strs, body, ast));
				continue;
			}else if(str.equals("while")) {
				nodes.add(While.valueOf(strs, body, ast));
				continue;
			}else if(str.equals("if")) {
				nodes.add(If.valueOf(strs, body, ast));
				continue;
			}else if(str.equals("return")) {
				nodes.add(Return.valueOf(strs, body, ast));
				break;
			}
			
			if(str.contains("=")) {
				nodes.add(Assign.valueOf(strs, body, ast));
				continue;
			}
			
			ASTNode n = null;
			if((n = func(strs, body, str, ast, true)) != null)
				nodes.add(n);
			
		}
		
		strs.remove(0); // remove }
		body.setNodes(nodes);
		return body;
	}
	
	public static ASTNode func(List<String> strs, ASTBody parentBody, String name, AST ast, boolean addNode) {
		ASTNode node = null;
		if(ast.getFunction(name) != null) {
			strs.remove(0); // remove name
			ASTFunction f = ast.getFunction(name);
			ASTFunction newInstance = new ASTFunction(f.getName(), f.getBody());

			String param = strs.get(0);
			String[] paramsStr = param.substring(1, param.length()-1).split(",");

			List<Value> params = new ArrayList<Value>();
			for(String p : paramsStr) {
				if(p.isEmpty())
					continue;
				params.add(DjangoValue.valueOf(p, parentBody, ast));
			}
			
			if(addNode)
				ast.addValue(newInstance.getNodeId(), params);
			node = newInstance;
			
			strs.remove(0); // remove param
		}
		return node;
	}

}
