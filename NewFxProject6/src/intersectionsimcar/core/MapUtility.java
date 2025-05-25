package intersectionsimcar.core;

import java.util.AbstractMap;
import java.util.Map;

public class MapUtility {
	public static<K,V> Map.Entry<K,V> entry (K k, V v){
		return new AbstractMap.SimpleEntry<>(k,v);
	}
}
