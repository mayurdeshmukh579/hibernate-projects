package com.maytech.lms.initializer;

import org.springframework.beans.propertyeditors.ClassArrayEditor;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LmsInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {LmsConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
