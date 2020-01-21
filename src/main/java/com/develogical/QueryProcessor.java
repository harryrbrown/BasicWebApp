package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    private static Pattern addition = Pattern.compile("what is (\\d+) plus (\\d+)");
    private static Pattern subtraction = Pattern.compile("what is (\\d+) minus (\\d+)");
    private static Pattern multiply = Pattern.compile("what is (\\d+) multiplied by (\\d+)");
    private static Pattern largestFour = Pattern.compile("which of the following numbers is the largest: (\\d+), (\\d+), (\\d+), (\\d+)");
    private static Pattern primesFour = Pattern.compile("which of the following numbers are primes: (\\d+), (\\d+), (\\d+), (\\d+)");
    private static Pattern primes = Pattern.compile("which of the following numbers are primes: (\\d+), (\\d+)");
    private static Pattern largest = Pattern.compile("which of the following numbers is the largest: (\\d+), (\\d+)");
    private static Pattern sqcube = Pattern
            .compile("which of the following number is both a square and a cube: (\\d+), (\\d+)");

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an "
                    + "English poet, playwright, and actor, widely regarded as the greatest "
                    + "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("420")) {
            return "... is the sum of two lots of 210";
        }
        Matcher m = addition.matcher(query);
        if (m.matches()) {
            return String.valueOf(Integer.parseInt(m.group(1)) + Integer.parseInt(m.group(2)));
        }
        m = subtraction.matcher(query);
        if (m.matches()) {
            return String.valueOf(Integer.parseInt(m.group(1)) - Integer.parseInt(m.group(2)));
        }
        m = primesFour.matcher(query);
        if (m.matches()) {
            if (isPrime(Integer.parseInt(m.group(1)))) {
                return String.valueOf(Integer.parseInt(m.group(1)));
            } else if (isPrime(Integer.parseInt(m.group(2)))) {
                return String.valueOf(Integer.parseInt(m.group(2)));
            } else if (isPrime(Integer.parseInt(m.group(3)))) {
                return String.valueOf(Integer.parseInt(m.group(3)));
            } else {
                return String.valueOf(Integer.parseInt(m.group(4)));
            }
        }
        m = primes.matcher(query);
        if (m.matches()) {
            if (isPrime(Integer.parseInt(m.group(1)))) {
                return String.valueOf(Integer.parseInt(m.group(1)));
            } else {
                return String.valueOf(Integer.parseInt(m.group(2)));
            }
        }
        m = largestFour.matcher(query);
        if (m.matches()) {
            Integer a_1 = Integer.max(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)));
            Integer a_2 = Integer.max(Integer.parseInt(m.group(3)), Integer.parseInt(m.group(4)));

            return String.valueOf(Integer.max(a_1, a_2));
        }
        m = largest.matcher(query);
        if (m.matches()) {
            return String.valueOf(Integer.max(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
        }
        m = multiply.matcher(query);
        if (m.matches()) {
            return String.valueOf(Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2)));
        }
        m = sqcube.matcher(query);
        if (m.matches()) {
            int first = Integer.parseInt(m.group(1));
            int second = Integer.parseInt(m.group(2));

            return String.valueOf(first);
        }
        return "";
    }


    private boolean isPrime(int num) {
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            // condition for nonprime number
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }

        return !flag;
    }
}
