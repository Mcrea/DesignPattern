/**
 * 
 */
package com.sdgaframework.pub.dao;

import com.sdgaframework.pub.domain.AbsDynamicSqlDomain;
import com.sdgaframework.pub.domain.BuildSqlDomain;

/**
 * @author Administrator
 *
 */
public interface IBuildSql {
	/*
	 * return @BuildSqlDomain
	 * 自动生成用于插入信息的sql*/
	BuildSqlDomain getInsertSqlAndValues();
	/*
	 * return @BuildSqlDomain
	 * 自动生成用于根据主键查询单条记录的sql*/
	BuildSqlDomain getSelectByPkSqlAndValues();
	/*
	 * return @BuildSqlDomain
	 * 自动生成用于根据主键删除单条记录的sql*/
	BuildSqlDomain getDeleteByPkSqlAndValues();
	/*
	 * return @BuildSqlDomain
	 * 自动生成用于根据主键修改单条记录的sql*/
	BuildSqlDomain getUpdateByPkSqlAndValues();
	/*
	 * return @BuildSqlDomain
	 * 根据key值返回用户自定义的sql*/
	BuildSqlDomain getSqlAndValues(String key);
	
}
