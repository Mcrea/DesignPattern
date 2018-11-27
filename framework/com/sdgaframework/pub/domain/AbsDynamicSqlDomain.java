package com.sdgaframework.pub.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import com.sdga.annotation.SDGAColumn;
import com.sdgaframework.pub.component.AdditionalCondition;
import com.sdgaframework.pub.component.PageData;


/**
 * The root class for accessing a dynamic domain.
 *<p>本类定义了DefaultDynamicSqlDao所使用的domain类的父类
 * domain和数据库之间的数据类型需要转换
 *<p>isExist 判断该对象是否存在，一般是根据主键的数据是否为空来判断，默认为false
 * 
 */
public abstract class AbsDynamicSqlDomain{
	private Logger logger = Logger.getLogger("Client");
	PageData pagadata = new PageData();
	private AdditionalCondition additionalCondition;

	public boolean isExist() {
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
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(this);
		long primaryKeyLength = primaryKey.length;
		for(int i=0;i<primaryKeyLength;i++){
			if( bw.getPropertyValue(primaryKey[i]) == null || "".equals(bw.getPropertyValue(primaryKey[i]))){
				return false;
			}
		}
	   return true;
   }
   
   
   /**
     * 判断字符串是否未null或者为空
	 * @param 一个字符串
	 * @return boolean
	 * with the specified name
	 */
   
   protected boolean isNotNullAndEmpty(String astring){
		  return ( StringUtils.isNotEmpty(astring) && StringUtils.isNotBlank(astring))?true:false;
}
public PageData getPagadata() {
	return pagadata;
}
public void setPagadata(PageData pagadata) {
	this.pagadata = pagadata;
}
public void setRowNums(long totalRecordCount, long itemCountPerPage,
		long pageNumber) {
	pagadata.setRowNums(totalRecordCount, itemCountPerPage, pageNumber);
}
public long getBeginRowNum() {
	return pagadata.getBeginRowNum();
}
public int hashCode() {
	return pagadata.hashCode();
}
public long getEndRowNum() {
	return pagadata.getEndRowNum();
}
public boolean isHasNext() {
	return pagadata.isHasNext();
}
public boolean isHasPrevious() {
	return pagadata.isHasPrevious();
}
public long getItemCountInPage() {
	return pagadata.getItemCountInPage();
}
public long getItemCountPerPage() {
	return pagadata.getItemCountPerPage();
}
public long getLastPageNumber() {
	return pagadata.getLastPageNumber();
}
public long getPageNumber() {
	return pagadata.getPageNumber();
}
public long getTotalRecordCount() {
	return pagadata.getTotalRecordCount();
}
public void setBeginRowNum(long i) {
	pagadata.setBeginRowNum(i);
}
public void setEndRowNum(long i) {
	pagadata.setEndRowNum(i);
}
public void setHasNext(boolean b) {
	pagadata.setHasNext(b);
}
public void setHasNext() {
	pagadata.setHasNext();
}
public void setHasPrevious(boolean b) {
	pagadata.setHasPrevious(b);
}
public void setItemCountInPage(long i) {
	pagadata.setItemCountInPage(i);
}
public void setItemCountInPage(long totalRecordCount, long itemCountPerPage,
		long pageNumber) {
	pagadata.setItemCountInPage(totalRecordCount, itemCountPerPage, pageNumber);
}
public void setHasPrevious() {
	pagadata.setHasPrevious();
}
public boolean equals(Object obj) {
	return pagadata.equals(obj);
}
public void setItemCountPerPage(long i) {
	pagadata.setItemCountPerPage(i);
}
public void setLastPageNumber(long i) {
	pagadata.setLastPageNumber(i);
}
public void setPageNumber(long i) {
	pagadata.setPageNumber(i);
}
public void setTotalRecordCount(long i) {
	pagadata.setTotalRecordCount(i);
}
public void setTotalPageNumber(long totalRecordCount, long itemCountPerPage) {
	pagadata.setTotalPageNumber(totalRecordCount, itemCountPerPage);
}
public String toString() {
	return pagadata.toString();
}
public Logger getLogger() {
	return logger;
}
public void setLogger(Logger logger) {
	this.logger = logger;
}
public AdditionalCondition getAdditionalCondition() {
	return additionalCondition;
}
public void setAdditionalCondition(AdditionalCondition additionalCondition) {
	this.additionalCondition = additionalCondition;
}
}
