package com.company.자료구조;


public class Main {
    public static void main(String[] args) {
        //실습1
        MyHashTable myHashTable = new MyHashTable(13);
        myHashTable.put("201710704","변세훈"); // hash code : 0
        myHashTable.put("201710705","김세훈");// hash code : 1
        myHashTable.put("201710706","박세훈");// hash code : 2
        myHashTable.put("201710707","정세훈");// hash code : 3
        myHashTable.put("201710708","오세훈");// hash code : 4
        myHashTable.put("201710709","이세훈");// hash code : 5
        myHashTable.put("201710710","판세훈");// hash code : 9
        myHashTable.put("201710711","목세훈");// hash code : 10
        myHashTable.put("201710718","전세훈");// hash code : 4
        myHashTable.put("201710713","유세훈");// hash code : 12

        //실습2
        MyHashTable myHashTable2 = new MyHashTable(13,0.9f);
        myHashTable2.put("201710704","변세훈"); // hash code : 0
        myHashTable2.put("201710705","김세훈");// hash code : 1
        myHashTable2.put("201710706","박세훈");// hash code : 2
        myHashTable2.put("201710707","정세훈");// hash code : 3
        myHashTable2.put("201710708","오세훈");// hash code : 4
        myHashTable2.put("201710709","이세훈");// hash code : 5
        myHashTable2.put("201710710","판세훈");// hash code : 9
        myHashTable2.put("201710711","목세훈");// hash code : 10
        myHashTable2.put("201710718","전세훈");// hash code : 4
        myHashTable2.put("201710713","유세훈");// hash code : 12
        myHashTable2.put("201710714","가세훈");// hash code : 0
        System.out.println("loadfactor :" + myHashTable2.updateLF());
        myHashTable2.put("201710715","문세훈");// hash code : 1
        myHashTable2.put("201710716","추세훈");// hash code : 2
        myHashTable2.put("201710717","조세훈");// hash code : 3
        myHashTable2.put("201710719","하세훈");// hash code : 5
        System.out.println("rehashing 발생 후 :" + myHashTable2.updateLF());


    }
}
