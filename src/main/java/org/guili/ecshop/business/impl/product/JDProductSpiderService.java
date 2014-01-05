package org.guili.ecshop.business.impl.product;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.GoodProduct;
import org.guili.ecshop.business.impl.evaluate.EvaluateConstConfig;
import org.guili.ecshop.business.product.IProductSpiderService;
import org.guili.ecshop.util.CommonTools;
import org.guili.ecshop.util.SpiderRegex;

public class JDProductSpiderService implements IProductSpiderService {

	private static Logger logger=Logger.getLogger(TaobaoProductSpiderService.class);
	@Override
	public GoodProduct analyzeProductUrl(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> analyzeUrl(String producturl) {
		Map<String, String> parammap=new HashMap<String, String>();
		parammap=this.taobaoAnalyze(producturl);
		return parammap;
	}
	
	/**
	 * taobao私有解析淘宝url函数
	 * @param url
	 * @return
	 */
	private  Map<String, String>  taobaoAnalyze(String url){
		Map<String, String> parammap=new HashMap<String, String>();
		if(url==null || !(url.startsWith(EvaluateConstConfig.JDHEAD) || url.startsWith(EvaluateConstConfig.JDHEAD.replaceAll("http://", "")))){
			return null;
		}
		//解析url内容
		SpiderRegex regex = new SpiderRegex();
		String htmltext=CommonTools.requestUrl(url, "gbk");
		String productRegex = "<h3 class=\"tb-item-title\">(.*?)</h3>";
		String pricesRegex = "<em class=\"tb-rmb-num\">(.*?)</em>";
		String productImageRegex = "data-src=\"(.*?)\"  data-hasZoom";
		String productAttributesRegex = "<ul class=\"attributes-list\">(.*?)</ul>";
		String[] productname= regex.htmlregex(htmltext,productRegex,true);
		String[] productprices= regex.htmlregex(htmltext,pricesRegex,false);
		String[] productImages= regex.htmlregex(htmltext,productImageRegex,false);
		String[] productAttributes= regex.htmlregex(htmltext,productAttributesRegex,false);
		logger.info("productname---->"+productname[0]);
		logger.info("productprices---->"+productprices[0]);
		logger.info("productImages---->"+productImages[0]);
		logger.info("productAttributes---->"+productAttributes[0]);
		return parammap;
	}
	
	//test
	public static void main(String[] args) {
		IProductSpiderService jdProductSpiderService=new JDProductSpiderService();
		jdProductSpiderService.analyzeUrl("http://detail.ju.taobao.com/home.htm?spm=608.5847457.11.d5.K8k6P6&item_id=36208494957&id=10000001811710");
	}

}
