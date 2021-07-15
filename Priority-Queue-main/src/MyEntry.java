

public class MyEntry implements Entry{
    private Object k;//key
    private Object v;//value

    public MyEntry() {
        this.k = null;
        this.v = null;
    }

    public MyEntry(Object k, Object v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public void setKey(Object key) {
        this.k = key;
    }

    @Override
    public void setValue(Object value) {
        this.v = value;
    }

    @Override
    public Object getKey() {
        return this.k;
    }

    @Override
    public Object getValue() {
        return this.v;
    }
}
