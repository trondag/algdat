import org.junit.jupiter.api.*;


class MainTest {

    @Test
    void sort() throws EmptyCollectionException {

        String[] strings = new String[]{"ga", "ta", "ar", "pv", "ri", "ab"};
        String[] sortert = new String[]{"ab", "ar", "ga", "pv", "ri", "ta"};
        strings = Main.radixSort(strings, 1);
        Assertions.assertArrayEquals(sortert, strings);

    }
}