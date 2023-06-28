public class MyTest {
    public static void main(String[] args) {
        MyHashSet<String> myHashSet = new MyHashSet<>();
        myHashSet.put("Hello");
        try {
            myHashSet.put("Hello");
        } catch (RuntimeException e) {
            System.out.println("Вы словили ошибку: " +e.getMessage()+ "\n");
        }
        System.out.println("Проверка наличия элемента \"Hello\": "+myHashSet.containsValue("Hello")+"\n");
        myHashSet.remove("Hello");
        System.out.println("Проверка наличия элемента после удаления \"Hello\": "+myHashSet.containsValue("Hello") + "\n");
        //Проверка метода .get
        myHashSet.put("TestGet");
        System.out.println("Проверка работоспособности метода \"get\": "+ myHashSet.get("TestGet"));

    }
}