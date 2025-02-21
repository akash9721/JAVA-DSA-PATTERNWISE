package com.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
	
			private int capacity;
			
			public LRUCache(int capacity) {
				// capacity,loadFactor(threshold value after 75% full data size will increase),accessOrder (used for lruCache))
				super(capacity,0.75f,true);
				this.capacity=capacity;
			}
			
			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
				return size()>capacity;
			}
			
			public static void main(String[] args) {
				LRUCache<String, Integer> studentCache=new LRUCache<>(3);  // cache size is 3 if we add any element then first will removed
				studentCache.put("akash", 99); // this is least recently used
				studentCache.put("vineel", 89);
				studentCache.put("swagat", 88);
				
				studentCache.put("swati", 95);
				studentCache.put("sandhya",83);
				
				System.out.println(studentCache);
			}
}
