package classes;

import java.util.Scanner;

public class Input {


    public Integer tamBuffer() {
        System.out.print("Tamanio de buffer:");
        String tamInput = this.scanner().next();
        try {
            Integer tamanio = Integer.parseInt(tamInput);
            return tamanio;
        } catch (NumberFormatException e) {
            System.out.println("Tiene que ser un numero el input");
            System.exit(0);
        }

        return 0;
    }

    public Integer amountOfLatinWorkers() {
        System.out.print("Cantidad de LatinWorkers:");
        String latinString = this.scanner().next();
        try {
            Integer latin = Integer.parseInt(latinString);
            return latin;
        } catch (NumberFormatException e) {
            System.out.println("Tiene que ser un numero el input");
            System.exit(0);
        }

        return 0;
    }

    private Scanner scanner(){
        return new Scanner(System.in);
    }
}