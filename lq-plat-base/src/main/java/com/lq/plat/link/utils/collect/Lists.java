package com.lq.plat.link.utils.collect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class Lists {

    public static <E> ArrayList<E> newArrayList()
    {
        return new ArrayList();
    }

    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... elements)
    {
        if (elements == null) {
            throw new NullPointerException();
        }
        ArrayList<E> list = new ArrayList(computeArrayListCapacity(elements.length));
        Collections.addAll(list, elements);
        return list;
    }

    public static <E> ArrayList<E> newArrayList(int initialCapacity)
    {
        return new ArrayList(initialCapacity);
    }

    public static <E> LinkedList<E> newLinkedList()
    {
        return new LinkedList();
    }

    private static int computeArrayListCapacity(int arraySize)
    {
        return 5 + arraySize + arraySize / 10;
    }
}
