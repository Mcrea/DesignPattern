package com.sdgaframework.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.sdgaframework.pub.component.BaseForm;
import com.sdgaframework.pub.dao.DefaultDynamicSqlDao;
import com.sdgaframework.pub.dao.SqlSupport;
import com.sdgaframework.pub.domain.Model;
import com.sdgaframework.pub.domain.ModelFactory;

public abstract class AbstractService implements IService {
	protected DefaultDynamicSqlDao dynamicsqldao;
	
	protected Model addCertainDomain(BaseForm baseForm){
		SqlSupport domain = null;
		try {
			domain = this.getDomain(baseForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k = this.dynamicsqldao.insert(domain);
		if (k != 0){
			baseForm.setYwstate("操作完成");
		}else{
			baseForm.setYwstate("服务器异常，请稍后再试");
		}
		return ModelFactory.createModel(baseForm, loadViewName(baseForm.getYwtype()));
	}
	
	protected Model delCertainDomain(BaseForm baseForm){
		SqlSupport domain = null;
		try {
			domain = this.getDomain(baseForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k = this.dynamicsqldao.deleteByPk(domain);
		if (k != 0){
			baseForm.setYwstate("操作完成");
		}else{
			baseForm.setYwstate("服务器异常，请稍后再试");
		}
		return ModelFactory.createModel(baseForm, loadViewName(baseForm.getYwtype()));
	}
	protected Model updateCertainDomain(BaseForm baseForm){
		SqlSupport domain = null;
		try {
			domain = this.getDomain(baseForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k = this.dynamicsqldao.updateByPk(domain);
		if (k != 0){
			baseForm.setYwstate("操作完成");
		}else{
			baseForm.setYwstate("服务器异常，请稍后再试");
		}
		return ModelFactory.createModel(baseForm, loadViewName(baseForm.getYwtype()));
	}
	protected Model getCertainDomain(BaseForm baseForm){
		SqlSupport domain = null;
		try {
			domain = this.getDomain(baseForm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSupport ss = this.dynamicsqldao.selectByPk(domain);
		if (ss.isExist()){
			try {
				this.setDomain(baseForm, ss);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			baseForm.setYwstate("查无数据");
		}
		return ModelFactory.createModel(baseForm, loadViewName(baseForm.getYwtype()));
	}
	protected abstract String loadViewName(String ywtype);
	
	private SqlSupport getDomain(BaseForm baseForm) throws Exception{
		String domainName = baseForm.getDomainName();
		String upper = domainName.substring(0,1).toUpperCase();
		Method method = baseForm.getClass().getDeclaredMethod("get"+upper+domainName.substring(1));
		if (method != null){
			return (SqlSupport) method.invoke(baseForm);
		}
		return null;
	}
	private void setDomain(BaseForm baseForm, SqlSupport domain) throws Exception{
		String domainName = baseForm.getDomainName();
		String upper = domainName.substring(0,1).toUpperCase();
		Method method = baseForm.getClass()
				.getDeclaredMethod("set"+upper+domainName.substring(1), Class.forName("com.sdga.domain."+upper+domainName.substring(1)));
		if (method != null){
			method.invoke(baseForm, domain);
		}
	}
	public DefaultDynamicSqlDao getDynamicsqldao() {
		return dynamicsqldao;
	}
	public void setDynamicsqldao(DefaultDynamicSqlDao dynamicsqldao) {
		this.dynamicsqldao = dynamicsqldao;
	}
}
