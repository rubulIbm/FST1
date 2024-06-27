package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
    public static void main(String args[]){
       Map<Integer,String> colours=new HashMap<>();
        colours.put(1,"Red");
        colours.put(2,"Green");
        colours.put(3,"Yellow");
        colours.put(4,"Blue");
        colours.put(5,"Pink");

        System.out.println("Map of Colours: "+colours);
        System.out.println("Removing Red colour from colours map: "+colours.remove(1,"Red"));
        System.out.println("Verify that Green colour is present: "+colours.containsValue("Green"));
        System.out.println("Size of Map: "+colours.size());

    }
}
