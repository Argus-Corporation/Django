package net.argus.django.lang;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.file.DjangoFile;
import net.argus.django.lang.file.parse.DjangoParser;
import net.argus.util.debug.Debug;

public class MainDjango {

	public static void main(String[] args) {
		Debug.setEnable(false);
		DjangoFile f = new DjangoFile("D:\\Django\\Documents\\Java\\Django\\test.dj");
		AST ast = DjangoParser.parse(f.toList());

		//System.out.println(ast.getModule());
		ast.addNode(ast.getFunction("main"));
		ast.exec();
		
		//test("(3*5+test(test(2)-1)-3*(52))");
		/*AST a = new AST();
		
		
		ASTCompare ci = new ASTCompare(1, new Superior());
		
		ASTAssign asi = new ASTAssign(1);
		ASTBody ifBody = new ASTBody(1, asi);
		
		
		ASTAssign ase = new ASTAssign(2);
		ASTBody elseBody = new ASTBody(2, ase);
		
		ASTIf i = new ASTIf(1, ci, ifBody, elseBody);
			
		
		ASTCompare c = new ASTCompare(2, new NotEqual());
		
		
		ASTReturn r = new ASTReturn(1);
		ASTBody b = new ASTBody(3, i);
		
		ASTWhile w = new ASTWhile(1, c, b);
		
		ASTFunction func = new ASTFunction(1, new ASTBody(4, w, r));
		
		a.addNode(func);
		
		Variable va = new Variable("a", 12);
		Variable vb = new Variable("b", 32);
		
		a.addValue(c.getNodeId(), vb, 0);
		a.addValue(ci.getNodeId(), va, vb);
		a.addValue(asi.getNodeId(), va, new OpperatingValue(va, vb, new Minus()));
		a.addValue(ase.getNodeId(), vb, new OpperatingValue(vb, va, new Minus()));
		a.addValue(r.getNodeId(), va);

		a.exec();
		*/
	}
	
	/*
	public static Value test(String str) {
		return test(toList(str.toCharArray()));
	}
	
	public static void rem(List<Character> chars, int i) {
		for(int k = 0; k < i; k++)
			chars.remove(0);
	}
	
	public static Value test(List<Character> spl) {
		for(int i = 0; i < spl.size(); i++) {	
			char car = spl.get(i);
			
			if(car == ')') {
				spl.remove(i);
				return null;
			}
			
			if(car == '(' && i > 0 && Character.isAlphabetic(spl.get(i-1))) {
				String funcName = "";
				int j = i-1;
				while(Character.isAlphabetic(spl.get(j))) {
					funcName = spl.get(j) + funcName;
					j--;
				}
				
				rem(spl, i);
				int size = spl.size();
				Value val = test(spl);
				rem(spl, size - spl.size());
			}
			/*if(Character.isAlphabetic(before.charAt(before.length()-1))) {
				String[] strs = before.split("[+\\-*\\/=><]");
				String funcName = strs[strs.length-1];
				System.out.println(spl);
			}
		}
		
		return null;
	}
	*/
}