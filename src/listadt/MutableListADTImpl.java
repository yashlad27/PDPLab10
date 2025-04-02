package listadt;

import java.util.function.Function;

/**
 * Implementation of a mutable list that can be modified after creation.
 * This class adapts the existing ListADTImpl class.
 *
 * @param <T> the type of elements in this list
 */
public class MutableListADTImpl<T> implements MutableListADT<T> {
  private final ListADTImpl<T> list;

  /**
   * Creates a new empty mutable list.
   */
  public MutableListADTImpl() {
    this.list = new ListADTImpl<>();
  }

  /**
   * Creates a mutable list from an existing ListADTImpl.
   *
   * @param list the internal list implementation
   */
  private MutableListADTImpl(ListADTImpl<T> list) {
    this.list = list;
  }

  @Override
  public void addFront(T b) {
    this.list.addFront(b);
  }

  @Override
  public void addBack(T b) {
    this.list.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    this.list.add(index, b);
  }

  @Override
  public void remove(T b) {
    this.list.remove(b);
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
  public <R> MutableListADT<R> map(Function<T, R> converter) {
    ListADTImpl<R> mappedList = (ListADTImpl<R>) this.list.map(converter);
    return new MutableListADTImpl<>(mappedList);
  }

  @Override
  public ImmutableListADT<T> getImmutableList() {
    ImmutableListADT.Builder<T> builder = new ImmutableListADTImpl.Builder<>();

    // Add each element to the builder
    for (int i = 0; i < this.getSize(); i++) {
      builder.add(this.get(i));
    }

    return builder.build();
  }

  @Override
  public String toString() {
    return this.list.toString();
  }
}