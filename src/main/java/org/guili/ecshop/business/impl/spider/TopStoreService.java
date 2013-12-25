package org.guili.ecshop.business.impl.spider;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.guili.ecshop.bean.spider.TopStore;
import org.guili.ecshop.bean.spider.TopStoreInfo;
import org.guili.ecshop.business.spider.ITopStoreService;
import org.guili.ecshop.dao.spider.ITopStoreDao;

/**
 * 高信誉卖家信息。
 * @ClassName:   TopStoreService 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2013-12-11 下午2:18:52 
 *
 */
public class TopStoreService implements ITopStoreService {

	private static Logger logger=Logger.getLogger(TopStoreService.class);
	private ITopStoreDao iTopStoreDao;
	@Override
	public boolean addTopstore(TopStore topStore) {
		
		try {
			iTopStoreDao.addTopstore(topStore);
		} catch (Exception e) {
			logger.error("topStore is error:"+topStore.getStoreinfo());
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 保存高信誉店铺
	 */
	public void saveTopstores(List<TopStore> topStoreList){
		if(topStoreList==null)
			return ;
		for(TopStore topStore:topStoreList){
			this.addTopstore(topStore);
		}
	}
	@Override
	public TopStore selectOneTopstore() {
		return null;
	}
	public void setiTopStoreDao(ITopStoreDao iTopStoreDao) {
		this.iTopStoreDao = iTopStoreDao;
	}
	@Override
	public List<TopStore> selectTopstoreTag() {
		List<TopStore> topStores=new ArrayList<TopStore>();
		try {
			topStores=iTopStoreDao.selectTopstoreTag();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return topStores;
	}
	
	/**
	 * 查询所有店铺信息
	 */
	@Override
	public List<TopStoreInfo> selectAllTopstore() {
		List<TopStoreInfo> topStoreInfoList=new ArrayList<TopStoreInfo>();
		List<TopStore> toptags=new ArrayList<TopStore>();
		List<TopStore> allTopStores=new ArrayList<TopStore>();
		toptags=selectTopstoreTag();
		if(toptags.isEmpty()){
			return null;
		}
		try {
			allTopStores=iTopStoreDao.selectAllTogStores();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(allTopStores.isEmpty()){
			return null;
		}
		//构造店铺信息
		for(TopStore topStoreTag:toptags){
			TopStoreInfo topStoreInfo=new TopStoreInfo();
			topStoreInfo.setStoreTag(topStoreTag.getStoretag());
			List<TopStore> oneTagStores=new ArrayList<TopStore>();
			for(TopStore topstore:allTopStores){
				if(topStoreInfo.getStoreTag().equals(topstore.getStoretag())){
					oneTagStores.add(topstore);
				}
			}
			topStoreInfo.setTopStoreList(oneTagStores);
			topStoreInfoList.add(topStoreInfo);
		}
		return topStoreInfoList;
	}
	
	
}
