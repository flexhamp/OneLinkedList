package com.flexhamp;


import cucumber.api.java.ru.Дано;

import java.util.Iterator;
import java.util.List;

public class OneLinkedListCucumverRunnerTest {
    @Дано("^добавить элемент в односвязный список '(.*)'$")
    public void cucumberTestAdd(String str) {
        List<String> list = new OneLinkedList<>();

        list.add(str);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Дано("^добавить несколько элемент в односвязный список")
    public void cucumberTestAdds(List<String> stringList) {
        List<String> list = new OneLinkedList<>();

        for (String s : stringList) {
            list.add(s);
        }

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
