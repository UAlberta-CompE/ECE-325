package ece325.labs.lab2;

/**
 * Abstract base class for all types of equipment.
 * Forces subclasses to implement toString() to describe the type.
 */
public abstract class Equipment {
    public Equipment() {
    }

    /**
     * Returns the type of equipment as a String (e.g., "Guitar").
     */
    public abstract String toString();
}