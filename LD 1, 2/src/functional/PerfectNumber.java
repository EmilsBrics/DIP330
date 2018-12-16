package functional;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PerfectNumber {

    public enum STATE {
        DEFICIENT, PERFECT, ABUNDANT;
    }

    public static Set<Integer> divisors(int n) {
        return IntStream
                .rangeClosed(1, n)
                .filter((i) -> n % i == 0)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));
    }

    public static STATE process(int n) {

        Function<Integer, STATE> StateFind = check -> Optional.of(check)
                .filter(i -> i == n)
                .map(i -> STATE.PERFECT)
                .orElse(STATE.DEFICIENT);

        Set<Integer> IntStream = divisors(n);
        STATE state= IntStream
                .stream()
                .filter((i) -> i != n)
                .reduce((a, b) -> a + b)
                .filter(i -> i <= n)
                .map(StateFind)
                .orElse(STATE.ABUNDANT);
        return state;

    }
}

