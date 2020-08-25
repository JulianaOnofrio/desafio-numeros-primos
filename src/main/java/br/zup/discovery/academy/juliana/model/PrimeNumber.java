package br.zup.discovery.academy.juliana.model;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;

public class PrimeNumber {
    public static void main(String[] args) {
        List<Integer> primeList = PrimeNumber.primeListGenerate(1000);
        System.out.println(primeList);

        List<Integer> evenPrimeList = PrimeNumber.evenPrimeListGenerate(primeList);
        System.out.println(evenPrimeList);
    }

    public static List<Integer> primeListGenerate(int size) {
        List<Integer> set = new ArrayList();
        return Stream.iterate(0, i -> ++i).limit(size)
                .filter(i -> new BigInteger(Integer.toString(i)).isProbablePrime(1))
                .filter(i -> set.add(i))
                .collect(toList());
    }

    public static List<Integer> evenPrimeListGenerate(List<Integer> list){
        return list.stream()
                .filter(i -> i%2==0)
                .collect(Collectors.toList());
    }
}
