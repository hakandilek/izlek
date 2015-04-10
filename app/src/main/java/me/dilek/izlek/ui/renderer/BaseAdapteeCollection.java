package me.dilek.izlek.ui.renderer;

import com.pedrogomez.renderers.AdapteeCollection;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Hakan Dilek on 10.04.2015.
 */
public abstract class BaseAdapteeCollection<T> implements AdapteeCollection<T> {

    private static final long serialVersionUID = 8799677673292716638L;

    private final LinkedList<T> list;

    public BaseAdapteeCollection() {
        this(new LinkedList<T>());
    }

    public BaseAdapteeCollection(Collection<T> list) {
        this.list = new LinkedList<T>();
        this.list.addAll(list);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean add(T element) {
        return list.add(element);
    }

    @Override
    public boolean remove(Object element) {
        return list.remove(element);
    }

    @Override
    public boolean addAll(Collection<? extends T> elements) {
        return list.addAll(elements);
    }

    @Override
    public boolean removeAll(Collection<?> elements) {
        return list.removeAll(elements);
    }

    @Override
    public void clear() {
        list.clear();
    }

    public List<T> cloneList() {
        return (List<T>) list.clone();
    }
}
