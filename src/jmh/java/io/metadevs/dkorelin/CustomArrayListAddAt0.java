package io.metadevs.dkorelin;

import io.metadevs.dkorelin.CustomArrayList.CustomArrayList;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class CustomArrayListAddAt0 {
    @Benchmark
    public void addBenchmark100() {
        addElements(100);
    }

    @Benchmark
    public void addBenchmark1000() {
        addElements(1000);
    }

    @Benchmark
    public void addBenchmark10000() {
        addElements(10000);
    }

    public void addElements(int numOfElements) {
        CustomArrayList<String> caString = new CustomArrayList<>();
        for (int i = 0; i < numOfElements; i++) {
            caString.add(0,"test"+i);
        }
    }
}


