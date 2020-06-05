package classes;

import java.util.Arrays;

public class Square {

    public final Integer size;
    public final Integer[] numbers;

    public Square(String line) {
        String[] contents = line.split(" ");
        this.size = Integer.parseInt(contents[0]);
        String[] members = Arrays.copyOfRange(contents, 1, contents.length);
        this.numbers = new Integer[members.length];
        for (int i = 0; i < members.length; i++) {
            this.numbers[i] = Integer.parseInt(members[i]);
        }
    }
}
