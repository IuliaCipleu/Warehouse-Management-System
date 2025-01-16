package bll.validators;

/**
 * Interface for defining a validator that can validate an object of a given type.
 *
 * @param <T> the type of object that this validator can validate
 */
public interface Validator<T> {
    /**
     * Validates the given object.
     *
     * @param t the object to validate
     * @throws IllegalArgumentException if the object is not valid
     */
    public void validate(T t);
}