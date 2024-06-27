package activities;

import java.util.HashSet;


public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");


        System.out.println("Size of Hashset is : "+hs.size());
        System.out.println("Remove Element from hashset: "+hs.remove("B"));
        System.out.println("Remove an element K Which is not in the list of Hashset: "+hs.remove("K"));
        System.out.println("Verify the element present in the List of Hashset: "+hs.contains("F"));
        System.out.println("Updated set is :"+hs);


    }
}
