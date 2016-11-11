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


