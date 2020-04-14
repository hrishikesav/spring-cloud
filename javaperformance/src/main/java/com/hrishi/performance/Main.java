package com.hrishi.performance;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class Main {
	
	@Param({"10000000"}	)
	private int n;
	
	private List<String> data;

	public static void main(String[] args) {
		
		Options options = new OptionsBuilder()
				.include(Main.class.getSimpleName())
				.forks(1)
				.build();
		
		try {
			new Runner(options).run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Setup
	public void setup() {
		data = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            data.add("Number : " + i);
        }
	}

	@Benchmark
    public void loopFor(Blackhole bh) {
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i); //take out n consume, fair with foreach
            bh.consume(s);
        }
    }
}
