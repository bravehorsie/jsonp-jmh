/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.glassfish.json;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import javax.json.spi.JsonProvider;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@Timeout(time = 20, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
@Warmup(iterations = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JsonGeneratorTest {

    private JsonProvider provider;


    @Setup(Level.Trial)
    public void setup() {
        provider = JsonProvider.provider();
    }

    @Benchmark
    public void test1JsonbStringWriter(Blackhole bh) {
        StringWriter jsonbWriter = new StringWriter();
        JsonGenerator jsonbGenerator = provider.createGenerator(jsonbWriter);

        jsonbGenerator.writeStartObject();
        jsonbGenerator.write("val1", "str1");
        jsonbGenerator.write("val2", "str2");
        jsonbGenerator.write("val3", "str3");
        jsonbGenerator.write("val4", "str4");
        jsonbGenerator.write("val5", "str5");
        jsonbGenerator.writeEnd();
        jsonbGenerator.flush();
        jsonbGenerator.close();

        final String result = jsonbWriter.toString();
        bh.consume(result);
    }

}
