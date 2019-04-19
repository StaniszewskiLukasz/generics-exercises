package pl.sda.generics.exercises;

public class Pair<T, E> {



    Pair pairFirst = new Pair<String,E>();
    Pair pairSecond = new Pair<T,Integer>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return com.google.common.base.Objects.equal(pairFirst, pair.pairFirst) &&
                com.google.common.base.Objects.equal(pairSecond, pair.pairSecond);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(pairFirst, pairSecond);
    }
}
