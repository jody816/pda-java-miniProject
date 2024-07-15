package Bbashyan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String input() throws IOException {
        System.out.print("입력 : ");
        return br.readLine();
    }
}
