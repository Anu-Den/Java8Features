package com.letzlearn.java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamCreation {

    /*
     * different ways to create streams
     * */
    public static void main(String[] args) {

        //1. From collections
        List<String> mylist = Arrays.asList("apple", "banana", " mango");
        Stream<String> stream = mylist.stream();

        //2. From Arrays
        Integer[] intarray = {1, 2, 3, 4, 5};
        Stream<Integer> integerStream = Arrays.stream(intarray);

        //3. Directly creating a stream from elements
        Stream<String> streamOfElements = Stream.of("a", "b", "c");

        //4. Using Stream.builder()
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();

        //5. From Files - Lines of a file can be processed as a stream (useful for large files)
        Path path = Paths.get("sample.txt");
        try {
            Stream<String> streamOfString = Files.lines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //6. From Random Numbers - Using Random class for generating infinite streams of random numbers
        Random random = new Random();
        IntStream randomNumbers = random.ints();

        //7. From Existing Streams - Using Stream.concat() to concatenate two streams
        Stream<String> concatenatedStream = Stream.concat(stream, streamOfElements);

        //8. From a Range of Integers - Using IntStream or LongStream for primitive types
        IntStream intStream = IntStream.range(1, 4); // 1, 2, 3
        LongStream longStream = LongStream.rangeClosed(1, 3); // 1, 2, 3

    }
}
