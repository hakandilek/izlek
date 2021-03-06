package me.dilek.izlek.executor;

/**
 * @author Hakan Dilek on 10.04.2015.
 */
public abstract class LoadTask<D> implements Task {


    /**
     * success fallback
     *
     * @param data result parameter
     */
    public void onLoadSuccess(final D data) {
        // do nothing
    }

    /**
     * Error callback
     *
     * @param e the error
     */
    public void onError(Exception e) {
        //do nothing
    }

    /**
     * Error callback if data returned is null
     */
    public void onNotFound() {
        //do nothing
    }

    @Override
    public void run() {
        try {
            D data = load();
            if (data == null) {
                onNotFound();
            } else {
                onLoadSuccess(data);
            }
        } catch (Exception e) {
            onError(e);
        }
    }

    public abstract D load() throws Exception;
}
