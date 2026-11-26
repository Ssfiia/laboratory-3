package ru.shamsutdinova.phone;

import java.util.Map;
import java.util.HashMap;

public class PhoneBook {
    private final Map<String, String> byName = new HashMap<>();
    private final Map<String, String> byPhone = new HashMap<>();

    public PhoneBook() {}

    public String add(String phone, String name) {
        if (phone == null || name == null)
            throw new IllegalArgumentException("Телефон и имя не могут быть пустым");
            
        if (!phone.matches("\\d+")) {
            throw new IllegalArgumentException("Телефон должен состоять только из цифр");
        }
        if (!name.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
            throw new IllegalArgumentException("Имя должно состоять только из букв");
        }

        String oldPhone = byName.get(name);
        if (oldPhone != null) byPhone.remove(oldPhone);
        byName.put(name, phone);
        byPhone.put(phone, name);
        return oldPhone;
    }

    public String remove(String name) {
        String phone = byName.remove(name);
        if (phone != null) byPhone.remove(phone);
        return phone;
    }

    public String getPhone(String name) { return byName.get(name); }
    public String getName(String phone) { return byPhone.get(phone); }
    public boolean containsName(String name) { return byName.containsKey(name); }
    public boolean containsPhone(String phone) { return byPhone.containsKey(phone); }
    public int size() { return byName.size(); }

    public String[] allPairs() {
        String[] res = new String[byName.size()];
        int i = 0;
        for (Map.Entry<String, String> e : byName.entrySet())
            res[i++] = e.getValue() + " - " + e.getKey();
        return res;
    }

    public String[] allPhones() { return byName.values().toArray(new String[0]); }
    public String[] allNames() { return byName.keySet().toArray(new String[0]); }

    public String[] namesStartingWith(String prefix) {
        if (prefix == null) throw new IllegalArgumentException("Префикс не может быть пустой");
        return byName.keySet().stream().filter(n -> n.startsWith(prefix)).toArray(String[]::new);
    }

    @Override
    public String toString() { return String.join(", ", allPairs()); }
}