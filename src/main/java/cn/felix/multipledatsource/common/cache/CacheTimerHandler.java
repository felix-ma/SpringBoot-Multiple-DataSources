package cn.felix.multipledatsource.common.cache;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 描述：
 *  缓存操作类，清除方式采用Timer定时的方式
 * @author potter
 * @create 2018-06-13 18:15
 */
public class CacheTimerHandler {

    private static final long SECOND_TIME = 1000;//默认过期时间 20秒

    private static final int DEFUALT_EXPIRE_TIME = 20;//默认过期时间 20秒

    private static final Timer timer ;

    private static final SimpleConcurrentMap<String, CacheEntity> map;

    static{
        timer = new Timer();
        map = new SimpleConcurrentMap<String, CacheEntity>(new HashMap<String, CacheEntity>(1<<18));
    }

    public static void addCache(String key, CacheEntity ce){
        addCache(key, ce, DEFUALT_EXPIRE_TIME);
    }

    public static synchronized void addCache(String key, CacheEntity ce, int expireTime){
        map.put(key, ce);
        //添加过期定时
        timer.schedule(new TimeoutTimerTask(key), expireTime * SECOND_TIME);
    }


    public static synchronized CacheEntity getCache(String key){
        return map.get(key);
    }

    public static synchronized boolean isConcurrent(String key){
        return map.containsKey(key);
    }

    public static synchronized void removeCache(String key){
        map.remove(key);
    }

    public static int getCacheSize(){
        return map.size();
    }

    public static synchronized void clearCache(){
        if(null != timer){
            timer.cancel();
        }
        map.clear();
        System.out.println("clear cache");
    }

    static class TimeoutTimerTask extends TimerTask {
        private String ceKey ;

        public TimeoutTimerTask(String key){
            this.ceKey = key;
        }

        @Override
        public void run() {
            CacheTimerHandler.removeCache(ceKey);
            System.out.println("remove : "+ceKey);
        }
    }

}
