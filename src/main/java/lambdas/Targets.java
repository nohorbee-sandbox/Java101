package lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;

/**
 * Created by nherz on 8/15/16.
 */
public class Targets {
    public static void main(String...args){
        File[] files = new File(".").listFiles(getFilter("txt"));
        for (File file: files) {
            System.out.println(file);
        }

        Comparator<String> cmp = (c1,c2)->c1.compareTo(c2);
    }

    static FileFilter getFilter(String ext) {
        return (File pathName)->pathName.toString().endsWith(ext);
    }
}
