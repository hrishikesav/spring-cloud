This checks the performace of a for loop for 10000000 items.

Command to run the sample program:
java -jar benchmarks.jar Main

Output:
===================================================
# JMH version: 1.21
# VM version: JDK 1.8.0_191, Java HotSpot(TM) 64-Bit Server VM, 25.191-b12
# VM invoker: C:\Program Files\Java\jre1.8.0_191\bin\java.exe
# VM options: -Xms2G -Xmx2G
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.hrishi.performance.Main.loopFor
# Parameters: (n = 10000000)

# Run progress: 0.00% complete, ETA 00:03:20
# Fork: 1 of 2
# Warmup Iteration   1: 64.305 ms/op
# Warmup Iteration   2: 70.922 ms/op
# Warmup Iteration   3: 84.087 ms/op
# Warmup Iteration   4: 110.160 ms/op
# Warmup Iteration   5: 118.855 ms/op
Iteration   1: 119.326 ms/op
Iteration   2: 77.445 ms/op
Iteration   3: 73.747 ms/op
Iteration   4: 76.899 ms/op
Iteration   5: 77.913 ms/op

# Run progress: 50.00% complete, ETA 00:01:42
# Fork: 2 of 2
# Warmup Iteration   1: 74.885 ms/op
# Warmup Iteration   2: 95.218 ms/op
# Warmup Iteration   3: 118.614 ms/op
# Warmup Iteration   4: 118.056 ms/op
# Warmup Iteration   5: 115.227 ms/op
Iteration   1: 116.190 ms/op
Iteration   2: 78.968 ms/op
Iteration   3: 108.849 ms/op
Iteration   4: 110.190 ms/op
Iteration   5: 113.355 ms/op


Result "com.hrishi.performance.Main.loopFor":
  95.288 ±(99.9%) 29.540 ms/op [Average]
  (min, avg, max) = (73.747, 95.288, 119.326), stdev = 19.539
  CI (99.9%): [65.748, 124.828] (assumes normal distribution)


# Run complete. Total time: 00:03:24

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark          (n)  Mode  Cnt   Score    Error  Units
Main.loopFor  10000000  avgt   10  95.288 ± 29.540  ms/op
