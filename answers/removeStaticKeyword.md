In Java, what happens when you remove the keword `static` from a main method? If there is an error, do you see it at compile time or run time?

There is no compile time error. A method named `main` without the `static` designation is fine as far as the compiler is concerned. However, since a non-static method cannot be called without instatiating the class that it resides in, there will be a run-time error if you try to run the class. The JVM will not be able to locate the `main` method unless it is declared (by convention) as `public static void main`.
