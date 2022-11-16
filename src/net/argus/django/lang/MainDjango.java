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
		System.out.println(ast.getModule());
		ast.addNode(ast.getFunction("main"));
		ast.exec();
		
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
	
}


//a = 1 + ((b - 6) * 2)

//a * b
//a + b