package com.company.자료구조;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyMergeSort {
    private ArrayList list1;
    private ArrayList list2;
    private Comparator comp;

    public MyMergeSort(Comparator comp) {
        this.comp = comp;
        }

    public ArrayList sort(ArrayList a){
        if (a.size() < 2){
            return null;
        }

        ArrayList temp = new ArrayList();
        this.list1 = new ArrayList(a);
        this.list2 = new ArrayList();
        for (int size = 0; size<a.size(); size++){
            list2.add(null);
        }

        for (int i = 1; i<a.size(); i = 2*i){
            for (int j = 0; j < a.size(); j += 2*i){
                merge(list1, list2, j,i);
            }
            temp = list1;
            list1 = list2;
            list2 = temp;
        }
        if (a != list1){
            a = new ArrayList(list1);
        }
        return a;
    }

    private void merge(ArrayList from, ArrayList to, int start, int step){
        int end1 = Math.min(start + step, from.size());
        int end2 = Math.min(start + 2*step, from.size());
        int x = start;
        int y = start + step;
        int z = start;
        while(x < end1 && y < end2){
            if (this.comp.compare(from.get(x), from.get(y)) <= 0){
                to.set(z++,from.get(x++));

            }else{
                to.set(z++,from.get(y++));
            }
        }
        if (x < end1) {
            while(x < end1){
                to.set(z++,from.get(x++));
            }
        } else if (y < end2) {
            while(y < end2){
                to.set(z++,from.get(y++));
            }
        }
    }

    public Comparator setComparator(Comparator c){
        this.comp = c;
        return comp;
    }

}
