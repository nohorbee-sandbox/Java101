package codility;

import java.util.*;

/**
 * Created by Nohorbee on 8/29/16.
 */
public class FirstUniqueChar {

    public static void solution1(String word) {

        word = word.toUpperCase();

        for(int i=0;i<word.length();i++) {
            if(word.indexOf(word.charAt(i),i+1)==-1) {
                System.out.println(word.charAt(i));
                break;
            }
        }
    }

    public static void solution2(String word) {
        word = word.toLowerCase();
        List<String> repeated = new ArrayList<>();
        List<String> notrepeated = new ArrayList<>();

        for(char c : word.toCharArray()) {
            if (!repeated.contains(String.valueOf(c))) {
                if(notrepeated.contains(String.valueOf(c))) {
                    notrepeated.remove(String.valueOf(c));
                    repeated.add(String.valueOf(c));
                } else {
                    notrepeated.add(String.valueOf(c));
                }
            }

        }

        if(notrepeated.size()>0) {
            System.out.println(notrepeated.get(0));
        }


    }


    public static void main(String...args) {
        solution1("elEmEntum");
        solution2("elementum");
    }

}
