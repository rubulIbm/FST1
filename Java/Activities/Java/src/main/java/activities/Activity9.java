package activities;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Activity9 {
    public static void main(String args[]){
        List<String> myList=new ArrayList<>();
        myList.add("India");
        myList.add("china");
        myList.add("nepal");
        myList.add("paris");
        myList.add("france");
        for(int i=0;i<myList.size();i++){
            System.out.println("All the Elememts in Arraylist are : "+myList.get(i));
        }
        System.out.println("3rd element in the arraylist is : "+myList.get(3));
        System.out.println("Arraylist contains India is : "+myList.contains("India"));
        System.out.println("Size of ArrayList : "+myList.size());
        System.out.println("Remove the name China from Arraylist: "+myList.remove("china"));
        System.out.println("Size of ArrayList after removing one name : "+myList.size());
    }
    public void add(List<String>myList){
        myList.add("India");
        myList.add("china");
        myList.add("nepal");
        myList.add("paris");
        myList.add("france");
        for(int i=0;i<myList.size();i++){
            System.out.println("All the Elememts in Arraylist are : "+myList.get(i));
        }

    }
}
