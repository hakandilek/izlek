package me.dilek.izlek.ui.presenter;

/**
 * Presenter interface
 *
 * @author Hakan Dilek on 10.04.2015.
 */
public interface Presenter {

    /**
     * Called when the presenter is initialized, this method represents the start of the presenter
     * lifecycle.
     */
    void initialize();

    /**
     * Called when the presenter is resumed. After the initialization and when the presenter comes
     * from a pause state.
     */
    void resume();

    /**
     * Called when the presenter is paused.
     */
    void pause();

}
