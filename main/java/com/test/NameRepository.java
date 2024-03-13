package com.test;
import java.util.Arrays;
public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize() {
        return names.length;
    }

    public static void setNames(String[] newNames) {
        names = Arrays.copyOf(newNames, newNames.length);
    }

    public static void clear() {
        names = new String[0];
    }
    public static String[] findAll() {
        return Arrays.copyOf(names, names.length);
    }
    public static String find(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                return names[i];
            }
        }
        return null;
    }
    public static boolean add(final String fullName) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                return false;
            }
        }
        // Extend array and add the new name
        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        return true;
    }
}
