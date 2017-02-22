package cm.user.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {
	private static net.sf.ehcache.CacheManager cm = null;
	private static Map mapCache = new HashMap();
	private static boolean isCacheEnable;
	
	public static synchronized void init(String configFile) {
		if(cm != null){
			return;
		}
		net.sf.ehcache.CacheManager.create(configFile);
		cm = net.sf.ehcache.CacheManager.getInstance();
		String[] caches = cm.getCacheNames();
		String cacheName = null;
		for(int i =0;i<caches.length;i++){
			cacheName = caches[i];
			System.out.println(cacheName);
			mapCache.put(cacheName, new CacheImpl(cm.getCache(cacheName)));
		}
	}
	
	
	public static boolean isCacheEnabled(){
    	return isCacheEnable;
    }
	
    public static CacheInfo getCache(String name)
    {
    	net.sf.ehcache.Cache ch = cm.getCache(name);
    	if(ch == null){
    		return null;
    	}
		CacheImpl cacheImpl = (CacheImpl) mapCache.get(name);
        return cacheImpl;
    }
	public static void main(String[] args) {
		CacheManager.init("E:/Cache_Config.xml");
	}
}
