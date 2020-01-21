package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    private static Pattern addition = Pattern.compile("what is (\\d+) plus (\\d+)");
    private static Pattern largest = Pattern.compile("which of the following number is the largest: (\\d+), (\\d+)");

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
        m = largest.matcher(query);
        if (m.matches()) {
            return String.valueOf(Integer.max(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2))));
        }
        return "";
    }
}
