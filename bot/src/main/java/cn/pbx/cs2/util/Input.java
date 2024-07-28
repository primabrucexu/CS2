package cn.pbx.cs2.util;

import java.util.Scanner;

/**
 * @author BruceXu
 */
public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String get(String msg) {
        System.out.println(msg);
        return SCANNER.nextLine();
    }
}
