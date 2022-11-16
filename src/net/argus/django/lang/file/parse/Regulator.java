package net.argus.django.lang.file.parse;

import java.util.ArrayList;
import java.util.List;

public class Regulator {
	
	private static final char[] SPACE_BEFOR = new char[] {'(', '{'};
	private static final char[] SPACE_AFTER = new char[] {'{', '}'};
	private static final char[] NO_SPACE_BEFOR = new char[] {')', ',', '=', '<', '>', '!', '+', '-', '*', '/'};
	private static final char[] NO_SPACE_AFTER = new char[] {'(', ',', '=', '<', '>', '!', '+', '-', '*', '/'};
	
	public static String regul(String line) {
		List<Character> chars = new ArrayList<Character>();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == '\t')
				continue;
			
			chars.add(c);

		}
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == ';') {
				chars.add(' ');
				continue;
			}
			
			chars.add(c);
		}
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(c == ' ' && chars.get(chars.size()-1) == ' ')
				continue;
			
			
			chars.add(c);
		}
		
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			if(contains(c, SPACE_BEFOR) && chars.get(chars.size()-1) != ' ')
				chars.add(' ');
			
			chars.add(c);
		}
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			while(contains(c, NO_SPACE_BEFOR) && chars.get(chars.size()-1) == ' ')
				chars.remove(chars.size()-1);
			
			chars.add(c);
		}
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			while(contains(c, NO_SPACE_AFTER) && line.charAt(i+1) == ' ')
				i += 1;
				
			
			chars.add(c);
		}
		
		line = new String(DjangoParser.toArray(chars));
		chars.clear();
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			
			chars.add(c);
			
			if(contains(c, SPACE_AFTER))
				chars.add(' ');
			
		}
		
		
		return new String(DjangoParser.toArray(chars));
	}
	
	public static boolean contains(char c, char[] array) {
		for(char car : array)
			if(car == c)
				return true;
		return false;		
	}

}
