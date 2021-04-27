package com.piedaholic.ds.linear.collections.List;

//@formatter:off
/*
 	                                            toArray() 	Arrays.asList() 	List.of()
Type converting from 	                        List 	    Array (or varargs) 	Array (or varargs)
Type created 	                                Array 	    List 	            List
Allowed to remove values from created object 	No 	        No 	                No
Allowed to add values							No			No					No
Allowed to change values in the created object 	Yes 	    Yes 	            No
Changing values in the created object affects  	No 	        Yes 	            N/A
the original or vice versa.

Arrays.asList() and List.of(), both create fixed length list
*/

/*
ArrayList does override equals() and defines it as the same elements in the same order.
Hence alling equals() on two equivalent ArrayList objects returns true.
*/