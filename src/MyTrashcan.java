public class MyTrashcan {
    private MyLinkedList<MyValueEntry> entry;
    public MyTrashcan(){
        if (entry == null){
            entry = new MyLinkedList<>();
        }
    }
    public void addEntry(MyValueEntry valueEntry){
        entry.add(valueEntry);
    }
    public void removeEntry(MyValueEntry valueEntry){
        this.entry.remove(valueEntry);
    }
    public MyLinkedList<MyValueEntry> getEntry() {
        return entry;
    }
}

