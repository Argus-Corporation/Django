package net.argus.django.lang.ats;

import java.util.ArrayList;
import java.util.List;

import net.argus.django.lang.exception.DjangoException;

public class ASTId {
	
	public static final int BODY_ID = 0x100000;
	public static final int WHILE_ID = 0x200000;
	public static final int CONDITION_ID = 0x300000;
	public static final int RETURN_ID = 0x400000;
	public static final int IF_ID = 0x500000;
	public static final int ASSIGN_ID = 0x600000;
	public static final int FUNCTION_ID = 0x700000;
	
	private static List<ASTId> ids = new ArrayList<ASTId>();
	
	private int id;
	
	public ASTId(int id) {
		this.id = id;
		
		if(ids.contains(this))
			throw new DjangoException(id + " already register");
		
		ids.add(this);
	}
	
	
	/**
	 * return id
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "0x" + String.format("%x", id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ASTId)
			return ((ASTId) obj).id == id;
		else if(obj instanceof Integer)
			return (int) obj == id;
		
		return false;
	}

}
