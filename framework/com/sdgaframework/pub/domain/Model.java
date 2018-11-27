/*
 * Copyright 2002-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sdgaframework.pub.domain;

import org.springframework.web.servlet.View;

import com.sdgaframework.pub.component.BaseForm;





/**
 

 */
public class Model {

	/** View instance or view name String */
	private String viewname;
	
	private String objName;
	/** Model Map */
	private BaseForm model;

	

	/**
	 * Default constructor for bean-style usage: populating bean
	 * properties instead of passing in constructor arguments.
	 * @see #setView(View)
	 * @see #setViewName(String)
	 */
	private Model() {
	}

	/**
	 * Convenient constructor when there is no model data to expose.
	 * Can also be used in conjunction with <code>addObject</code>.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @see #addObject
	 */
	public Model(String viewName) {
		this.viewname = viewName;
	}

	
	public String getViewname() {
		return viewname;
	}

	public void setViewname(String viewname) {
		this.viewname = viewname;
	}

	/**
	 * Return diagnostic information about this model and view.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Model: ");
	    sb.append("reference to view with name '").append(this.viewname).append("'");
		sb.append("; model is ").append(this.model);
		return sb.toString();
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public BaseForm getModel() {
		return model;
	}

	public void setModel(BaseForm model) {
		this.model = model;
	}
}
