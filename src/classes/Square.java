package classes;

import java.util.*;

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

    public Integer elementsPerRow() {
        return numbers.length / size;
    }

    public boolean isLatinSquare() {
        return this.hasValidNumbers() && !this.repeatsNumbersInColumn() && !this.repeatsNumbersInRow();
    }

    public boolean hasValidNumbers() {
        return Arrays.stream(numbers).allMatch(number -> size >= number);
    }

    public boolean repeatsNumbersInRow() {
        boolean res = false;
        for (int i = 0; i < numbers.length; i += elementsPerRow()) {
            List<Integer> elementsOfCurrentRow = new ArrayList<>();
            for (int j = i * elementsPerRow(); j < i + elementsPerRow(); j++) {
                elementsOfCurrentRow.add(numbers[j]);
            }
            Set<Integer> setOfCurrentRow = new HashSet<>(elementsOfCurrentRow);
            res = elementsOfCurrentRow.size() != setOfCurrentRow.size();
            if (res) {
                break;
            }
        }
        return res;
    }

    public boolean repeatsNumbersInColumn() {
        boolean res = false;
        for (int i = 0; i < elementsPerRow(); i++) {
            List<Integer> elementsOfCurrentColumn = new ArrayList<>();
            for (int j = i; j < numbers.length; j += elementsPerRow()) {
                elementsOfCurrentColumn.add(numbers[j]);
            }
            Set<Integer> setOfCurrentRow = new HashSet<>(elementsOfCurrentColumn);
            res = elementsOfCurrentColumn.size() != setOfCurrentRow.size();
            if (res) {
                break;
            }
        }
        return res;
    }
}
