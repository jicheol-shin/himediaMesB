package com.mes.utility;

public class ActionForward {
	
	private boolean isRedirect = false;
	private String path = null;
	
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public boolean isForward() {
		return isRedirect;
	}
	
}
