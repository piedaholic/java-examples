package com.piedaholic.dt;

// Datatypes supported in Java
// Primitive vs Wrapper

// @formatter:off // Turns off formatting and the comments indentation would be preserved
// Also adding - after /* in multiline comments would preserve the identation
/*-
Primitive Data Types
Keyword 	Type 	                        Example
boolean 	true or false 	              true
byte 	    8-bit integral value 	        123
short 	  16-bit integral value 	      123
int 	    32-bit integral value 	      123
long 	    64-bit integral value 	      123L
float 	  32-bit floating-point value 	123.45f
double 	  64-bit floating-point value 	123.456
char 	    16-bit Unicode value 	        'a'

Data Type 	Size 	    Description
byte 	      1 byte 	  Stores whole numbers from -128 to 127
short 	    2 bytes 	Stores whole numbers from -32,768 to 32,767
int 	      4 bytes 	Stores whole numbers from -2,147,483,648 to 2,147,483,647
long 	      8 bytes 	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float 	    4 bytes 	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double 	    8 bytes 	Stores fractional numbers. Sufficient for storing 15 decimal digits
boolean 	  1 bit 	  Stores true or false values
char 	      2 bytes 	Stores a single character/letter or ASCII values

A float requires the letter f following the number so Java knows it is a float.

Each numeric type uses twice as many bits as the smaller similar type. 
For example, short uses twice as many bits as byte does.

All of the numeric types are signed in Java.
This means that they reserve one of their bits to cover a negative range. 
For example, byte ranges from -128 to 127. You might be surprised that the range is not -128 to 128. 
Don’t forget, 0 needs to be accounted for too in the range.

One should be aware that short and char are closely related, as both are stored as integral types with the same 16-bit length. 
The primary difference is that short is signed, which means it splits its range across the positive and negative integers.
Alternatively, char is unsigned, which means range is strictly positive including 0.
Therefore, char can hold a higher positive numeric value than short, but cannot hold any negative numbers.
**/

/*-
Dec  Char                           Dec  Char     Dec  Char     Dec  Char
---------                           ---------     ---------     ----------
  0  NUL (null)                      32  SPACE     64  @         96  `
  1  SOH (start of heading)          33  !         65  A         97  a
  2  STX (start of text)             34  "         66  B         98  b
  3  ETX (end of text)               35  #         67  C         99  c
  4  EOT (end of transmission)       36  $         68  D        100  d
  5  ENQ (enquiry)                   37  %         69  E        101  e
  6  ACK (acknowledge)               38  &         70  F        102  f
  7  BEL (bell)                      39  '         71  G        103  g
  8  BS  (backspace)                 40  (         72  H        104  h
  9  TAB (horizontal tab)            41  )         73  I        105  i
 10  LF  (NL line feed, new line)    42  *         74  J        106  j
 11  VT  (vertical tab)              43  +         75  K        107  k
 12  FF  (NP form feed, new page)    44  ,         76  L        108  l
 13  CR  (carriage return)           45  -         77  M        109  m
 14  SO  (shift out)                 46  .         78  N        110  n
 15  SI  (shift in)                  47  /         79  O        111  o
 16  DLE (data link escape)          48  0         80  P        112  p
 17  DC1 (device control 1)          49  1         81  Q        113  q
 18  DC2 (device control 2)          50  2         82  R        114  r
 19  DC3 (device control 3)          51  3         83  S        115  s
 20  DC4 (device control 4)          52  4         84  T        116  t
 21  NAK (negative acknowledge)      53  5         85  U        117  u
 22  SYN (synchronous idle)          54  6         86  V        118  v
 23  ETB (end of trans. block)       55  7         87  W        119  w
 24  CAN (cancel)                    56  8         88  X        120  x
 25  EM  (end of medium)             57  9         89  Y        121  y
 26  SUB (substitute)                58  :         90  Z        122  z
 27  ESC (escape)                    59  ;         91  [        123  {
 28  FS  (file separator)            60  <         92  \        124  |
 29  GS  (group separator)           61  =         93  ]        125  }
 30  RS  (record separator)          62  >         94  ^        126  ~
 31  US  (unit separator)            63  ?         95  _        127  DEL
*/

/*-
There are only four rules to remember for legal identifiers:

    1. Identifiers must begin with a letter, a $ symbol, or a _ symbol.
    2. Identifiers can include numbers but not start with them.
    3. Since Java 9, a single underscore _ is not allowed as an identifier.
    4. You cannot use the same name as a Java reserved word. 
       A reserved word is special word that Java has held aside so that you are not allowed to use it. Remember that Java is case sensitive, so you can use versions of the keywords that only differ in case. Please don’t, though.

Reserved words
abstract
assert	
boolean
break
byte
case
catch
char
class
const*
continue
default
do
double
else
enum
extends
false**
final
finally
float
for
goto*
if
implements
import
instanceof
int
interface
long
native
new
null** 	
package
private
protected
public
return
short
static
strictfp
super
switch
synchronized
this
throw
throws
transient
true**
try
void
volatile
while
_ (underscore) 	

* The reserved words const and goto aren’t actually used in Java. They are reserved so that people coming from other programming languages don’t use them by accident—and in theory, in case Java wants to use them one day.

** true/false/null are not actually reserved words, but literal values. 
Since they cannot be used as identifier names, we include them in this table.
*/

//@formatter:off
/*
Wrapper class 	Converting String to a primitive 	Converting String to a wrapper class
Boolean 	      Boolean.parseBoolean("true") 	    Boolean.valueOf("TRUE")
Byte 	          Byte.parseByte("1") 	            Byte.valueOf("2")
Short 	        Short.parseShort("1") 	          Short.valueOf("2")
Integer 	      Integer.parseInt("1") 	          Integer.valueOf("2")
Long 	          Long.parseLong("1") 	            Long.valueOf("2")
Float 	        Float.parseFloat("1") 	          Float.valueOf("2.2")
Double 	        Double.parseDouble("1") 	        Double.valueOf("2.2")
Character 	    None 	                            None
*/

/*-
Primitive type 	Wrapper class 	Example of creating
boolean 	      Boolean 	      Boolean.valueOf(true)
byte 	          Byte 	          Byte.valueOf((byte) 1)
short 	        Short 	        Short.valueOf((short) 1)
int 	          Integer 	      Integer.valueOf(1)
long 	          Long 	          Long.valueOf(1)
float 	        Float 	        Float.valueOf((float) 1.0)
double 	        Double 	        Double.valueOf(1.0)
char 	          Character 	    Character.valueOf('c')
*/