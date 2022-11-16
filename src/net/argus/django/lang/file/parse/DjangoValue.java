package net.argus.django.lang.file.parse;

import net.argus.django.lang.ats.AST;
import net.argus.django.lang.ats.ASTBody;
import net.argus.django.lang.operator.Divide;
import net.argus.django.lang.operator.Equal;
import net.argus.django.lang.operator.Inferior;
import net.argus.django.lang.operator.InferiorOrEqual;
import net.argus.django.lang.operator.Minus;
import net.argus.django.lang.operator.Multiply;
import net.argus.django.lang.operator.NotEqual;
import net.argus.django.lang.operator.Operator;
import net.argus.django.lang.operator.Plus;
import net.argus.django.lang.operator.Superior;
import net.argus.django.lang.operator.SuperiorOrEqual;
import net.argus.django.lang.val.OpperatingValue;
import net.argus.django.lang.val.Value;
import net.argus.util.StringManager;

public class DjangoValue {
	
	public static final DjangoOperator[] OPERATOR = new DjangoOperator[] {
			new DjangoOperator("*", new Multiply()),
			new DjangoOperator("/", new Divide()),
			new DjangoOperator("+", new Plus()),
			new DjangoOperator("-", new Minus()),
			new DjangoOperator("==", new Equal()),
			new DjangoOperator("!=", new NotEqual()),
			new DjangoOperator(">", new Superior()),
			new DjangoOperator("<", new Inferior()),
			new DjangoOperator(">=", new SuperiorOrEqual()),
			new DjangoOperator("<=", new InferiorOrEqual())
			};
	
	public static Value valueOf(String str, ASTBody parentBody, AST ast) {
		boolean priority = false;
		
		if(str.startsWith("("))
			priority = true;

		if(!contains(str, OPERATOR))
			return getValue(str, parentBody);
		
		int index = index(str, OPERATOR);

		String before = str.substring(0, str.indexOf(OPERATOR[index].getOp()));
		String after = str.substring(str.indexOf(OPERATOR[index].getOp()) + OPERATOR[index].getOp().length());
		
		Value beforeValue = valueOf(before, parentBody, ast);
		Value afterValue = valueOf(after, parentBody, ast);
		
		if(afterValue instanceof OpperatingValue) {
			OpperatingValue av = (OpperatingValue) afterValue;
			
			if(av.getOperator().getPriority() < OPERATOR[index].getPriority() || priority) {
				OpperatingValue vb = new OpperatingValue(beforeValue, av.getA(), OPERATOR[index].getOperator());

				Value v = valueOf(str.substring(str.indexOf(getOperator(av.getOperator()).getOp()) + 1), parentBody, ast);
				return new OpperatingValue(vb, v, av.getOperator());
			}
			
		}
		
		return new OpperatingValue(beforeValue, afterValue, OPERATOR[index].getOperator());
		
		
	}
	
	public static boolean contains(String c, DjangoOperator[] array) {
		for(DjangoOperator t : array)
			if(c.contains(t.getOp()))
				return true;
		return false;		
	}
	
	public static int index(String str, DjangoOperator[] array) {
		for(char c : str.toCharArray()) {
			for(int i = 0; i < array.length; i++)
				if(array[i].getOp().charAt(0) == c)
					return i;
		}
		return -1;		
	}

	private static Value getValue(String str, ASTBody parentBody) {
		str = StringManager.remplace(str, "(", "");
		str = StringManager.remplace(str, ")", "");
		
		if(Character.isDigit(str.charAt(0))) {
			return new Value(Integer.valueOf(str));
		}	
		return parentBody.getVariable(str);
		
	}
	
	private static DjangoOperator getOperator(Operator op) {
		for(DjangoOperator dop : OPERATOR)
			if(dop.getOperator().equals(op))
				return dop;
		return null;
	}
	
}
