package builder.util;

/**
 * TODO(Edd1e234): Look into optimizing this for primitive types. Class is incomplete, needs
 * messages to be defined.
 *
 * @param <T> The type. Looking into using just ints tho.
 */
public class StatusOr<T> extends Status {
    private T object;

    public void set(T object) {
        this.object = object;
    }

    public T get() {
        return object;
    }
}