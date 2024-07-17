package com.demo.message.service;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.message.vo.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageService {

    @Cacheable(value = "testCache", key = "#id", cacheManager = "infinispanCacheManager")
    public Message getMessage(String id) {
    	log.info("create testCache : " + id);
    	return new Message(id, new Date());
    }
    
    @CachePut(value = "testCache", key = "#id", cacheManager = "infinispanCacheManager")
    public Message getNewMessage(String id) {
        return new Message(id, new Date());
    }	
    	
    @CacheEvict(value = "testCache", key = "#id", cacheManager = "infinispanCacheManager")
    public void deleteMessage(String id) {
    	
    }
    
}
