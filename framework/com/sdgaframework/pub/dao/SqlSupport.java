package com.sdgaframework.pub.dao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.util.Assert;

import com.sdga.annotation.SDGAColumn;
import com.sdga.annotation.SDGATable;
import com.sdgaframework.pub.domain.AbsDynamicSqlDomain;
import com.sdgaframework.pub.domain.BuildSqlDomain;


public abstract class SqlSupport extends AbsDynamicSqlDomain implements IBuildSql{
	private static Logger logger = Logger.getLogger("Client");
	
	private String getTableName(){
		boolean isTable = this.getClass().isAnnotationPresent(SDGATable.class);
		if (isTable){
			SDGATable table = this.getClass().getAnnotation(SDGATable.class);
			String tableName = table.name();
			if (tableName != null && !"".equals(tableName)){
				return tableName;
			}
		}
		return null;
	}
	private String[] getPrimaryKey(){
		Field[] fields = this.getClass().getDeclaredFields();
		List<String> primaryKeyList = new ArrayList<String>();
		for (Field field : fields){
			if (field.isAnnotationPresent(SDGAColumn.class)){
				SDGAColumn sdgaColumn = field.getAnnotation(SDGAColumn.class);
				if (sdgaColumn.primaryKey()){
					primaryKeyList.add(field.getName());
				}
			}
		}
		String primaryKey[] = new String[primaryKeyList.size()];
		primaryKeyList.toArray(primaryKey);
		return primaryKey;
	}
	private List<String> getTableColumns(){
		List<String> columnList = new ArrayList<String>();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields){
			if (field.isAnnotationPresent(SDGAColumn.class)){
				columnList.add(field.getName());
			}
		}
		return columnList;
	}
	
	private boolean ifDate(String fieldName){
		Field field = null;
		try {
			field = this.getClass().getDeclaredField(fieldName);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SDGAColumn sdgaColumn = field.getAnnotation(SDGAColumn.class);
		return sdgaColumn.date();
	}
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })  
	public final BuildSqlDomain getInsertSqlAndValues(){
		String tableName = this.getTableName();
		this.assertTableName(tableName);
		StringBuffer sql = new StringBuffer("insert into "+tableName+"(");
		List paralist = new ArrayList();
		List<String> columnList = this.getTableColumns();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		long length = columnList.size();
		for(int i=0;i<length;i++){
			String name = columnList.get(i);
			sql.append(name);
			if(i<length-1){
				sql.append(",");
			}
			paralist.add(bw.getPropertyValue(name));
		}
		sql.append(") values(");
		
		for(int i=0;i<length;i++){
			if (ifDate(columnList.get(i))){
				sql.append("to_date(?,'yyyy-mm-dd hh24:mi:ss')");
			}else{
				sql.append("?");
			}
			if(i<length-1){
				sql.append(",");
			}
		}
		
		
		sql.append(")");
		return getBuildSqlDomain(sql.toString(),paralist.toArray());
	}
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })  
	public final BuildSqlDomain getSelectByPkSqlAndValues(){
		String tableName = this.getTableName();
		String[] primaryKey = this.getPrimaryKey();
		this.assertPrimaryKey(primaryKey);
		this.assertTableName(tableName);
		StringBuffer sql = new StringBuffer("select * from "+tableName+" where ");
		List paralist = new ArrayList();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		long primaryKeyLength = primaryKey.length;
		
		for(int i=0;i<primaryKeyLength;i++){
			paralist.add(bw.getPropertyValue(primaryKey[i]));
			if (ifDate(primaryKey[i])){
				sql.append(primaryKey[i]+"=to_date(?,'yyyy-mm-dd hh24:mi:ss')");
			}else{
				sql.append(primaryKey[i]+"=?");
			}
			if(i<primaryKeyLength-1){
				sql.append(" and ");
			}
		}
		return getBuildSqlDomain(sql.toString(),paralist.toArray());
	}
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })  
	public final BuildSqlDomain getDeleteByPkSqlAndValues(){
		String tableName = this.getTableName();
		String[] primaryKey = this.getPrimaryKey();
		this.assertPrimaryKey(primaryKey);
		this.assertTableName(tableName);
		StringBuffer sql = new StringBuffer("delete from "+tableName+" where ");
		List paralist = new ArrayList();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		long primaryKeyLength = primaryKey.length;
		for(int i=0;i<primaryKeyLength;i++){
			paralist.add(bw.getPropertyValue(primaryKey[i]));
			sql.append(primaryKey[i]+"=?");
			if(i<primaryKeyLength-1){
				sql.append(" and ");
			}
		}
		return getBuildSqlDomain(sql.toString(),paralist.toArray());
	}
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })  
	public final BuildSqlDomain getUpdateByPkSqlAndValues(){
		String tableName = this.getTableName();
		String[] primaryKey = this.getPrimaryKey();
		this.assertPrimaryKey(primaryKey);
		this.assertTableName(tableName);
		StringBuffer sql = new StringBuffer("update "+tableName+" set ");
		List paralist = new ArrayList();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		List<String> columnList = this.getTableColumns();
		long columnLength = columnList.size();
		for(int i=0;i<columnLength;i++){
			if( bw.getPropertyValue(columnList.get(i)) != null 
					&& !"".equals(bw.getPropertyValue(columnList.get(i))) ){
				if (ifDate(columnList.get(i))){
					sql.append(columnList.get(i)+"=to_date(?,'yyyy-mm-dd hh24:mi:ss'),");
				}else{
					sql.append(columnList.get(i)+"=?,");
				}
				paralist.add(bw.getPropertyValue(columnList.get(i)));
			}
		}
		sql = new StringBuffer(sql.toString().substring(0, sql.length()-1));
		sql.append(" where ");
		
		long primaryKeyLength = primaryKey.length;
		for(int i=0;i<primaryKeyLength;i++){
			sql.append(primaryKey[i]+"=?");
			paralist.add(bw.getPropertyValue(primaryKey[i]));
			if(i<primaryKeyLength-1){
				sql.append(" and ");
			}
		}
		return getBuildSqlDomain(sql.toString(),paralist.toArray());
	};
	/*
	 * 用于检测表名是否设置正确
	 * @param String tableName*/
	private void assertTableName(String tableName){
		Assert.hasText(tableName, "sql cannot be generated unless tableName is prepared");
	}
	/*用于检测主键是否设置正确
	 * @param String[] primaryKey*/
	private void assertPrimaryKey(String[] primaryKey){
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		Assert.notEmpty(primaryKey,"sql cannot be generated unless primaryKey is prepared");
		for(String str : primaryKey){
			Assert.hasText(str,"sql cannot be generated unless primaryKey is prepared");
			Assert.notNull(bw.getPropertyValue(str),"sql cannot be generated unless primaryKey is prepared");
		}
	}
	/*
	* 一个工厂方法用于生产BuildSqlDomain对象
	* @param String sql
	* @param Object[] value
	* @return BuildSqlDomain
	* */
	private BuildSqlDomain getBuildSqlDomain(String sql, Object[] value){
		BuildSqlDomain bsd = new BuildSqlDomain();
		bsd.setSql(sql);
		bsd.setObject(value);
		return bsd;
	}

}
