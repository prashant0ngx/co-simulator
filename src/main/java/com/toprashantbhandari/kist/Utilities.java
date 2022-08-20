package com.toprashantbhandari.kist;

import java.util.Collection;


/**
 * Class containing general methods.
 */
public class Utilities {
    /**
     * Empty private constructor to block instantiation.
     */
    private Utilities() {
    }

    /**
     * @param value  Integer to convert to a hexadecimal {@link String}.
     * @param digits Integer number of hexadecimal digits the hexadecimal {@link String} should contain.
     * @return {@link String} which is the {@code digits} long hexadecimal representation of {@code value}.
     */

    public static String hex(int value, int digits) {
       String c= padLeft(Integer.toHexString(value), '0', digits).toUpperCase();
       return c;
    }
    public static String bin( int value, int digits){
        String c= padLeft(Integer.toBinaryString(value), '0', digits).toUpperCase();

        return c;
    }

    public static String dec(int value, int digits){
        String hex=Integer.toHexString(value);
        String digit = "0123456789ABCDEF";
        hex = hex.toUpperCase();
        int val = 0;
        for (int i = 0; i < hex.length(); i++)
        {
            char c = hex.charAt(i);
            int d = digit.indexOf(c);
            val = 16*val + d;
        }
        String d= padLeft(Integer.toString(val), '0', digits).toUpperCase();
        return d;
    }

    /**
     * @param text   {@link String} text to pad with characters from the left.
     * @param c      Character to pad {@code text} with from the left.
     * @param length Integer length the resulting padded {@link String} should be.
     * @return {@code text} padded with {@code c} characters from the left such that its length is {@code length}.
     */
    public static String padLeft(String text, char c, int length) {
        StringBuilder builder = new StringBuilder();

        // Loops to padLeft the given text with characters from the left if it is less than the desired length
        while (builder.length() + text.length() < length) {
            builder.append(c);
        }

        builder.append(text);

        return builder.toString();
    }
    public static String padLeft(int text, char c, int length) {
        StringBuilder builder = new StringBuilder();

        // Loops to padLeft the given text with characters from the left if it is less than the desired length
        while (builder.length() + text < length) {
            builder.append(c);
        }

        builder.append(text);

        return builder.toString();
    }

    /**
     * @param collections {@link Collection} of {@code T} instances to union.
     * @param <T>         Type of {@link Collection} instances which will be unioned.
     * @param <U>         Type of instance which the {@code T} instances contain.
     * @return {@code T} at the first index of {@code collections} and which now contains the contents of all the other {@code T} instances in {@code collections}.
     */
    public static <T extends Collection<U>, U> T union(Collection<T> collections) {
        return collections.stream().reduce((collection1, collection2) -> {
            collection1.addAll(collection2);
            return collection1;
        }).orElse(null);
    }
}
