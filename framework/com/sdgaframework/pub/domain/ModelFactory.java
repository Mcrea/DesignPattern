package com.sdgaframework.pub.domain;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

import com.sdgaframework.pub.component.BaseForm;


public class ModelFactory {
	private static Logger log = Logger.getLogger("Client");
	public static Model createModel(BaseForm form, String viewName){
		try {
			Class<?> clazz = Class.forName("com.sdgaframework.pub.domain.Model");
			Constructor c = clazz.getDeclaredConstructor();
			c.setAccessible(true);
			Model model = (Model)c.newInstance();
			model.setModel(form);
			model.setViewname(viewName);
			return model;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("exception occuring while creating model");
		}
		return null;
	}
}
