package org.guili.ecshop.business.impl.product;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.GoodProduct;
import org.guili.ecshop.business.impl.evaluate.EvaluateConstConfig;
import org.guili.ecshop.business.product.IProductSpiderService;
import org.guili.ecshop.util.CommonTools;
import org.guili.ecshop.util.SpiderRegex;

public class AmazonProductSpiderService implements IProductSpiderService {

	private static Logger logger=Logger.getLogger(AmazonProductSpiderService.class);
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
		if(url==null || !(url.startsWith(EvaluateConstConfig.AMAZONHEAD) || url.startsWith(EvaluateConstConfig.AMAZONHEAD.replaceAll("http://", "")))){
			return null;
		}
		//解析url内容
		SpiderRegex regex = new SpiderRegex();
		String htmltext=CommonTools.requestUrl(url, "gbk");
		String productRegex = "<h1 class=\"parseasinTitle\">(.*?)</h1>";
		
		String pricesRegex = "<span class=\"priceLarge\">(.*?)</span>";
		String prePricesRegex = " <td class=\"listprice\">(.*?)</td>";
		String productImageRegex = "id=\"main-image-nonjs\" src=\"(.*?)\"";
		String productIsFree = "此商品可以享受(.*?)</b>";
		String productAttributesRegex = " <div class=\"tsTable\">(.*?)<div class=\"bucket\" id=\"productDescription\">";
		
		String[] productname= regex.htmlregex(htmltext,productRegex,false);
		String[] productprices= regex.htmlregex(htmltext,pricesRegex,false);
		String[] preProductprices= regex.htmlregex(htmltext,prePricesRegex,false);
		String[] productImages= regex.htmlregex(htmltext,productImageRegex,false);
		String[] productIsFrees= regex.htmlregex(htmltext,productIsFree,false);
		String[] productAttributes= regex.htmlregex(htmltext,productAttributesRegex,false);
		
		logger.info("productname---->"+productname[0].trim());
//		String[] productinfo= productname[0].trim().split("					 							        							");
//		logger.info("productname---->"+productinfo[0].trim()+"---"+productinfo[1].trim());
		logger.info("productprices---->"+productprices[0]);
		logger.info("preProductprices---->"+preProductprices[0]);
		logger.info("productImages---->"+productImages[0]);
		logger.info("productIsFrees---->"+productIsFrees[0]);
//		String[] productAttributesinfo= productAttributes[0].trim().split("			");
		logger.info("productAttributes---->"+productAttributes[0].trim());
		return parammap;
	}
	
	//test
	public static void main(String[] args) {
		IProductSpiderService jdProductSpiderService=new AmazonProductSpiderService();
		jdProductSpiderService.analyzeUrl("http://www.amazon.cn/gp/product/B00EY2XBLK/ref=gb1h_img_c-4_4792_A2845Z9V78ODEN?smid=A1AJ19PSB66TGU&pf_rd_m=A1AJ19PSB66TGU&pf_rd_t=101&pf_rd_s=center-4&pf_rd_r=0B98QT934ZC2F6B2QHD0&pf_rd_i=42450071&pf_rd_p=112894792");
	}

}
