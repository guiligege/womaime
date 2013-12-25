package org.guili.ecshop.impl.spider;

import java.util.List;

import org.guili.ecshop.bean.spider.Semiconductor;
import org.guili.ecshop.bean.spider.TopStore;
import org.guili.ecshop.dao.spider.ITopStoreDao;
import org.guili.ecshop.util.BasicSqlSupport;

/**
 * 淘宝天猫top
 * @ClassName:   TopStoreDao 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:      guilige 
 * @date         2013-12-11 下午2:58:24 
 *
 */
public class TopStoreDao extends BasicSqlSupport implements ITopStoreDao {

	@Override
	public boolean addTopstore(TopStore topStore) throws Exception {
		boolean flag=false;
		int count=this.session.insert("org.guili.ecshop.dao.spider.ITopStoreDao.addTopstore", topStore);
		if(count>0){
			flag=true;
		}
		return flag;
	}

	@Override
	public TopStore selectOneTopstore() throws Exception {
		return null;
	}

	@Override
	public List<TopStore> selectTopstoreTag() throws Exception {
		@SuppressWarnings("unchecked")
		List<TopStore> semiconductor=(List<TopStore>)this.session.selectList("org.guili.ecshop.dao.spider.ITopStoreDao.selectTopstoreTag");
		return semiconductor;
	}

	@Override
	public List<TopStore> selectAllTogStores() throws Exception {
		@SuppressWarnings("unchecked")
		List<TopStore> semiconductor=(List<TopStore>)this.session.selectList("org.guili.ecshop.dao.spider.ITopStoreDao.selectAllTogStores");
		return semiconductor;
	}

}
