import java.util.ArrayList;

public class Notebook {
    private ArrayList<String> notes = new ArrayList<>();

    public void add(String... sList) {
        for ( String s: sList ) {
            notes.add(s);
        }
    }

    public void add(String s, int loc) {
        notes.add(loc, s);
    }

    public int getSize() {
        return notes.size();
    }

    public String getNote(int index) {
        return notes.get(index);
    }

    public void removeNote(int index) {
        notes.remove(index);
    }

    public String[] list() {
        String[] a = new String[notes.size()];
        // arraylist是一种动态数组的实现，这里把她转换成真正的数组
        notes.toArray(a);
        return a;
    }

    public static void main(String[] args) {
        Notebook nb = new Notebook();
        nb.add("first", "second");
        nb.add("3", 1);

        for ( String s: nb.list() ) {
            System.out.println(s);
        }
    }




}