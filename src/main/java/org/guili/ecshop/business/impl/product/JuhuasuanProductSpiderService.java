package org.guili.ecshop.business.impl.product;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.GoodProduct;
import org.guili.ecshop.business.impl.evaluate.EvaluateConstConfig;
import org.guili.ecshop.business.product.IProductSpiderService;
import org.guili.ecshop.util.CommonTools;
import org.guili.ecshop.util.SpiderRegex;
import org.guili.ecshop.util.common.TimeUtils;

public class JuhuasuanProductSpiderService implements IProductSpiderService {

	private static Logger logger=Logger.getLogger(JuhuasuanProductSpiderService.class);
	@Override
	public GoodProduct analyzeProductUrl(String url) {
		return null;
	}

	@Override
	public Map<String, String> analyzeUrl(String producturl) {
		Map<String, String> parammap=new HashMap<String, String>();
		parammap=this.taobaoAnalyze(producturl);
		return parammap;
	}
	/**
	 * juhuasuan私有解析淘宝url函数
	 * @param url
	 * @return
	 */
	private  Map<String, String>  taobaoAnalyze(String url){
		Map<String, String> parammap=new HashMap<String, String>();
		if(url==null || !(url.startsWith(EvaluateConstConfig.JUHEAD) || url.startsWith(EvaluateConstConfig.JUHEAD.replaceAll("http://", "")))){
			return null;
		}
		//解析url内容
		SpiderRegex regex = new SpiderRegex();
		String htmltext=CommonTools.requestUrl(url, "gbk");
		String productRegex = "<div class=\"name-box\">(.*?)</div>";
		String productDescRegex="<div class=\"description\">(.*?)</div>";
		String pricesRegex = "<span class=\"currentPrice floatleft\">(.*?)</span>";
		String prePricesRegex="<del class=\"originPrice\">(.*?)</del>";
		String zhekouRegex="<div class=\"discount\">(.*?)</div>";
		String productStartRegex="data-targettime=\"(.*?)\"";
		String productImageRegex="<div class=\"normal-pic \">(.*?)</div>";
		String[] productname= regex.htmlregex(htmltext,productRegex,false);
		String[] productDesc= regex.htmlregex(htmltext,productDescRegex,false);
		String[] productprices= regex.htmlregex(htmltext,pricesRegex,false);
		String[] productPrePrices= regex.htmlregex(htmltext,prePricesRegex,false);
		String[] productzhekous= regex.htmlregex(htmltext,zhekouRegex,false);
		String[] productStarts= regex.htmlregex(htmltext,productStartRegex,false);
		String[] productImages= regex.htmlregex(htmltext,productImageRegex,true);
		logger.info("productname---->"+productname[0].trim());
		logger.info("productPrePrices---->"+productPrePrices[0].trim());
		logger.info("productzhekou---->"+productzhekous[0].trim());
		logger.info("productprices---->"+productprices[0].trim());
		logger.info("productDesc---->"+productDesc[0].trim());
		logger.info("productStarts---->"+TimeUtils.getDateTimeByMillisecond(productStarts[0]));
		logger.info("productImages---->"+productImages[0].substring(productImages[0].indexOf("src=")+"src=\"".length(), productImages[0].indexOf("data-ks-imagezoom")-"\" ".length()));
		
		return parammap;
	}
	

//  public static void main(String[] args) {
//	  
//    Calendar calendar = Calendar.getInstance();
//    String str = String.valueOf(calendar.getTimeInMillis());
//    String time1 = getDateTimeByMillisecond(str);
//     String time2 = getDateTimeByMillisecond("1389232800000");
//     System.out.println(time1 + "\n" + time2);
//   }
	//test
	public static void main(String[] args) {
		IProductSpiderService jdProductSpiderService=new JuhuasuanProductSpiderService();
		jdProductSpiderService.analyzeUrl("http://detail.ju.taobao.com/home.htm?spm=608.5847457.11.d5.K8k6P6&item_id=36208494957&id=10000001811710");
	}
}
