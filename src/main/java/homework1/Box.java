package homework1;

import java.util.ArrayList;


public class Box<T extends Fruit> {

    ArrayList<T> volume = new ArrayList<>();

    public boolean compare(Box<Orange> b) {
        return getWeight() == b.getWeight();
    }

    public void add(T f) {
        volume.add(f);
    }

    public int size() {
        return volume.size();
    }

    public float getWeight() {
        float totalWeight = 0;
        for (T f : volume) {
            totalWeight += f.getWeight();
        }
        return totalWeight;
    }

    public void transferGoods(Box<T> b) {
        for (T fruit : volume) {
            b.add(fruit);
        }
        volume.clear();
    }
}
