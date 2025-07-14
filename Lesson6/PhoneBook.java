
/*    Задание 2

Написать простой класс Телефонный Справочник,
который хранит в себе список фамилий и телефонных номеров.

В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.

Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PhoneBook {

    HashMap<String, Set<Long>> repository = new HashMap<>();

    public void add(String key, Long number) {
        boolean found = false;
        for (Set<Long> set : repository.values()) {
            if (set.contains(number)) {
                found = true;
                System.out.println("номер " + number + " уже есть в базе");
                System.out.println("запись не добавлена");
                break;
            }
        }
        if (!found) {
            repository.computeIfAbsent(key, k -> new HashSet<Long>()).add(number);
        }
    }

    public Optional<Set<Long>> get(String key) {
        return Optional.ofNullable(repository.get(key));
    }
}
