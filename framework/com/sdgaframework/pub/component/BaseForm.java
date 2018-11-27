package com.sdgaframework.pub.component;

import java.util.ArrayList;
import java.util.List;

import com.sdgaframework.pub.dao.SqlSupport;

public class BaseForm {
	private String domainName;
	private String ywtype;
	private String ywstate;
	private String yhdh_l;
	private String xzqh_l;
	private String yhxm_l;
	private String glbm_l;
	private String czip_l;
	List queryList = new ArrayList();
	public String getYwtype() {
		return ywtype;
	}
	public void setYwtype(String ywtype) {
		this.ywtype = ywtype;
	}
	public String getYwstate() {
		return ywstate;
	}
	public void setYwstate(String ywstate) {
		this.ywstate = ywstate;
	}
	public String getYhdh_l() {
		return yhdh_l;
	}
	public void setYhdh_l(String yhdh_l) {
		this.yhdh_l = yhdh_l;
	}
	public String getXzqh_l() {
		return xzqh_l;
	}
	public void setXzqh_l(String xzqh_l) {
		this.xzqh_l = xzqh_l;
	}
	public String getCzip_l() {
		return czip_l;
	}
	public void setCzip_l(String czip_l) {
		this.czip_l = czip_l;
	}
	public List getQueryList() {
		return queryList;
	}
	public void setQueryList(List queryList) {
		this.queryList = queryList;
	}
	public String getYhxm_l() {
		return yhxm_l;
	}
	public void setYhxm_l(String yhxm_l) {
		this.yhxm_l = yhxm_l;
	}
	public String getGlbm_l() {
		return glbm_l;
	}
	public void setGlbm_l(String glbm_l) {
		this.glbm_l = glbm_l;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

}
