package org.guili.ecshop.business.impl.product;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.GoodProduct;
import org.guili.ecshop.business.impl.evaluate.EvaluateConstConfig;
import org.guili.ecshop.business.impl.evaluate.TaobaoProductEvaluateService;
import org.guili.ecshop.business.product.IProductSpiderService;
import org.guili.ecshop.util.CommonTools;
import org.guili.ecshop.util.SpiderRegex;

/**
 * taobao产品分析
 * @ClassName:   TaobaoProductSpiderService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-2 下午4:52:27 
 */
public class TaobaoProductSpiderService implements IProductSpiderService {

	private static Logger logger=Logger.getLogger(TaobaoProductSpiderService.class);
	/**
	 * 分析淘宝产品url获取商品信息
	 */
	@Override
	public GoodProduct analyzeProductUrl(String url) {
		
		return null;
	}
	
	/**
	 * 分析url
	 */
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
		if(url==null || !(url.startsWith(EvaluateConstConfig.TAOBAOHEAD) || url.startsWith(EvaluateConstConfig.TAOBAOHEAD.replaceAll("http://", "")))){
			return null;
		}
		//解析url内容
		SpiderRegex regex = new SpiderRegex();
		String htmltext=CommonTools.requestUrl(url, "gbk");
		String productRegex = "<h3 class=\"tb-item-title\">(.*?)</h3>";
		String pricesRegex = "<em class=\"tb-rmb-num\">(.*?)</em>";
		String productImageRegex = "data-src=\"(.*?)\"  data-hasZoom";
		String[] productname= regex.htmlregex(htmltext,productRegex,true);
		String[] productprices= regex.htmlregex(htmltext,pricesRegex,false);
		String[] productImages= regex.htmlregex(htmltext,productImageRegex,false);
		logger.info("productname---->"+productname[0]);
		logger.info("productprices---->"+productprices[0]);
		logger.info("productImages---->"+productImages[0]);
		return parammap;
	}
	
	//测试
	public static void main(String[] args) {
		TaobaoProductSpiderService taobaoProductSpiderService=new TaobaoProductSpiderService();
		//taobaoProductSpiderService.analyzeUrl("http://item.taobao.com/item.htm?spm=a230r.1.14.65.qOznUh&id=35632976705&_u=2nmn69me3da");
		taobaoProductSpiderService.analyzeUrl("http://item.taobao.com/item.htm?spm=a230r.1.14.56.qOznUh&id=35692810779&_u=2nmn69mff28");
	}

}
