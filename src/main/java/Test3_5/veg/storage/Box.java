package Test3_5.veg.storage;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Box<Type> {
    private List<Type> harvest = new ArrayList<>();

/*    public void put(Object thing){
        harvest.add(thing);
    }*/

    public void put(Type thing){
        harvest.add(thing);
    }

    public List<Type> getThing(){
        return harvest;
    }

}
