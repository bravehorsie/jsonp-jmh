# jsonp-jmh

JMH project created for testing jsonp.

It appears, there is noticable difference between performance of JsonGeneratorImpl between 1.0.4 and 1.1.0-SNAPSHOT.
Please try:


./run.sh 1.0.4

<table>
<tr><td>Benchmark</td><td>Mode</td><td>Cnt</td><td>Score</td><td>Error</td><td>Units</td></tr>
<tr><td>JsonGeneratorTest.test1JsonbStringWriter</td><td>thrpt</td><td>10</td><td>4484.430</td><td>159.659</td><td>ops/ms</td></tr>
</table>






./run.sh 1.1.0-SNAPSHOT
<table>
<tr><td>Benchmark</td><td>Mode</td><td>Cnt</td><td>Score</td><td>Error</td><td>Units</td></tr>
<tr><td>JsonGeneratorTest.test1JsonbStringWriter</td><td>thrpt</td><td>10</td><td>3256.665</td><td>205.003</td><td>ops/ms</td></tr>
</table>


