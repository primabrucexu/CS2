package cn.pbx.cs2.util;

/**
 * @author BruceXu
 */
public class Random {

    private static final String DIGITS = "0123456789";
    private static final String ASCII_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String ASCII_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String TEMPLATE = DIGITS + ASCII_UPPERCASE + ASCII_LOWERCASE;

    private final java.util.Random random;

    private Random(int seed) {
        this.random = new java.util.Random(seed);
    }

    public static Random getInstance(int seed) {
        return new Random(seed);
    }

    public String get(int length) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            sb.append(TEMPLATE.charAt(random.nextInt(length)));
        }
        return sb.toString();
    }
}
