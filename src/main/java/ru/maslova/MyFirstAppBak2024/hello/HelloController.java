package ru.maslova.MyFirstAppBak2024.hello;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.ArrayList;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    /*1. Создайте GET-метод updateArrayList(String s), который по url “/update-array”
    принимает аргумент и записывает его в ArrayList<String >, реализуйте логику -
    если это первый вызов метода, то создается пустой ArrayList, если он не пустой, то туда записывается значение.*/

    ArrayList<String> arrayList = new ArrayList<String>();

    @PostMapping("/update-array/{name}")
    ArrayList<String> postUpdateArrayList(@PathVariable String name) {
        arrayList.add(name);
        return arrayList;
    }

    @PutMapping("/update-array/{name}")
    ArrayList<String> putUpdateArrayList(@PathVariable String name) {
        arrayList.add(name);
        return arrayList;
    }

    /*2. Создайте GET метод showArrayList(), который по url “/show-array” возвращается
    все элементы хранящиеся в ArrayList <String >, созданном в п. 1*/

    @RequestMapping(value = "/show-array", method = RequestMethod.GET)
    ArrayList<String> showArrayList() {
        return arrayList;
    }

    /*3. Создайте GET-метод updateHashMap(String s), который по url “/update-map”
    принимает аргумент и записывает его в HashMap< Integer, String>, реализуйте логику -
    если это первый вызов метода, то создается пустой HashMap, если он не пустой, то туда записывается значение.*/

    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    Random random = new Random();

    @PostMapping("/update-map/{name}")
    HashMap<Integer, String> postUpdateHashMap(@PathVariable String name) {
        hm.put(1, name);
        return hm;
    }

    @PutMapping("/update-map/{name}")
    HashMap<Integer, String> putUpdateHashMap(@PathVariable  String name) {
        hm.put(2, name);
        return hm;
    }

    /*4. Создайте GET метод showHashMap (), который по url “/show-map”
    возвращается все элементы хранящиеся в HashMap<Integer, String>, созданном в п. 3*/

    @RequestMapping(value = "/show-map", method = RequestMethod.GET)
    Set<Map.Entry<Integer, String>> showHashMap() {
    Set<Map.Entry<Integer, String>> set = hm.entrySet();    {
        for (Map.Entry<Integer, String> me : set) {
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
        }
    }
        return hm.entrySet();
}

    /*5. Создайте GET метод showAllLenght (), который по url “/show-all-lenght”
    возвращает текст, в котором указано количество элементов в ArrayList и HashMap*/

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        ArrayList<String> hMValues = new ArrayList<>(hm.values());
        return String.format("количество элементов в ArrayList: " + arrayList.size() + " и HashMap: " + hMValues.size());
    }
}
