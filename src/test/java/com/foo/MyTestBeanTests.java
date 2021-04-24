package com.foo;

import com.MyTestBean;
import org.junit.Test;
import org.springframework.aop.support.PointcutsTests;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertThat;

/**
 *
 * @author Lazy Hu
 */
class MyTestBeanTests {

	public static void main(String[] args) {

		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
		MyTestBean bean =(MyTestBean) bf.getBean("myTestBean");
		System.out.println(bean.getTestStr());

	}

}