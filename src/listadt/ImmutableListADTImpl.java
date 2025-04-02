package listadt;

import java.util.function.Function;

/**
 * Implementation of an immutable list that cannot be modified after creation.
 * Uses the Builder pattern for construction and adapts the existing ListADTImpl class.
 *
 * @param <T> the type of elements in this list
 */
public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {
  private final ListADTImpl<T> list;

  /**
   * Private constructor that creates an immutable list from a ListADTImpl.
   * This constructor is private to enforce using the Builder for constructing instances.
   *
   * @param list the internal list implementation
   */
  private ImmutableListADTImpl(ListADTImpl<T> list) {
    this.list = list;
  }

  /**
   * Creates a new empty immutable list.
   */
  public ImmutableListADTImpl() {
    this.list = new ListADTImpl<>();
  }

  /**
   * Private helper method to add an element to the back of the list.
   * This is used during the building process.
   *
   * @param element the element to add
   */
  private void addBack(T element) {
    this.list.addBack(element);
  }

  @Override
  public int getSize() {
    return this.list.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return this.list.get(index);
  }

  @Override
  public <R> ImmutableListADT<R> map(Function<T, R> converter) {
    ImmutableListADTImpl<R> result = new ImmutableListADTImpl<>();

    for (int i = 0; i < this.getSize(); i++) {
      result.addBack(converter.apply(this.get(i)));
    }

    return result;
  }

  @Override
  public MutableListADT<T> getMutableList() {
    MutableListADTImpl<T> mutableList = new MutableListADTImpl<>();

    for (int i = 0; i < this.getSize(); i++) {
      mutableList.addBack(this.get(i));
    }

    return mutableList;
  }

  @Override
  public String toString() {
    return this.list.toString();
  }

  /**
   * Builder class for constructing immutable lists.
   * This provides a way to create an immutable list by adding elements
   * before finalizing the construction.
   *
   * @param <T> the type of elements in the list
   */
  public static class Builder<T> {
    private final ImmutableListADTImpl<T> list;

    /**
     * Creates a new builder for an immutable list.
     */
    public Builder() {
      this.list = new ImmutableListADTImpl<>();
    }

    /**
     * Adds an element to the list being built.
     *
     * @param element the element to add
     * @return this builder for method chaining
     */
    public Builder<T> add(T element) {
      this.list.addBack(element);
      return this;
    }

    /**
     * Completes the building process and returns the immutable list.
     *
     * @return the constructed immutable list
     */
    public ImmutableListADT<T> build() {
      ListADTImpl<T> copy = new ListADTImpl<>();
      for (int i = 0; i < this.list.getSize(); i++) {
        copy.addBack(this.list.get(i));
      }
      return new ImmutableListADTImpl<>(copy);
    }
  }
}