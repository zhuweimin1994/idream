package com.idream.userservice.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisConfig
 * @Auther: zhangyingqi
 * @Date: 2018/8/28 11:07
 * @Description:
 */
@Configuration
@Component
public class RedisConfig {

//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.port}")
//    private Integer port;
//
//    @Value("${spring.redis.database}")
//    private Integer database;
//    @Value("${spring.redis.timeout}")
//    private Integer timeout;

    @Autowired
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 17:52 2018/8/28
     * @param: []
     * @return: org.springframework.data.redis.connection.jedis.JedisConnectionFactory
     * @Description: Jedis配置
     */
//    @Bean
//    public JedisConnectionFactory JedisConnectionFactory(){
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
//        redisStandaloneConfiguration.setHostName(host);
//        redisStandaloneConfiguration.setPort(port);
//        //由于我们使用了动态配置库,所以此处省略
//        redisStandaloneConfiguration.setDatabase(database);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
//        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
//        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
//                jedisClientConfiguration.build());
//        return factory;
//    }

    /**
     * @auther: zhangyingqi
     * @date: 17:52 2018/8/28
     * @param: [redisConnectionFactory]
     * @return: com.springboot.demo.base.utils.RedisTemplate
     * @Description: 实例化 RedisTemplate 对象
     */
    @Bean
    public RedisTemplate functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
        redisUtil.setRedisTemplate(redisTemplate);
        return redisTemplate;
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:52 2018/8/28
     * @param: []
     * @return: org.springframework.data.redis.serializer.RedisSerializer
     * @Description: 引入自定义序列化
     */
//    @Bean
//    public RedisSerializer fastJson2JsonRedisSerializer() {
//        return new FastJson2JsonRedisSerializer<Object>(Object.class);
//    }

    /**
     * @auther: zhangyingqi
     * @date: 17:51 2018/8/28
     * @param: [redisTemplate, model]
     * @return: void
     * @Description: 设置数据存入 redis 的序列化方式,并开启事务
     */
    private void initDomainRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
       // redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
        // 开启事务
//        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * @auther: zhangyingqi
     * @date: 17:51 2018/8/28
     * @param: [redisTemplate]
     * @return: com.springboot.demo.base.utils.RedisUtil
     * @Description: 注入封装RedisTemplate
     */
//    public RedisUtil redisUtil(RedisTemplate redisTemplate) {
//        redisUtil.setRedisTemplate(redisTemplate);
//        return redisUtil;
//    }
}