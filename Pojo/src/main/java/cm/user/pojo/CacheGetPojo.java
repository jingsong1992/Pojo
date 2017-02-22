package cm.user.pojo;


import org.xml.sax.SAXException;

import cm.user.bean.Library;
import cm.user.cache.CacheInfo;
import cm.user.cache.CacheManager;
import cm.user.xml.GetXMLByDigester;

public class CacheGetPojo {
	
	public synchronized static Object getObject(String cacheName,String fileName,String fileRuleName,String key){
		Object cacheValue = getObjectFromCache(cacheName, key);
		if(null != cacheValue){
			return cacheValue;
		}else{
			//return GetXMLByDigester.parseXmlByDigester(fileName);
			Object digesterValue = null;
			try {
				digesterValue = GetXMLByDigester.parseXmlByDigesterRule(fileName, fileRuleName);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return digesterValue;
		}
	}
	
	public synchronized static Object getObjectFromCache(String cacheName,String key){
		if(isCackeEnabled(cacheName)){
			CacheInfo cache = getCache(cacheName);
			return cache.get(key);
		}
		return null;
	}
	
	public static boolean isCackeEnabled(String cacheName){
		CacheInfo cache = null;
		boolean isCacheEnabled = CacheManager.isCacheEnabled();
		if(isCacheEnabled){
			cache = CacheManager.getCache(cacheName);
			return isCacheEnabled&&(cache!=null&&cache.isEnabled());
		}else{
			return false;	
		}
	}
	
	public static CacheInfo getCache(String name){
		CacheInfo ch = null;
		ch = CacheManager.getCache(name);
		return ch;
	}
	public synchronized static  Library getLibrary(String fileName,String fileRuleName){
		String cacheName = "CACHE_FUNC";
		String key = fileName+"POJO";
		return (Library) getObject(cacheName, fileName, fileRuleName, key);	
	}
}
