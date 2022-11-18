package net.argus.django.lang.ats;

import net.argus.django.lang.RuntimeMemory;
import net.argus.django.lang.val.ReturnValue;
import net.argus.django.lang.val.Value;

public abstract class ASTNode {
	
	private ASTId nodeId;
	
	public ASTNode(int nodeId) {
		this.nodeId = new ASTId(nodeId);
	}
	
	public abstract ReturnValue exec(RuntimeMemory runtime);
	
	/**
	 * get node id
	 * @return
	 */
	public ASTId getNodeId() {
		return nodeId;
	}
	
	protected Value[] getValues(RuntimeMemory runtime) {
		return runtime.getValues(nodeId);
	}
	
	@Override
	public String toString() {
		return "nodes@" + getNodeId();
	}
	
}
