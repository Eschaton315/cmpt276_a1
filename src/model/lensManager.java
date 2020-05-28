package model;

import java.util.ArrayList;
import  java.util.Iterator;
import java.util.List;

public class lensManager implements  Iterable<lens>{
    private List<lens> lens = new ArrayList<>();

     public void add(lens Lens){
      lens.add(Lens);
    }


    @Override
    public Iterator<model.lens> iterator() {
        return lens.iterator();
    }
}
