package com.demo.config;

import java.io.IOException;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.parsing.ConfigurationBuilderHolder;
import org.infinispan.configuration.parsing.ParserRegistry;
import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.spring.embedded.provider.SpringEmbeddedCacheManager;
import org.infinispan.spring.starter.embedded.InfinispanCacheConfigurer;
import org.infinispan.spring.starter.embedded.InfinispanConfigurationCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class InfinispanConfig {

	@Primary
	@Bean("infinispanCacheManager")
    public CacheManager infinispanCacheManager() throws IOException {
        ClassPathResource resource = new ClassPathResource("infinispan.xml");
        ConfigurationBuilderHolder holder = new ParserRegistry().parse(resource.getURL());
        EmbeddedCacheManager cacheManager = new DefaultCacheManager(holder, true);

//        addAdditionalCaches(cacheManager, "add-infinispan.xml");
        
        return new SpringEmbeddedCacheManager(cacheManager);
    }
	
//	@Bean
//	public InfinispanCacheConfigurer configurationCustomizer() {
//		return manager -> {
//			final org.infinispan.configuration.cache.Configuration ispnConfig = new ConfigurationBuilder()
//	                        .clustering()
//	                        .cacheMode(CacheMode.LOCAL)
//	                        .build();
//
//			manager.defineConfiguration("local-sync-config", ispnConfig);
//		};
//	}

//    private void addAdditionalCaches(EmbeddedCacheManager cacheManager, String resourcePath) throws IOException {
//        ClassPathResource resource = new ClassPathResource(resourcePath);
//        ConfigurationBuilderHolder holder = new ParserRegistry().parse(resource.getURL());
//
//        holder.getNamedConfigurationBuilders().forEach((name, builder) -> {
//            if (!cacheManager.cacheExists(name)) {
//                cacheManager.defineConfiguration(name, builder.build());
//            }
//        });
//    }
	
}
