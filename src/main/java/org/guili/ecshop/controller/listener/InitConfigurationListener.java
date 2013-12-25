package org.guili.ecshop.controller.listener;

import java.nio.charset.Charset;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.guili.ecshop.bean.common.DomainType;
import org.guili.ecshop.util.common.DomainUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitConfigurationListener implements ServletContextListener {
	
	private static final Logger	log							= LoggerFactory.getLogger(InitConfigurationListener.class);

	/** 样式表 域名的变量. */
	private final String		attribute_domain_css		= "domain_css";

	/** js 域名的变量. */
	private final String		attribute_domain_js			= "domain_js";

	/** image 域名的变量. */
	private final String		attribute_domain_image		= "domain_image";

	/** 商品图片 resource 域名的变量. */
	private final String		attribute_domain_resource	= "domain_resource";

	/** store 域名的变量,商城的网址，一般用于不同环境 第三方数据传递 比如微博等. */
	private final String		attribute_domain_store		= "domain_store";

	private final String		attribute_system_status		= "system_status";

	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		// TODO Auto-generated method stub
		log.debug("Initialize context for application...");
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.log("Charset.defaultCharset().name():" + Charset.defaultCharset().name());
		initDomain(servletContext);
	}
	
	/**
	 * 初始化二级域名
	 * 
	 * @param servletContext
	 */
	private void initDomain(ServletContext servletContext){
		// ********************************domain****************************************
		String domain_css = DomainUtil.getDomain(servletContext, DomainType.CSS);
		servletContext.setAttribute(attribute_domain_css, domain_css);
		// ******************
		String domain_js = DomainUtil.getDomain(servletContext, DomainType.JS);
		servletContext.setAttribute(attribute_domain_js, domain_js);
		// ******************
		String domain_image = DomainUtil.getDomain(servletContext, DomainType.IMAGE);
		servletContext.setAttribute(attribute_domain_image, domain_image);
		// ******************
		String domain_resource = DomainUtil.getDomain(servletContext, DomainType.RESOURCE);
		servletContext.setAttribute(attribute_domain_resource, domain_resource);
		// ******************
		String domain_store = DomainUtil.getDomain(servletContext, DomainType.STORE);
		servletContext.setAttribute(attribute_domain_store, domain_store);
		// *******************************************************************
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n[domain_js]:" + domain_js);
		stringBuilder.append("\n[domain_css]:" + domain_css);
		stringBuilder.append("\n[domain_image]:" + domain_image);
		stringBuilder.append("\n[domain_resource]:" + domain_resource);
		stringBuilder.append("\n[domain_store]:" + domain_store);
		servletContext.log(stringBuilder.toString());
	}

}
