package me.dilek.izlek.ui.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import me.dilek.izlek.ui.renderer.AbstractRenderer;

/**
 * Generic list adapter
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
public class ListAdapter<E> extends BaseAdapter {
    private List<E> list;
    private AbstractRenderer<E> renderer;

    public ListAdapter(Collection<E> items, AbstractRenderer<E> renderer) {
        this.renderer = renderer;
        this.list = new ArrayList<>(items);
    }

    public ListAdapter(AbstractRenderer<E> renderer) {
        this.renderer = renderer;
        this.list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        E item = list.get(position);
        return renderer.render(item, convertView, parent);
    }

    public void clear() {
        list.clear();
    }

    public void addAll(Collection<E> items) {
        list.addAll(items);
    }
}
