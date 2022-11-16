package net.argus.django.lang.file.parse;

import java.util.List;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTModule;
import net.argus.util.ArrayManager;

public class DjangoParser {
	
	public static AST parse(List<String> lines) {
		return valueOf(toList(Regulator.regul(getLine(lines))));
	}
	
	public static AST valueOf(List<String> strs) {
		System.out.println(strs);
		ASTModule module = new ASTModule();
		AST ast = new AST(module);
		
		for(int i = 0; i < strs.size();) {
			String str = strs.get(i);
			if(str.equals("func")) {
				module.addFunction(DjangoFunc.valueOf(strs, ast));
				continue;
			}
			
			strs.remove(0);
		}
		
		return ast;
	}
	
	public static String getLine(List<String> lines) {
		String line = "";
		for(String l : lines)
			line += l;
		return line;
	}
	
	
	public static char[] toArray(List<Character> l) {
		char[] chars = new char[l.size()];
		for(int i = 0; i < chars.length; i++)
			chars[i] = l.get(i);
		
		return chars;
	}
	
	public static List<String> toList(String l) {
		return ArrayManager.toList(l.split(" "));
	}

}
