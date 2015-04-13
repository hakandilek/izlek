package me.dilek.izlek.ui.view;

import android.content.Context;
import android.widget.LinearLayout;

/**
 * View containing a single list item.
 *
 * @author Hakan Dilek on 13.04.2015.
 */
public abstract class AbstractItemView<E> extends LinearLayout {

    public AbstractItemView(Context context) {
        super(context);
    }

    public abstract void bind(E item);
}
