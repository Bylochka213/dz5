public class HashSetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        // Добавление элементов
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);

        // Проверка наличия элементов
        System.out.println("Contains 10: " + set.contains(10)); // true
        System.out.println("Contains 25: " + set.contains(25)); // false

        // Удаление элемента
        set.remove(10);
        System.out.println("Contains 10 after removal: " + set.contains(10)); // false
    }
}
