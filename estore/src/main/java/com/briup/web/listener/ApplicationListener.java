package com.briup.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.service.impl.CategoryDetailServiceImpl;
import com.briup.service.impl.ProductServiceImpl;
import com.briup.service.impl.ReportServiceImpl;

/**
 * .首页展示
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("reports", new ReportServiceImpl().listReport());
		application.setAttribute("categorys", new CategoryDetailServiceImpl().listCategoryDetail());
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		application.setAttribute("products", productServiceImpl.listAllProduct());
		application.setAttribute("hotProducts", productServiceImpl.listHostProducet());
	}

}
