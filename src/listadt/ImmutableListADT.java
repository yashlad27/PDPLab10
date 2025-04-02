package listadt;

import java.util.function.Function;

/**
 * This interface represents an immutable list that cannot be modified after creation.
 * It extends CommonListADT to inherit all non-mutating operations, but does not
 * include any mutator methods.
 *
 * @param <T> the type of elements in this list
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {

  /**
   * Creates a mutable copy of this immutable list.
   * The resulting mutable list will have the same elements in the same order.
   *
   * @return a mutable list containing the same elements
   */
  MutableListADT<T> getMutableList();

  /**
   * A general purpose map higher order function that preserves immutability.
   *
   * @param converter the function that converts T into R
   * @param <R>       the type of data in the resulting list
   * @return an immutable list that is identical in structure to this list,
   *          but has data of type R
   */
  @Override
  <R> ImmutableListADT<R> map(Function<T, R> converter);
}