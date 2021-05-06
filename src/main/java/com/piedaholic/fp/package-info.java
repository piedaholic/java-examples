package com.piedaholic.fp;

/*-
Functional interface 	Return type 	Method name 	# of parameters
Supplier<T> 	         T 	            get() 	        0
Consumer<T> 	         void 	         accept(T) 	    1 (T)
BiConsumer<T, U> 	      void 	         accept(T,U) 	 2 (T, U)
Predicate<T> 	         boolean 	      test(T) 	       1 (T)
BiPredicate<T, U> 	   boolean 	      test(T,U) 	    2 (T, U)
Function<T, R> 	      R 	            apply(T) 	    1 (T)
BiFunction<T, U, R> 	   R 	            apply(T,U) 	    2 (T, U)
UnaryOperator<T> 	      T 	            apply(T) 	    1 (T)
BinaryOperator<T> 	   T 	            apply(T,T) 	    2 (T, T)

Convenience methods
Interface instance 	Method return type 	Method name 	Method parameters
Consumer 	        Consumer 	            andThen() 	    Consumer
Function 	        Function 	            andThen() 	    Function
Function 	        Function 	            compose() 	    Function
Predicate 	        Predicate 	         and() 	        Predicate
Predicate 	        Predicate 	         negate() 	    —
Predicate 	        Predicate 	         or() 	        Predicate
*/

/*-
@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> { }
 
@FunctionalInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> { 
   // omitted static methods
}

T apply(T t);         // UnaryOperator
 
T apply(T t1, T t2);  // BinaryOperator

*/

//@formatter:off
/*
Creating a source
Method 	                  Finite or infinite? 	                     Notes
Stream.empty() 	         Finite 	                                 Creates Stream with zero elements
Stream.of(varargs) 	      Finite 	                                 Creates Stream with elements listed
coll.stream() 	            Finite 	                                 Creates Stream from a Collection
coll.parallelStream() 	   Finite 	                                 Creates Stream from a Collection where the stream can run in parallel
Stream.generate(supplier) 	Infinite 	                              Creates Stream by calling the Supplier for each element upon request
Stream.iterate(seed,
unaryOperator) 	         Infinite 	                              Creates Stream by using the seed for the first element and then calling the UnaryOperator for each subsequent element upon request
Stream.iterate(seed,
predicate, unaryOperator) 	Finite or infinite 	                     Creates Stream by using the seed for the first element and then calling the UnaryOperator for each subsequent element upon request. Stops if the Predicate returns false


Terminal stream operations
Method 	      What happens for infinite streams 	Return value 	Reduction
count() 	      Does not terminate 	               long 	         Yes
min()
max() 	      Does not terminate 	               Optional<T> 	Yes
findAny()
findFirst() 	Terminates 	                        Optional<T> 	No
allMatch()
anyMatch()
noneMatch() 	Sometimes terminates 	            boolean 	      No
forEach() 	   Does not terminate 	               void 	         No
reduce() 	   Does not terminate 	               Varies 	      Yes
collect() 	   Does not terminate 	               Varies 	      Yes
*/

/*-
Optional instance methods
Method 	                  When Optional is empty 	                        When Optional contains a value
get() 	                  Throws an exception 	                           Returns value
ifPresent(Consumer c) 	   Does nothing 	                                 Calls Consumer with value
isPresent() 	            Returns false 	                                 Returns true
orElse(T other) 	         Returns other parameter 	                     Returns value
orElseGet(Supplier s) 	   Returns result of calling Supplier 	            Returns value
orElseThrow() 	            Throws NoSuchElementException 	               Returns value
orElseThrow(Supplier s) 	Throws exception created by calling Supplier 	Returns value
*/