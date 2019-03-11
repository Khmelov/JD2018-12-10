package by.it.titkovskaya.jd01.jd01_11;
/*
TaskC. Свой SetC. Напишите класс SetC<T>, который реализует toString() как в HashSet и 8 методов
add(T e), remove(Object o), contains(Object o), size(), isEmpty(), addAll(List<?> c),
containsAll(Collection<?> c), removeAll(Collection<?> c)
интерфейса Set<T> (реализация остальных – фиктивная).
 */

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SetC<T> implements Set<T> {

    private static Object object = new Object();
    private HashMap<T, Object> map = new HashMap<>();

    @Override
    public boolean add(T t) {
        map.put(t, object);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (map.remove(o) == object)
            return true;
        else
            return false;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T e : c)
            if (add(e))
                added = true;
        return added;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()){
            remove(iterator.next());
            removed=true;
        }
        return removed;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = "";
        sb.append("[");
        Iterator<T> it = map.keySet().iterator();
        while (it.hasNext()) {
            sb.append(delimiter).append(it.next());
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    //==============================================================================================


    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    @Override
    public Stream<T> stream() {
        return null;
    }

    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

}
