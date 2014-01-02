package org.guili.ecshop.business.product;

import java.util.Map;

import org.guili.ecshop.bean.spider.GoodProduct;

/**
 * 产品分析
 * @ClassName:   ProductSpiderService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2014-1-2 下午4:51:11 
 *
 */
public interface IProductSpiderService {
    public GoodProduct analyzeProductUrl(String url);
    
    public Map<String, String> analyzeUrl(String producturl);
}
