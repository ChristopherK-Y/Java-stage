package use_absclass;

public class MyArrayList extends AbsList {
    private String[] array = new String[16];

    @Override
    public boolean add(String s) {
        array[size++] = s;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String get(int index) {
        checkIndex(index);

        return array[index];
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }
}
