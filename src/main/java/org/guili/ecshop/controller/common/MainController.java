package org.guili.ecshop.controller.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.guili.ecshop.bean.spider.TopStoreInfo;
import org.guili.ecshop.business.spider.ITopStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页跳转和首页需要信息的跳转
 * @ClassName:   MainController 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2013-11-19 下午7:09:51 
 *
 */
@Controller
public class MainController {
	
	@Resource(name="topStoreService")
	private ITopStoreService topStoreService;
	
	/**
	 * 首页跳转
	 * @param request
	 * @param modelMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value={ "/index.htm", "/" })
	public String index(HttpServletRequest request,ModelMap modelMap) throws Exception{
//		Semiconductor semiconductor=testBusiness.findone();
//		log.info("logger--->"+semiconductor.getCreateTime());
		return "index";
	}
	
	@RequestMapping(value={ "/index1.htm", "/" })
	public String index1(HttpServletRequest request,ModelMap modelMap) throws Exception{
//		Semiconductor semiconductor=testBusiness.findone();
//		log.info("logger--->"+semiconductor.getCreateTime());
		List<TopStoreInfo> allTopstore=new ArrayList<TopStoreInfo>();
		allTopstore=topStoreService.selectAllTopstore();
		modelMap.put("allTopstore", allTopstore);
		return "index1";
	}
}
