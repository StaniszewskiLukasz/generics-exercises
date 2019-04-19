package pl.sda.generics.exercises;


import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Example1Test extends Example1 {

    @Test
    public void testPrintElements() {
        //Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje wszystkie
        //elementy tej listy
        List<String> stringList = new ArrayList<>(Arrays.asList("Anna", "Marek", "Marta"));
        List<Integer> integerList = new ArrayList<>(Arrays.asList(15, 12, 4));

        System.out.println(printElements(stringList));
        System.out.println(printElements(integerList));
        assertTrue(stringList.toString().equals(printElements(stringList)));
        assertTrue(integerList.toString().equals(printElements(integerList)));
    }


    @Test
    void testPrintElementsInOrder() {
//Napisz generyczną metodę która przyjmuje Listę jakichkolwiek elementów i wypisuje wszystkie
//elementy tej listy, ale z zachowaniem kolejności przekazanej w parametrze (Comparator)
        List<String> stringList = new ArrayList<>(Arrays.asList("Anna", "Marek", "Marta"));
        List<String> stringList2 = new ArrayList<>(Arrays.asList("Anna", "Marek", "Marta", "4"));
        List<Integer> integerList = new ArrayList<>(Arrays.asList(15, 12, 4));

        Comparator naturalOrder = Comparator.naturalOrder();
        Comparator reverseOrder = Comparator.reverseOrder();

        System.out.println(printElementsInOrder(stringList, naturalOrder));
        System.out.println(printElementsInOrder(stringList, reverseOrder));
        System.out.println(printElementsInOrder(stringList2, naturalOrder));
        System.out.println(printElementsInOrder(integerList, naturalOrder));
        assertTrue(stringList.equals(printElementsInOrder(stringList, naturalOrder)));
        assertFalse(stringList.equals(printElementsInOrder(stringList, reverseOrder)));
        assertTrue(new ArrayList<>(Arrays.asList("4", "Anna", "Marek", "Marta")).
                equals(printElementsInOrder(stringList2, naturalOrder)));
        assertTrue(new ArrayList<>(Arrays.asList(4, 12, 15))
                .equals(printElementsInOrder(integerList, naturalOrder)));

    }

    @Test
    void testSumOfElements() {
        //Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikolwiek numerami
        // i zwraca ich sumę jako double
        List<Integer> integerList = new ArrayList<>(Arrays.asList(15, 12, 4));
        List<Long> longList = new ArrayList<>(Arrays.asList(15L, 12L, 4L));

        assertTrue(sumOfElements(integerList) == 31);
        assertTrue(sumOfElements(longList) == 31);
    }

    @Test
    void testSumOfElementsWithLimiter() {
//Napisz generyczną metodę która przyjmuje Listę elementów będących jakimikolwiek numerami
// i zwraca ich sumę jako double, ale fitruje elementy większe od dodatkowo przekazanego parametru
        List<Integer> integerList = new ArrayList<>(Arrays.asList(15, 12, 4));
        List<Long> longList = new ArrayList<>(Arrays.asList(301L, 12L, 4L));

        System.out.println(sumOfElementsWithLimiter(integerList, 11));
        System.out.println(sumOfElementsWithLimiter(longList, 300));
        assertTrue(sumOfElementsWithLimiter(integerList,11) == 27);
        assertTrue(sumOfElementsWithLimiter(longList,300) == 301);
    }
}
