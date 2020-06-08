package classes;

import java.util.Scanner;

public class Input {


    public Integer tamBuffer(){
        System.out.print("Tamanio de buffer:");
        Scanner tamInput = new Scanner(System.in);
        String tamInString = tamInput.next();
        Integer tamanio = Integer.parseInt(tamInString);

        return tamanio;
    }

    public Integer amountOfLatinWorkers(){
        System.out.print("Cantidad de LatinWorkers:");
        Scanner latinWorkers = new Scanner(System.in);
        String latinString = latinWorkers.next();
        Integer latin = Integer.parseInt(latinString);

        return latin;
    }
}
