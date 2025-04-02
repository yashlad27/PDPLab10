package listadt;

import java.util.function.Function;

public interface CommonListADT<T> {

  int getSize();

  T get(int index) throws IllegalArgumentException;

  <R> CommonListADT<R> map(Function<T, R> converter);
}
