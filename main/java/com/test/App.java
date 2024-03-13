package com.test;
import java.util.Arrays;
import java.util.Scanner;



public class App
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of names you want to store: ");
        int numOfNames = scanner.nextInt();
        scanner.nextLine();

        NameFormatter nameFormatter = new NameFormatter();
        String[] formatedOfName = new String[numOfNames];
        // Reading names from the user
        //System.out.print("Enter names separated by commas: ");
        String namesListOFUser = scanner.nextLine();


        for (int i = 0; i < numOfNames; i++)
        {
            System.out.print("Enter name " + (i + 1) + ": ");
            String fullName = scanner.nextLine();
            formatedOfName[i] = Arrays.toString(nameFormatter.formatName(fullName));
            formatedOfName[i]=formatedOfName[i].trim();
        }

        System.out.println("\nStored formatted names:");
        for (String name : formatedOfName) {
            System.out.println(name);
        }


        // Splitting the input string into an array of names
       // String[] initialNames = namesListOFUser.split(",");

        // Trim each name to remove leading and trailing whitespaces
       // for (int i = 0; i < initialNames.length; i++)
        //{
          //  initialNames[i] = initialNames[i].trim();
        //}



        NameRepository.setNames(formatedOfName);

        System.out.println("Number of names: " + NameRepository.getSize());

        displyNames();

        // Getting name to find from the user
        System.out.print("Enter a name to find: ");
        String nameToFind = scanner.nextLine();
        /////// conver the user input according to the defined formate [firstname, ,lastname]
        nameToFind=Arrays.toString(nameFormatter.formatName(nameToFind));
        String foundName = NameRepository.find(nameToFind);
        if (foundName != null) {
            System.out.println("Name found: " + foundName);
        } else {
            System.out.println("Name not found: " + nameToFind);
        }

        // Getting name to add from the user
        System.out.print("Enter a name to add: ");
        String nameToAdd = scanner.nextLine();
        nameToAdd=Arrays.toString(nameFormatter.formatName(nameToAdd));

        boolean added = NameRepository.add(nameToAdd);
        if (added) {
            System.out.println("Name added successfully: " + nameToAdd);
            System.out.println("After adding list is below:");
            displyNames();
        } else {
            System.out.println("Name already exists: " + nameToAdd);
            displyNames();
        }

        NameRepository.clear();
        System.out.println("After clearing, number of names: " + NameRepository.getSize());



    }
    public static void displyNames()
    {
        System.out.println("All names:");
        String[] allNames = NameRepository.findAll();
        for (int i = 0; i < allNames.length; i++) {
            System.out.println(allNames[i]);
        }
    }

}
