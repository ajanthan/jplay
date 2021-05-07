package com.github.ajanthan.collections;

import java.util.*;

public class SecuritySystem {
    public List<Set<String>> getViolator(String[][] in) {
        Map<String, String> tracker = new HashMap<>();
        Set<String> entryViolators = new HashSet<>();
        Set<String> exitViolators = new HashSet<>();


        for (String[] entry : in) {
            if (tracker.containsKey(entry[0])) {
                String tp = tracker.get(entry[0]);
                if (entry[1] == "enter") {
                    if ("enter".equals(tp)) {
                        exitViolators.add(entry[0]);
                    } else {//exit entry

                    }
                } else {//exit
                    if ("enter".equals(tp)) {
                        tracker.remove(entry[0]);
                    } else {
                        //exit

                    }
                }

            } else {
                if (entry[1] == "enter") {
                    tracker.put(entry[0], "enter");
                } else {//exit
                    entryViolators.add(entry[0]);
                }

            }
        }

        exitViolators.addAll(tracker.keySet());
        List<Set<String>> rt = new ArrayList<Set<String>>();
        rt.add(entryViolators);
        rt.add(exitViolators);
        return rt;
    }

    public static void main(String[] args) {
        SecuritySystem securitySystem = new SecuritySystem();
        String[][] rec01 = {
            { "Paul", "enter" },
            { "Paul", "enter" },
            { "Paul", "exit" },
            { "Paul", "exit" } };
        String[][] rec02 = {
            { "Paul", "enter" },
            { "Paul", "exit" },
            { "Paul", "exit" },
            { "Paul", "enter" }, };
        String[][] rec03 = {
            { "Paul", "enter" },
            { "Paul", "exit" } };
        System.out.println(securitySystem.getViolator(rec01));
        System.out.println(securitySystem.getViolator(rec02));
        System.out.println(securitySystem.getViolator(rec03));
    }
}
