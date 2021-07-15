package com.company.자료구조;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// 실습 2-1번
        System.out.println("실습 2-1");
        ArrayList test = new ArrayList();
        for (int i = 0; i <20; i++){
            Random rand = new Random();
            test.add((Integer) rand.nextInt(100));
        }

        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if ((Integer) o1 < (Integer) o2){
                    return -1;
                }else if ((Integer) o1 == (Integer) o2){
                    return 0;
                }else
                    return 1;
            }
        };

        System.out.println("정렬 전");
        System.out.println(test);

        System.out.println("정렬 후");
        MyMergeSort sort = new MyMergeSort(comp);
        System.out.println(sort.sort(test));

    //실습 2-2
        System.out.println("실습 2-2");
        String text = "In computer science, a data structure is a data organization, management, and storage " +
                "format that enables efficient access and modification. More precisely, a data structure is a " +
                "collection of data values, the relationships among them, and the functions or operations " +
                "that can be applied to the data.";

        text = text.replaceAll(",","");
        text = text.replace(".", "");
        text = text.toLowerCase(Locale.ROOT);

        String[] textchar = text.split(" ");

        ArrayList stringsort = new ArrayList();

        for (int i =0; i<textchar.length; i++){
            stringsort.add(textchar[i]);
        }
        System.out.println("정렬 전");
        System.out.println(stringsort);

        Comparator stringcomp = new Comparator() {

            public int compare(Object o1, Object o2) {
                o1 = (String) o1;
                char [] item1 = new char[((String) o1).length()];
                o2 = (String) o2;
                char [] item2 = new char[((String) o2).length()];

                item1 = ((String) o1).toCharArray();
                item2 = ((String) o2).toCharArray();

                int i = 0;
                int j = 0;

                while(i < item1.length && j < item2.length){
                    if((int) item1[i] < (int) item2[j]){
                        return -1;
                    }else if ((int) item1[i] == (int) item2[j]){
                        i++;
                        j++;
                    }else{
                        return 1;
                    }
                }
                if (item1.length <= item2.length){
                    return -1;
                }else{
                    return 1;
                }
            }
        };

        sort.setComparator(stringcomp);
        System.out.println("정렬 후");
        System.out.println(sort.sort(stringsort));

        char temp = 'I';
        char temp2 = 'a';
        System.out.println((int) temp);
        System.out.println((int) temp2);
    }
}
