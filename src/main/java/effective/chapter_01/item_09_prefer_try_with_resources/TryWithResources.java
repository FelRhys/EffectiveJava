package effective.chapter_01.item_09_prefer_try_with_resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TryWithResources {

    private static final int BUFFER_SIZE = 8 * 1024;

    static String firstLineOfFile_bad(String path)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
            return br.readLine();
        }finally{
            br.close();
        }
    }

    // try-with-resources - the the best way to close resources!  (Page 35)
    static String firstLineOfFile_good(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    // try-with-resources with a catch clause  (Page 36)
    static String firstLineOfFile_even_better(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    // try-finally is ugly when used with more than one resource! (Page 34)
    static void copy_bad(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try-with-resources on multiple resources - short and sweet (Page 35)
    static void copy_good(String src, String dst) throws IOException {
        try (InputStream   in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }
}
