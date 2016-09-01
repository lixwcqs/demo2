package com.cqs.demo2.models.json;

import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerTest {  
  
    /** 
     * 常见的方法列表 
     * @see AtomicInteger#get()             直接返回值 
     * @see AtomicInteger#getAndAdd(int)    增加指定的数据，返回变化前的数据 
     * @see AtomicInteger#getAndDecrement() 减少1，返回减少前的数据 
     * @see AtomicInteger#getAndIncrement() 增加1，返回增加前的数据 
     * @see AtomicInteger#getAndSet(int)    设置指定的数据，返回设置前的数据 
     *  
     * @see AtomicInteger#addAndGet(int)    增加指定的数据后返回增加后的数据 
     * @see AtomicInteger#decrementAndGet() 减少1，返回减少后的值 
     * @see AtomicInteger#incrementAndGet() 增加1，返回增加后的值 
     * @see AtomicInteger#lazySet(int)      仅仅当get时才会set 
     *  
     * @see AtomicInteger#compareAndSet(int, int) 尝试新增后对比，若增加成功则返回true否则返回false 
     */  
    public final static AtomicInteger TEST_INTEGER = new AtomicInteger(1);  
      
    public static void main(String []args) throws InterruptedException {  
        final Thread []threads = new Thread[10];  
         for(int i = 0 ; i < 10 ; i++) {  
             final int num = i;  
             threads[i] = new Thread() {  
                 public void run() {  
                     try {  
                        Thread.sleep(1000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                    int now = TEST_INTEGER.addAndGet(2);
                 }
             };  
             threads[i].start();  
         }  
         for(Thread t : threads) {  
             t.join();  
         }  
         System.out.println("最终运行结果：" + TEST_INTEGER.get());  
    }  
}