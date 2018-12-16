package imperative;

import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {

    public static enum STATE {
        ABUNDANT,DEFICIENT,PERFECT
    }

    public static Set<Integer> divisors(int n) {
        Set<Integer> list = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static STATE process(int n){
        int sum=0;
        for (int i=1; i < n; i++) {
            if (n % i == 0) {
                sum+=i;
            }
        }
        if (sum == n)
            return STATE.PERFECT;
        if (sum > n)
            return STATE.ABUNDANT;
        return STATE.DEFICIENT;
    }


}
