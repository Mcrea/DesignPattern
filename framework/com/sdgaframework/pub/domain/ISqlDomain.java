package com.sdgaframework.pub.domain;
@Deprecated
public interface ISqlDomain {

	/*
	 * 返回对象对应的表名
	 * @return String*/
	String getTableName();

	/*
	 * 返回对象对应表的主键
	 * @return String[]*/
	String[] getPrimaryKey();
	/*
	 * 返回对象对应表需要序列号的字段
	 * @return String[]*/
	String[] getSequenceColumns();
	/*
	 * 返回对象对应表的需要序列号的字段对应的序列
	 * @return String*/
	String getSequenceName(String columnName);

}