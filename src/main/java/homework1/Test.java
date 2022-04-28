package homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(changePlaces(arr1, 2, 5)));
        String[] arr2 = {"Hi", "whatsup", "bye"};
        System.out.println(changeArrayToList(arr2));

        Apple[] apples = {new Apple(), new Apple(), new Apple(), new Apple()};
        Orange[] oranges = {new Orange(), new Orange(), new Orange(), new Orange()};
        Apple apple = new Apple();
        Box<Apple> boxOfApples = new Box<>();
        Box<Orange> boxOfOranges = new Box<>();
        for (Apple f : apples) {
            boxOfApples.add(f);
        }
        for (Orange f : oranges) {
            boxOfOranges.add(f);
        }
        Box<Apple> box = new Box<>();
        boxOfApples.transferGoods(box);
        System.out.println("Box of Apples: " + boxOfApples.size());
        System.out.println("Box: " + box.size());
        box.add(apple);
        System.out.println("Box: " + box.size());
        box.transferGoods(boxOfApples);
        System.out.println("Box of Apples: " + boxOfApples.size());
        System.out.println("Box: " + box.size());
        System.out.println(boxOfApples.getWeight());
        System.out.println(boxOfOranges.getWeight());
        System.out.println(boxOfApples.compare(boxOfOranges));
    }

    public static <T> T[] changePlaces(T[] array, int first, int second) {
        T element = array[first];
        array[first] = array[second];
        array[second] = element;
        return array;
    }

    public static <T> ArrayList<T> changeArrayToList(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}
