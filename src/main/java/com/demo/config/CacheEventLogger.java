package com.demo.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {

	@Override
	public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
		log.info("key : " + cacheEvent.getKey() + ", oldValue : " + cacheEvent.getOldValue() + ", newValue : " + cacheEvent.getNewValue());
	}

}
