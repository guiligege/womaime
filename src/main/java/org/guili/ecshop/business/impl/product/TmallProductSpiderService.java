package org.guili.ecshop.business.impl.product;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.GoodProduct;
import org.guili.ecshop.business.impl.evaluate.EvaluateConstConfig;
import org.guili.ecshop.business.product.IProductSpiderService;
import org.guili.ecshop.util.CommonTools;
import org.guili.ecshop.util.SpiderRegex;

public class TmallProductSpiderService implements IProductSpiderService {

	private static Logger logger=Logger.getLogger(TmallProductSpiderService.class);
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
		if(url==null || !(url.startsWith(EvaluateConstConfig.TMALLHEAD) || url.startsWith(EvaluateConstConfig.TMALLHEAD.replaceAll("http://", "")))){
			return null;
		}
		//解析url内容
		SpiderRegex regex = new SpiderRegex();
		String htmltext=CommonTools.requestUrl(url, "gbk");
		String productRegex = "<div class=\"tb-detail-hd\">(.*?)</div>";
		String pricesRegex = "'reservePrice'(.*?)',";
		String prePricesRegex = "<span class=\"tm-price-item\">(.*?)</span>";
		String productImageRegex = "id=\"J_ImgBooth\" src=\"(.*?)\"";
		String productAttributesRegex = "<ul id=\"J_AttrUL\">(.*?)</ul>";
		
		String[] productname= regex.htmlregex(htmltext,productRegex,false);
		String[] productprices= regex.htmlregex(htmltext,pricesRegex,false);
		String[] preProductprices= regex.htmlregex(htmltext,prePricesRegex,false);
		String[] productImages= regex.htmlregex(htmltext,productImageRegex,false);
		String[] productAttributes= regex.htmlregex(htmltext,productAttributesRegex,false);
		
		logger.info("productname---->"+productname[0].trim());
		String[] productinfo= productname[0].trim().split("					 							        							");
		logger.info("productname---->"+productinfo[0].trim()+"---"+productinfo[1].trim());
		logger.info("productprices---->"+productprices[0].substring(" : '".length()));
		logger.info("preProductprices---->"+preProductprices[0]);
		logger.info("productImages---->"+productImages[0]);
		String[] productAttributesinfo= productAttributes[0].trim().split("			");
		logger.info("productAttributes---->"+productAttributes[0].trim());
		return parammap;
	}

	//test
	public static void main(String[] args) {
		IProductSpiderService jdProductSpiderService=new TmallProductSpiderService();
		jdProductSpiderService.analyzeUrl("http://detail.tmall.com/item.htm?spm=a1z10.3.w4011-4656725005.66.NvqE9a&id=35555473295&rn=336f83ce439d7d737b757a196236decb");
	}
}
