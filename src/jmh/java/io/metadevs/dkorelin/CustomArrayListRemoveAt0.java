package io.metadevs.dkorelin;

import io.metadevs.dkorelin.CustomArrayList.CustomArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.Arrays;

@State(Scope.Benchmark)
public class CustomArrayListRemoveAt0 {
    private final String[] arrayString = simpleTestArray(10000);

    @Benchmark
    public void removeBenchmark100() {
        removeElements(100);
    }

    @Benchmark
    public void removeBenchmark1000() {
        removeElements(1000);
    }

    @Benchmark
    public void removeBenchmark10000() {
        removeElements(10000);
    }

    private void removeElements(int numOfElements) {
        CustomArrayList<String> internalArrayList = new CustomArrayList<>(Arrays.copyOf(arrayString,numOfElements));
        for (int i = 0; i < numOfElements; i++) {
            internalArrayList.remove(0);
        }
    }
    private String[] simpleTestArray(int numberOfElements) {
        String testData = "testData";
        String[] testArray = new String[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) {
            testArray[i] = testData + i;
        }
        return testArray;
    }
}


