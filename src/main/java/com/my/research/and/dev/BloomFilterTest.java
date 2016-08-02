package com.my.research.and.dev;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.Random;

public class BloomFilterTest {

    public static void main(String[] args) {

        final Random random = new Random();

        final BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000);
        bloomFilter.put(0);
        bloomFilter.put(999);
        for (int i = 0; i < 1000; i++) {
            bloomFilter.put(random.nextInt(1000));
        }

        System.out.println(bloomFilter.mightContain(1));
        System.out.println(bloomFilter.mightContain(10));
        System.out.println(bloomFilter.mightContain(100));
        System.out.println(bloomFilter.mightContain(999));
        System.out.println(bloomFilter.mightContain(1000));
    }
}
