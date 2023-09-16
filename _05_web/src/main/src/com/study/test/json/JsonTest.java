package com.study.test.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.study.test.entity.Person;
import com.study.test.type.PersonListType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonTest {
    /**
     * json to javabean
     */
    @Test
    public void test1() {
        Person person = new Person(1, "卢本伟");
        Gson gson = new Gson();
        String s = gson.toJson(person);
        System.out.println(s);

        System.out.println(gson.fromJson(s, Person.class));
    }

    /**
     * json to list
     */
    @Test
    public void test2() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1, "卢本伟"));
        people.add(new Person(2, "马飞飞"));
        Gson gson = new Gson();
        String s = gson.toJson(people);

        ArrayList<Person> arrayList = gson.fromJson(s, new PersonListType().getType());
        Person person = arrayList.get(0);
        System.out.println(arrayList);
        System.out.println(person);
    }


    /**
     * json to map
     */
    @Test
    public void test3() {
        HashMap<Integer, Person> people = new HashMap<>();
        people.put(1,new Person(1, "卢本伟"));
        people.put(2,new Person(2, "马飞飞"));
        Gson gson = new Gson();
        String s = gson.toJson(people);

        HashMap<Integer, Person> map = gson.fromJson(s, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());
        System.out.println(map);

    }

}
