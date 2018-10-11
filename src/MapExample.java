import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        /*
        Ассоциативные массивы

        В Python: dict, {'a': 10, 'b': 20}

        Массив [10, 20, 30]
        0 -> 10
        1 -> 20
        2 -> 30

        Ассоциативный массив сопоставляет любым объектам
        "asdf" -> 10
        42 -> 20
        123 -> "zzz"

        Тип Map<Ключ, Значения>, например,
        Map<String, Integer> для подсчета частот слов
        Map<String, String> для словаря: слово -> перевод
        Map<String, List<String>> слово -> список переводов

        варианты
        HashMap, TreeMap, LinkedHashMap
        (см. HashSet, TreeSet, LinkedHashSet)
        - влияет на порядок перебора элементов.
        */

        Map<String, Integer> m = new HashMap<>();
        m.put("abc", 3); //положить ключ, значение m["abc"] = 3
        m.put("xyz", 5);
        m.put("abc", 4); //перезапишет значение

        System.out.println(m.get("abc")); //получить значение: 4

        System.out.println(m.get("pqr")); //вернет null
        System.out.println(m.getOrDefault("pqr", 42));
        //Если нет значения, то вернется default value

        //m.containsKey("abc") проверить, есть ли ключ
        //... много других полезных функций

        //Перебор элементов множества
        for (String key : m.keySet()) //keySet возвращает Set из ключей
            System.out.println(key + " -> " + m.get(key));

        //2 способ.
        //множество entiries, entry - пара ключ, значение
        //тип "пар" Map.Entry<>
        for (Map.Entry<String, Integer> e : m.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());
            //getKey, getValue - узнать ключи и значения

        //3 способ.
        m.forEach((key, value) -> { //"для каждого", перебор
            //key имеет тип String
            //value имеет тип Integer
            System.out.println(key + " -> " + value);
        });

    }

}
