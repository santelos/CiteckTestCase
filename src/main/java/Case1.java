import java.util.*;
import java.util.stream.Collectors;

/**
 * Первое задание
 */
public class Case1 {
    private static class CountHolder {

        CountHolder(int _key, int _count) {
            key = _key;
            count = _count;
        }

        int key;
        int count;
    }

    /**
     * Посчитать количество каждого числа, посредством добавления его в HashMap<br></br>
     * Отсортировать полученный Map по значению.
     * @param args
     */
    public static void main(String[] args) {
        // Объявляется и заполняется массив
        int[] inputArr = new int[10];
        Random random = new Random();
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = random.nextInt(5);
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        // В HashMap по key - числу в массиве добавляем число использований - value
        // Если такого key нету, то значит чило мы встречаем первый раз и его нужно добавить в Map
        for (int anInputArr : inputArr) {
            if (countMap.containsKey(anInputArr)) countMap.replace(anInputArr, countMap.get(anInputArr) + 1);
            else countMap.put(anInputArr, 1);
        }

        // Тут сортируем Set Entry по value - количеству использований и собираем это в список
        List<CountHolder> counts = countMap.entrySet()
                .stream().sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(e -> new CountHolder(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        System.out.println(counts);
    }

}
