package com.company.자료구조;

import java.util.ArrayList;

public class MyHashTable {
    private ArrayList<ArrayList> bucketArray;
    private int bucketCapacity; // 버켓리스트 크기
    private float loadFactor;

    public ArrayList<ArrayList> getBucketArray() {
        return bucketArray;
    }

    public int getBucketCapacity() {
        return bucketCapacity;
    }

    public float getLoadFactor() {
        return (float) loadFactor;
    }

    public MyHashTable(int initialCapacity) {
        this.bucketCapacity = initialCapacity;
        this.bucketArray = new ArrayList<ArrayList>(this.bucketCapacity);
        while(this.bucketArray.size()<initialCapacity){
            this.bucketArray.add(new ArrayList<StudentInfo>());
        }
        this.loadFactor = 1;
    }

    public MyHashTable(int initialCapacity, float loadFactor) {
        this.bucketCapacity = initialCapacity;
        this.bucketArray = new ArrayList<ArrayList>(this.bucketCapacity);
        while(this.bucketArray.size()<initialCapacity){
            this.bucketArray.add(new ArrayList<StudentInfo>());
        }
        this.loadFactor = loadFactor;
    }

    public float updateLF(){
        float lF = (float) this.size()/this.bucketCapacity;
        if(lF >= this.loadFactor){
            this.rehashing();
        }
        return lF;
    }

    private void rehashing(){
        this.bucketCapacity = this.bucketCapacity * 2;
        ArrayList buffer = new ArrayList();

        for (int i = 0; i < this.bucketArray.size(); i++){
            buffer.add(this.bucketArray.get(i).clone());
        }

        while(buffer.size() < this.bucketCapacity){
            buffer.add(new ArrayList<StudentInfo>());
        }
        this.bucketArray = buffer;
    }

    private int hashFunc(String k){
       int hashCode = this.polyNo(k);
       return this.comp(hashCode);
    }

    private int polyNo(String k){ //polynomial accumulation 결과 hashcode 값 return
        int a = 33;
        int ascii = 0;
        for(int i = 0; i < k.length() ; i++){
            ascii = (int) (k.charAt(i)*Math.pow(a,k.length()-i-1));
        }
        return ascii;
    }

    private int comp(int hash){ //hashcode 값 compress
        return hash % this.bucketCapacity;
    }

    public int size(){
        int size = 0;
        for (int i = 0 ; i<this.bucketArray.size(); i++){
            if(!this.bucketArray.get(i).isEmpty()) {
                size = size + this.bucketArray.get(i).size();
            }
        }
        return size;
    }

    public String get(String k){
        int hashcode = this.hashFunc(k);
        System.out.println("조회 해쉬코드 :" + hashcode);
        if (this.bucketArray.get(hashcode) == null){
            return null;
        }else{
            for (int i = 0; i< this.bucketArray.get(hashcode).size(); i++){
                StudentInfo s = (StudentInfo)this.bucketArray.get(hashcode).get(i);
            if(s.getStudentID().equals(k)){
                return s.getStudentName();
            }
        }
            return null;
        }
    }

    public String put(String k, String v){
        int hashCode = this.hashFunc(k);

        StudentInfo s = new StudentInfo(k,v);
        this.bucketArray.get(hashCode).add(s);
        this.updateLF();
        return s.getStudentName();
    }

    public String remove(String k){
        int hashCode = this.hashFunc(k);
        if(this.bucketArray.get(hashCode).size() == 0){
            return null;
        }else {
            for (int i = 0; i< this.bucketArray.get(hashCode).size(); i++){
                StudentInfo s = (StudentInfo)this.bucketArray.get(hashCode).get(i);
                if(s.getStudentID().equals(k)){
                    this.bucketArray.get(hashCode).remove(i);
                    this.updateLF();
                    return s.getStudentName();
                }
            }
            return null;
        }
    }

}
