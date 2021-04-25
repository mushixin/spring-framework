package com.foo;

import com.MyTestBean;
import com.MyTestBean2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 每个对象，都会重新分配出来
 */
class MyTestBeanTests {

	@Autowired
	private MyTestBean myTestBean;


	public static void main(String[] args) {


		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
//		reader.loadBeanDefinitions(new ClassPathResource("resource.xml"));

		MyTestBean bean = (MyTestBean) bf.getBean("myTestBean");
		bean.setTestStr("newTestStr");
		System.out.println(bean.getTestStr());



//		XmlBeanFactory factory =(XmlBeanFactory) bf.getBean("&myTestBean");
//		System.out.println(factory.containsBean("myTestBean"));

		//是单例的，是会互相影响的。
//		MyTestBean2 bean2 =(MyTestBean2) bf.getBean("myTestBean2");
//		MyTestBean testBean1= bean2.getMyTestBean();
//		System.out.println(testBean1.getTestStr());
//
//		bean.setTestStr("newTestStr lalala");
//
//		System.out.println(testBean1.getTestStr());


//		for(int i = 0 ; i< 10 ;i ++){
//
//			if (i==2){
//				new Thread(){
//					@Override
//					public void run() {
//						BeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
//						MyTestBean bean =(MyTestBean) bf.getBean("myTestBean");
//						bean.setTestStr("new Thread test str");
//						System.out.println(bean.getTestStr());
//					}
//				}.start();
//
//			}
//
//			BeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
//			MyTestBean bean =(MyTestBean) bf.getBean("myTestBean");
//			System.out.println(i + "  " + bean.getTestStr());
//
//			try {
//				Thread.sleep(1000L);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//		}



	}

	public MyTestBean getMyTestBean() {
		return myTestBean;
	}

	public void setMyTestBean(MyTestBean myTestBean) {
		this.myTestBean = myTestBean;
	}
}