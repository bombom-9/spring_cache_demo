package com.demo.config;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.springframework.util.ObjectUtils;

import com.demo.message.entity.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheEventLogger implements CacheEventListener<Message, Message> {

	@Override
	public void onEvent(CacheEvent<? extends Message, ? extends Message> cacheEvent) {
		log.info("[" + cacheEvent.getType() + "] key : " + cacheEvent.getKey() + ", oldValue : "
				+ (!ObjectUtils.isEmpty(cacheEvent.getOldValue()) ? cacheEvent.getOldValue().getDate() : "''")
				+ ", newValue : "
				+ (!ObjectUtils.isEmpty(cacheEvent.getNewValue()) ? cacheEvent.getNewValue().getDate() : "''"));
	}

}
