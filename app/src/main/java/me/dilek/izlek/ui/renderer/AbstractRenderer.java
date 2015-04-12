package me.dilek.izlek.ui.renderer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Renderer of a specific type
 * Created by Hakan Dilek on 12.04.15.
 */
public abstract class AbstractRenderer<T> {

    protected abstract View inflate(LayoutInflater inflater, ViewGroup parent);

    public View render(T content, View convertView, ViewGroup parent) {
        String tagName = getClass().getSimpleName();
        Log.d(tagName, content + "");

        RendererValue value;
        if (isRecyclable(convertView, content)) {
            value = recycleValue(convertView, content);
        } else {
            value = createValue(content, parent);
        }

        update(value);

        return value.rootView;
    }

    protected abstract void update(RendererValue value);

    private boolean isRecyclable(View convertView, T content) {
        boolean isRecyclable = false;
        if (convertView != null && convertView.getTag() != null) {
            Class prototypeClass = getPrototypeClass(content);
            isRecyclable = prototypeClass.equals(convertView.getTag().getClass());
        }
        return isRecyclable;
    }

    protected Class getPrototypeClass(T content) {
        return content.getClass();
    }

    private RendererValue recycleValue(View convertView, T content) {
        RendererValue value = (RendererValue) convertView.getTag();
        return value;
    }

    private RendererValue createValue(T content, ViewGroup parent) {
        RendererValue value = new RendererValue(content);
        value.rootView = inflate(layoutInflater(), parent);
        value.rootView.setTag(value);
        return value;
    }

    protected abstract LayoutInflater layoutInflater();

    protected class RendererValue {
        T content;
        View rootView;

        public RendererValue(T content) {
            this.content = content;
        }
    }
}
