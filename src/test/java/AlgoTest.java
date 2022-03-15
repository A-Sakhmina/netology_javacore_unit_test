import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoTest {
    Algo algo;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        algo = new Algo();
    }

    @BeforeAll
    public static void started() {
        System.out.println("started tests");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("tests completed");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testBinSearch(int[] arr, int x, int expected) {
        //act
        int result = algo.binSearch(arr, x);
        //assert
        assertEquals(expected, result);
    }

    public static Stream<Arguments> source() {
        int[] arr = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        return Stream.of(Arguments.of(arr, 32, 3), Arguments.of(arr, 60, 2));
    }
}
