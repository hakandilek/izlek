package me.dilek.izlek.ui.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generic list adapter
 * <p/>
 * Created by Hakan Dilek on 12.04.15.
 */
public abstract class AbstractListAdapter<E> extends BaseAdapter {

    private List<E> list = new ArrayList<>();

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

        AbstractItemView<E> itemView;
        if (convertView == null) {
            itemView = getItemView();
        } else {
            itemView = (AbstractItemView<E>) convertView;
        }

        E item = (E) getItem(position);
        itemView.bind(item);

        return itemView;
    }

    protected abstract AbstractItemView<E> getItemView();

    public void clear() {
        list.clear();
    }

    public void addAll(Collection<E> items) {
        list.addAll(items);
    }
}
