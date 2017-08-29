package com.lq.plat.link.controller;

import java.util.Date;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行流：计算密集性
 * @author 李强
 * @version 1.0.0
 * @date 2017/8/21
 */
public class ParallelStreamDemo {

    //并行求和
    //装箱，开箱
    public static long parallelSum(long n){
        return LongStream.rangeClosed(0, n)
                .parallel() // 并行
                .reduce(0L,Long::sum);
    }

    //顺行流
    public static long sequenceSum(long n){
        return LongStream.rangeClosed(0, n)

                .reduce(0L,Long::sum);
    }

    public static long wrongSum(long n){
        Counter counter = new Counter();
        LongStream.rangeClosed(0,n).parallel().forEach(counter::add);
        return counter.total;
    }

    //老方法：循环
    public static long iterativeSum(long n){
        long result = 0;
        for(int i=1;i<=n;i++){
            result =+ i;
        }
        return result;
    }

    public static long test(Function<Long ,Long> computer,long n){
            long fastest = Long.MAX_VALUE;
            for (int i=0;i<10;i++){
                long start = System.currentTimeMillis();
                computer.apply(n);
                long cost = System.currentTimeMillis() - start;
                if(cost < fastest){
                    fastest = cost;
                }
            }
            return fastest;
    }


    public static void main(String[] args) {
        //long now =new Date().getTime();

        //System.out.println(parallelSum(20000000));
        //System.out.println(new Date().getTime() - now);
        long n=20_000_000;
        System.out.println("顺行流："+test(ParallelStreamDemo::sequenceSum,n));
        System.out.println("并行流："+test(ParallelStreamDemo::parallelSum,n));
        System.out.println("迭代："+test(ParallelStreamDemo::iterativeSum,n));

    }
}
