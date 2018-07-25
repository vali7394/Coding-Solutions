package com.apple.codingTest;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mshaik on 7/16/18.
 */
public class CacheRepo<T> {

  ConcurrentHashMap<String,CacheHolderWithTime> cache = new ConcurrentHashMap<>(16);
  long ttl = 5*60*1000;
  ExecutorService executorService = Executors.newFixedThreadPool(10);

  public Optional<T> get(String elementKey){

  CacheHolderWithTime savedCacheObj = cache.get(elementKey);

 // if(savedCacheObj.getInsertionTime()+ttl <= System.currentTimeMillis() ){
    return  Optional.of((T)savedCacheObj.value);
 // }
 //  return null;
  }


  public void put(String elementKey, T cacheObj){
    if(cacheObj != null) {
      cache.put(elementKey, new CacheHolderWithTime(cacheObj,System.currentTimeMillis()+ttl));
    }

  }

  public void remove(){

    executorService.submit(()->{
      cache.entrySet().stream().forEach(entry->{
        CacheHolderWithTime  cacheHolderWithTime = entry.getValue();
        if(System.currentTimeMillis()>cacheHolderWithTime.getInsertionTime()){
         cache.remove(entry.getKey());
        }
      });
    });



  }





}
