package activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;


    Car(){
        tyres = 4;
        doors = 4;

    }
    public void displayCharacterstics(){
        System.out.println("Colour of Car is: "+color);
        System.out.println("transmission of Car is: "+transmission);
        System.out.println("make of Car is: "+make);
        System.out.println("tyres of Car is: "+tyres);
        System.out.println("doors of Car is: "+doors);
    }

    public void accelarate(){
        System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }
}

