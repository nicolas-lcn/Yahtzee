package model;

import java.util.ArrayList;
import java.util.List;

public class DiceHand {
    private List<Integer> faces = new ArrayList<Integer>();

    public DiceHand(List<Die> dice){
        for (Die die : dice){
            faces.add(die.value());
        }
    }

    public int get(int die){
        return faces.get(die);
    }

    public int sum(){
        int sum =0;
        for (int value : faces){
            sum = sum + value;
        }
        return sum;
    }

    public int count(int faceValue){
        int counter = 0;
        for (int value : faces){
            if (faceValue==value){
                counter+=1;
            }
        }
        return counter;
    }
}
