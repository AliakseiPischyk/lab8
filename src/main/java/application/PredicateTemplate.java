package application;

public class PredicateTemplate {

    public boolean isEven(final int value) {
        return value % 2 == 0;
    }

    public boolean isUneven(final int value) {
        return value % 2 != 0;
    }

    public <T extends Number & Comparable<T>> boolean isPrime(T number) {
        Integer two = 2;
        if (number.compareTo((T) two) < 0) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number.doubleValue()); i++) {
            if (number.longValue() % i == 0) {
                return false;
            }
        }
        return true;
    }
}
