package org.guili.ecshop.dao.spider;

import java.util.List;

import org.guili.ecshop.bean.spider.TopStore;

/**
 * interface
 * @author guili
 *
 */
public interface ITopStoreDao {
	public boolean addTopstore(TopStore topStore) throws Exception;
	public TopStore selectOneTopstore()throws Exception;
	public List<TopStore> selectTopstoreTag()throws Exception;
	public List<TopStore> selectAllTogStores()throws Exception;
}
