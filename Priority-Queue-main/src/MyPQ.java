


import java.util.ArrayList;
import java.util.Comparator;

public class MyPQ {
    private Comparator comp;
    private ArrayList<MyEntry> list;

    public void setComp(Comparator comp) {
        this.comp = comp;
    }

    public MyPQ(Comparator comp) {
        this.comp = comp;
        this.list = new ArrayList<MyEntry>();
    }

    public MyPQ(Comparator comp, ArrayList list) {
        this.comp = comp;
        this.list = new ArrayList<MyEntry>(list);
    }

    public int size(){
        return this.list.size();
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public MyEntry insert(Object k, Object v){
        MyEntry myEntry = new MyEntry(k,v);
        if(this.isEmpty()){
            this.list.sort(this.comp);
            this.list.add(0,myEntry);
            return (MyEntry) this.list.get(0);
        }else if(this.list.size() == 1){
           int i = this.comp.compare(this.list.get(0).getKey(), k);
           if (i < 0){
               this.list.add(myEntry);
               return myEntry;
           }else if(i == 0){
               this.list.add(0,myEntry);
               return myEntry;
           }else if(i > 0){
               this.list.add(0,myEntry);
               return this.list.get(0);
           }
        }else {
            for (int j = 0; j < this.list.size(); j++) {
            if (this.comp.compare(this.list.get(j).getKey(), myEntry.getKey()) >= 0){
                this.list.add(j, myEntry);
                return this.list.get(j);
            }else{
                try {
                    if (this.comp.compare(this.list.get(j+1).getKey(), myEntry.getKey())>=0){
                        this.list.add(j+1,myEntry);
                        return this.list.get(j+1);
                    }else  if (this.comp.compare(this.list.get(j+1).getKey(), myEntry.getKey())<0){
                        continue;
                    }
                    }catch (IndexOutOfBoundsException e){
                        this.list.add(j+1,myEntry);
                        return myEntry;
                    }
                }
            }
        }
        System.out.println("추가 실패");
        return null;
    }

    public MyEntry removeMin(){
        if (this.isEmpty()){
            System.out.println("List is Empty");
            return null;
        }
        return (MyEntry) this.list.remove(0);
    }

    public MyEntry min(){
        if (this.isEmpty()){
            System.out.println("List is Empty");
            return null;
        }
        return(MyEntry) this.list.get(0);
    }
}
