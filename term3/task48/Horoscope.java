package ru.itis;

import java.util.HashMap;
import java.util.Map;

public class Horoscope {
    Map<String, String> map = new HashMap<String, String>();

    public Horoscope() {
        map.put("Овен", "Упрямые");
        map.put("Телец", "Заносчивые");
        map.put("Близнецы", "Классые");
        map.put("Рак", "Ноют");
        map.put("Лев", "Чистюли");
        map.put("Дева", "Своенравные");
    }

    public String getValue(String key) {
        return map.get(key);
    }
}
