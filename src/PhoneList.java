import java.util.*;
import java.io.*;

public class PhoneList {
    public static void main(String[] args) throws FileNotFoundException {



        Scanner input = new Scanner(System.in);
        Scanner scanP = new Scanner(new File("PhoneNumbers.txt"));
        Scanner scanN = new Scanner(new File("StudentNames.txt"));
        int[] phoneNum = new int[10];
        String[] studName = new String[10];

        getNameArray(studName,phoneNum,scanP,scanN);

        printList(studName,phoneNum);
        System.out.println("Do you want to make changes in the list?");




        while (true){


            System.out.println("Type: \n 1 to add a student \n 2 to delete a student \n 3 to see the list \n 4 to exit " );
            System.out.println();

            int answer = input.nextInt();


            switch(answer)  {
                case 1:
                    addStudent(studName,phoneNum);
                    break;
                case 2:
                    deleteStudent(studName,phoneNum);
                    break;
                case 3:
                    printList(studName,phoneNum);
                    break;
                case 4:
                    System.out.println("Goodbye");
                    return;


                default:
                    System.out.println("Invalid input, try again");
                    break;

            }
        }







    }

    public static void addStudent(String[] names, int[] numbers) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type name: ");
        String name = scan.next();
        System.out.println("Type phone number: ");
        int num = scan.nextInt();
        for (int i = 0; i < numbers.length; i++)  {
            if (numbers[i] == 0)  {
                numbers[i] = num;
                names[i] = name;
                return;
            }

        }

    }


    public static void deleteStudent(String[] names, int[] numbers)  {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type number: ");
        int num = scan.nextInt();
        for ( int i = 0; i < numbers.length; i++) {
            if(numbers[i] == num)  {
                numbers[i] = 0;
                names[i] = "nn";
            }
        }


    }


    public static void printList(String[] names, int[] numbers) {
        System.out.println("~ Student phone list ~");
        System.out.println();
        for (int i = 0; i<names.length; i++){
            System.out.printf("Name:  %-10s \nPhone: %-8d\n",names[i],numbers[i]);
            System.out.println();
        }


    }










    public static void getNameArray(String[] names, int[] numbers, Scanner scanP, Scanner scanN) throws FileNotFoundException {
        int i = 0;
        int j = 0;

        while(scanN.hasNext()){
            names[i] = scanN.next();

            i++;
        }

        while(scanP.hasNext()){
            numbers[j] = scanP.nextInt();
            j++;
        }




    }

}