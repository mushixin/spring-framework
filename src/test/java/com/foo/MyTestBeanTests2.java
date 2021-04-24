package com.foo;

import com.MyTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * 每个对象，都会重新分配出来
 */
class MyTestBeanTests2 {

	@Autowired
	private MyTestBean myTestBean;

	public MyTestBean getMyTestBean() {
		return myTestBean;
	}

	public void setMyTestBean(MyTestBean myTestBean) {
		this.myTestBean = myTestBean;
	}

	public static void main(String[] args) {


		for(int i = 0 ; i< 10 ;i ++){

			if (i==2){
				new Thread(){
					@Override
					public void run() {
						BeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
						MyTestBean bean =(MyTestBean) bf.getBean("myTestBean");
						bean.setTestStr("new Thread test str");
						System.out.println(bean.getTestStr());
					}
				}.start();

			}

			BeanFactory bf = new XmlBeanFactory(new ClassPathResource("resource.xml"));
			MyTestBean bean =(MyTestBean) bf.getBean("myTestBean");
			System.out.println(i + "  " + bean.getTestStr());

			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}



	}

}