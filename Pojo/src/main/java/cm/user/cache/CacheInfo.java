package cm.user.cache;

public interface CacheInfo {
	public Object get(Object obj);
	public void put(Object obj,Object obj1);
	public boolean remove(Object obj);
	
	public void removeAl();
	
	public String toString();
	
	public boolean isEnabled();
}
