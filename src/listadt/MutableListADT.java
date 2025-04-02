package listadt;

import java.util.function.Function;

/**
 * This interface represents a mutable list that can be modified after creation.
 * It extends ListADT to inherit both observer and mutator operations.
 *
 * @param <T> the type of elements in this list
 */
public interface MutableListADT<T> extends ListADT<T> {

  /**
   * Creates an immutable copy of this mutable list.
   * The resulting immutable list will have the same elements in the same order.
   *
   * @return an immutable list containing the same elements
   */
  ImmutableListADT<T> getImmutableList();

  /**
   * A general purpose map higher order function that preserves mutability.
   *
   * @param converter the function that converts T into R
   * @param <R>       the type of data in the resulting list
   * @return a mutable list that is identical in structure to this list,
   *           but has data of type R
   */
  @Override
  <R> MutableListADT<R> map(Function<T, R> converter);
}