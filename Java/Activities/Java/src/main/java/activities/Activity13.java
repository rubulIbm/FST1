package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
public static void main(String[] args){
    Scanner scan=new Scanner(System.in);
    ArrayList<Integer> List=new ArrayList<>();
    Random indexGen=new Random();
    System.out.println("Enter integer numbers ");
    System.out.println("Non interger numbers to terminate");

    while(scan.hasNextInt()){
        List.add(scan.nextInt());
    }

    Integer nums[] = List.toArray(new Integer[0]);
    int index = indexGen.nextInt(nums.length);
    System.out.println("Index value generated: " + index);
    System.out.println("Value in arary at generated index: " + nums[index]);

    scan.close();

}
}
