package com.test;

public class NameFormatter {
    private static  String[] names = new String[3];
    public String[] formatName(String fullName) {

        int indexForSpace = findSpace(fullName);
        names[0] = fullName.substring(0,indexForSpace); // First name
        names[1]=" ";
        names[2] = fullName.substring(indexForSpace + 1); // Last name
        return names;
    }
    /// following code will give exception if user will not enter space between first anf last name
    private static int findSpace(String fullName) {
        for (int i = 0; i < fullName.length(); i++)
        {
            if (fullName.charAt(i) == ' ' )
                return i;
        }
        return -1;
    }
}





