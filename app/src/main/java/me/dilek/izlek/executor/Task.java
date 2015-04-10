package me.dilek.izlek.executor;

/**
 * Defines a task to be executed
 *
 * @author Hakan Dilek on 10.04.2015.
 */
public interface Task<R> {
    /**
     * execution method
     */
    void run();


}
