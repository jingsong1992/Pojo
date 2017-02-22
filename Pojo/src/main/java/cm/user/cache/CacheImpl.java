package cm.user.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class CacheImpl implements CacheInfo{
	private Cache cache;
	
	public CacheImpl(Cache ch){
		cache = ch;
	}
	public Object get(Object key) {
		Element element = cache.get(key);
		if(element == null){
			return null;
		}
		return element.getObjectValue();
	}

	public void put(Object key, Object value) {
		Element element = new Element(key,value);
		cache.put(element);
	}

	public boolean remove(Object key) {
		return cache.remove(key);
	}

	public void removeAl() {
		cache.removeAll();
	}

	public boolean isEnabled() {
		return cache.getMaxElementsInMemory()>0;
	}

}
