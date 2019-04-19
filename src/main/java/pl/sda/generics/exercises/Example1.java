package pl.sda.generics.exercises;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Example1 {
    //Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje
// wszystkie elementy tej listy
    public <T> String printElements(List<T> list) {

        return list.toString();
    }


    //Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje
    // wszystkie elementy tej listy, ale z zachowaniem kolejności przekazanej w parametrze (Comparator)
    public <T> List<Object> printElementsInOrder(List<T> list, Comparator<T> comparator) {
        return list.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    //Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikolwiek numerami
    // i zwraca ich sumę jako double
    public <T extends Number> Double sumOfElements(List<T> list) {
        //jeśli wskażę że metoda obsługuje cokolwiek <T> bez dopisku extends Number mam metody od Object
        //jeśli wskażę że metoda obsługuje <Number> mam także podstawowe metody od Object
        //jeśli wskażę że metoda obsługuje <T extends Number> mam dostęp do metod z klasy Number !!!!!!!!!!!!!
        return list.stream().mapToDouble(n -> n.doubleValue()).sum();
    }

    //Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikolwiek numerami
    // i zwraca ich sumę jako double, ale fitruje elementy większe od dodatkowo przekazanego parametru
    public <T extends Number> Double sumOfElementsWithLimiter(List<T> list, int limiter) {
        return list.stream().filter(n -> n.doubleValue() > limiter).mapToDouble(n -> n.doubleValue()).sum();
    }

}
