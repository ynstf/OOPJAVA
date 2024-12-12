# README

## Exercise 1: Creating the `Talkative` Class

In this exercise, we created a `Talkative` class in Java. This class contains:
- An integer attribute initialized via a constructor.
- The class implements the `Runnable` interface, allowing it to be executed in a thread.
- The `run()` method of the class prints the value of the attribute 100 times.

### Techniques Used
- Using a private attribute to encapsulate data.
- Implementing the `Runnable` interface to allow the class to be executed in a thread.
- Overriding the `run()` method to define the thread's behavior.

### Code Snippet
```java
public class Talkative implements Runnable {
    private int attribute;

    public Talkative(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(attribute);
        }
    }
}
```

### Code Snippet from `Talkative.java`

```java
Thread[] threads = new Thread[10];
for (int i = 0; i < 10; i++) {
    Talkative talkative = new Talkative(i);
    threads[i] = new Thread(talkative);
    threads[i].start();
}
```

#### Explanation
- **Thread Array Initialization**: The line `Thread[] threads = new Thread[10];` initializes an array to hold 10 `Thread` objects. This allows us to manage multiple threads simultaneously.

- **Loop for Thread Creation**: The `for` loop iterates 10 times, creating a new instance of the `Talkative` class in each iteration. Each instance is initialized with a unique integer value (from 0 to 9) that is passed to the constructor of `Talkative`.

- **Thread Creation and Start**:
  - `threads[i] = new Thread(talkative);` creates a new `Thread` object, passing the `Talkative` instance as the target for the thread. This means that when the thread runs, it will execute the `run()` method defined in the `Talkative` class.
  - `threads[i].start();` starts the thread, which triggers the execution of the `run()` method in the `Talkative` instance. Each thread will print the value of its attribute (the integer passed during initialization) 100 times.

#### Purpose
- This code demonstrates the basic principles of multi-threading in Java. By creating multiple threads that run concurrently, the program can perform tasks simultaneously, which is particularly useful for improving performance in applications that require parallel processing.

#### Realization
- When this code is executed, you will see the output of the integer values printed to the console. Each thread will print its assigned value 100 times, resulting in a total of 1000 printed lines (10 threads × 100 prints each). The output may appear interleaved due to the concurrent execution of threads.

### Summary
The `Talkative` class is designed to demonstrate the basic concept of object-oriented programming in Java. By encapsulating the `attribute`, we ensure that its value can only be modified through the constructor. Implementing `Runnable` allows the class to be executed in a multi-threaded context, with the `run()` method defining the thread's behavior.

## Exercise 2: Multi-Threaded Summation

In this exercise, we created an application that calculates the sum of an array of integers using multiple threads.

### Files Present
- `Main.java`: Contains the `main` method that creates and manages the threads.
- `Summer.java`: Implements `Runnable` and calculates the sum of a range of integers.

### Techniques Used
- Creating threads to perform calculations in parallel.
- Dividing an array into sub-parts for each thread.

### Main.java
#### Code Snippet
```java
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numberOfThreads = 2;

        Thread[] threads = new Thread[numberOfThreads];
        Summer[] summers = new Summer[numberOfThreads];

        int partSize = array.length / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            int start = i * partSize + 1;
            int end = (i == numberOfThreads - 1) ? array.length : (i + 1) * partSize;
            summers[i] = new Summer(start, end);
            threads[i] = new Thread(summers[i]);
            threads[i].start();
        }
    }
}
```

#### Summary
The `Main` class divides an array of integers into two equal parts and creates a thread for each part. Each thread executes an instance of `Summer`, which calculates the sum of the integers in its assigned range.

### Summer.java
#### Code Snippet
```java
public class Summer implements Runnable {
    private int start;
    private int end;
    private long result;

    public Summer(int start, int end) {
        this.start = start;
        this.end = end;
        this.result = 0;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            result += i;
        }
    }

    public long getSum() {
        return result;
    }
}
```

#### Summary
The `Summer` class is responsible for calculating the sum of a range of integers. It stores the start and end values to determine the range to sum. The `run()` method performs the summation, and `getSum()` allows access to the result.
