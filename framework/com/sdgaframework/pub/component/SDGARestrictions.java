package com.sdgaframework.pub.component;

public abstract class SDGARestrictions {
	
	public static SDGACondition eq(String columnName){
		SDGACondition condition = new SDGACondition();
		condition.setColumnName(columnName);
		condition.setCondition(columnName+"=? ");
		return condition;
	}
}
