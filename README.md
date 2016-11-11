# jsonp-jmh

JMH project created for testing jsonp.

It appears, there is noticable difference between performance of JsonGeneratorImpl between 1.0.4 and 1.1.0-SNAPSHOT.
Please try:

./run.sh 1.0.4

Run complete. Total time: 00:00:15
Benchmark                                         Mode  Cnt     Score     Error   Units
JsonGeneratorTest.test1JsonbStringWriter         thrpt   10  4484.430 ± 159.659  ops/ms
JsonGeneratorTest.test1JsonbStringWriter:·stack  thrpt            NaN               ---



./run.sh 1.1.0-SNAPSHOT

Run complete. Total time: 00:00:15
Benchmark                                         Mode  Cnt     Score     Error   Units
JsonGeneratorTest.test1JsonbStringWriter         thrpt   10  3256.665 ± 205.003  ops/ms
JsonGeneratorTest.test1JsonbStringWriter:·stack  thrpt            NaN               ---

You can see that new version is considerably slower.
Both generate similar stack trace:
....[Thread state distributions]....................................................................
 98.8%         RUNNABLE
  1.1%         WAITING

....[Thread state: RUNNABLE]........................................................................
 57.9%  58.6% org.glassfish.json.JsonGeneratorImpl.writeString
 13.9%  14.1% org.glassfish.json.JsonGeneratorImpl.flush
 13.2%  13.3% org.glassfish.json.JsonGeneratorTest.test1JsonbStringWriter
  6.1%   6.2% java.util.concurrent.ConcurrentLinkedQueue.poll
  1.8%   1.9% java.util.concurrent.ConcurrentLinkedQueue.offer
  1.4%   1.4% org.glassfish.json.JsonGeneratorImpl.writeName
  1.3%   1.3% org.glassfish.json.JsonGeneratorImpl.write
  1.1%   1.1% org.glassfish.json.JsonGeneratorImpl.close
  0.6%   0.6% java.util.Arrays.copyOf
  0.3%   0.3% java.util.Arrays.copyOfRange
  1.1%   1.1% <other>

....[Thread state: WAITING].........................................................................
  1.1% 100.0% sun.misc.Unsafe.park
