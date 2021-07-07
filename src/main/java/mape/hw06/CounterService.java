package mape.hw06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;

public class CounterService {

    public Map<Integer, Long> count(List<Integer> list) {
        HashMap<Integer, Long> result = new HashMap<>();
        for (Integer key : list) {
            Long value = result.getOrDefault(key, 0L);
            result.put(key, value + 1);
        }
        return result;
    }

    public Map<Integer, Long> countWithStream(List<Integer> list) {
        return list.stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Integer> list = asList(1, 2, 3, 2, 1, 2, 1, 2, 1, 3);
        CounterService counterService = new CounterService();
        System.out.println(counterService.count(list));
        System.out.println(counterService.countWithStream(list));
    }
}
