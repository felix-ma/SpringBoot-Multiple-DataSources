package cn.felix.multipledatsource.common.cache;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author potter
 * @create 2018-06-13 18:12
 */
public class CacheEntity implements Serializable {

    private final int DEFUALT_EXPIRE_TIME = 20;//默认过期时间 20秒

    private String cacheKey;

    private Object cacheContext;

    private int expire;//有效期时长，单位：秒

    private long timeoutStamp;//过期时间戳

    private CacheEntity(){
        this.timeoutStamp = System.currentTimeMillis() + DEFUALT_EXPIRE_TIME * 1000;
        this.expire = DEFUALT_EXPIRE_TIME;
    }

    public CacheEntity(String cacheKey, Object cacheContext){
        this();
        this.cacheKey = cacheKey;
        this.cacheContext = cacheContext;
    }

    public CacheEntity(String cacheKey, Object cacheContext, long timeoutStamp){
        this(cacheKey, cacheContext);
        this.timeoutStamp = timeoutStamp;
    }

    public CacheEntity(String cacheKey, Object cacheContext, int expire){
        this(cacheKey, cacheContext);
        this.expire = expire;
        this.timeoutStamp = System.currentTimeMillis() + expire * 1000;
    }

    public String getCacheKey() {
        return cacheKey;
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
    }

    public Object getCacheContext() {
        return cacheContext;
    }

    public void setCacheContext(Object cacheContext) {
        this.cacheContext = cacheContext;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public long getTimeoutStamp() {
        return timeoutStamp;
    }

    public void setTimeoutStamp(long timeoutStamp) {
        this.timeoutStamp = timeoutStamp;
    }
}
