# CO Simulator

> An assembler and hardware simulator for the Basic Computer, a 16 bit computer.

<img src="Capture.png">

This is a JavaFX application that compiles assembly code for and runs a simulation of Computer as detailed in:

Computer System Architecture, 3rd edition
by M. Morris Mano
Published by Prentice-Hall, c 1993
Chapter 5, pp 123-172.

## Usage

Make sure you have Java and JavaFX installed. Some Java installations bundle JavaFX, but some do not.

## Simulator Examples:
###  Addition of two Number `X` + `Y`

```Assembly
LDA X
ADD Y
STA RESULT
HLT

X, DEC 10
Y, DEC 123
RESULT, DEC 0
```

`RESULT` is 133 (HEX 85)


### Subtraction of two Numbers: A-B 

```Assembly
LDA A
CMA
INC
ADD B
STA C
HLT
A, DEC 25
B, DEC 10
C, DEC 0
END

```

`RESULT` is `000F` (DEC 15)
### Double Precision Number addition

```Assembly
/CL=AL+BL CH=AH+BH
LDA AL
ADD BL
STA CL
CLA
CIL
ADD AH
ADD BH
STA CH
HLT
AL, DEC 3
AH, DEC 4
BL, DEC 3
BH, DEC 1

CL, DEC 0
CH, DEC 0
END
```

`RESULT` is `0005`

### Change `RESULT` variable to `!X`

```Assembly
LDA X
CMA
STA RESULT
HLT

X, HEX F0F0
RESULT, HEX 0000
```

`RESULT` is `0F0F`
### Subroutine - Add two Numbers:

```Assembly
/Subroutine to add two numbers
ORG 10
BSA AD1
STA T
HLT
A, DEC 5
B, DEC 10
T, DEC 0
AD1, HEX 0
LDA A
ADD B
BUN AD1 I
END
```

`RESULT` is `000F` (DEC=15)

### `X` * `Y` multiplication

```Assembly
//Mltiply two numbers

ORG 100
LOP, CLE
LDA Y
CIR
STA Y
SZE
BUN ONE
BUN ZRO

ONE, LDA X
ADD P
STA P
CLE

ZRO, LDA X
CIL
STA X
ISZ CTR
BUN LOP
HLT

CTR, DEC -8
X, DEC 5
Y, DEC 3
P, DEC 0
END
```

`RESULT` is `000F` (DEC 15)

### LOOP - Add five Numbers:

```Assembly
/Loop to add 5 numbers
ORG 100
LDA ADS
STA PTR
LDA NBR
STA CTR
CLA
LOP, ADD PTR I
ISZ PTR
ISZ CTR
BUN LOP
STA SUM
HLT
ADS, HEX 200
PTR, HEX 0
NBR, DEC -5
CTR, HEX 0
SUM, HEX 0
ORG 200
DEC 5
DEC 2
DEC 1
DEC 1
DEC 1
END

```

`RESULT` is `000A` (DEC 10)


### `X` AND `Y`

```Assembly
LDA X
AND Y
STA RESULT
HLT

X, HEX FF0F
Y, HEX 00F0
RESULT, HEX 0000
```

`RESULT` is `0000`

### `X` NAND `Y`

```Assembly
//NAND (XY)`
LDA X
AND Y
CMA
STA RESULT
HLT

X, HEX FF0F
Y, HEX 00F0
RESULT, HEX 0000
```

`RESULT` is `FFFF`

### `X`, `Y` variables XNOR Code

```Assembly
LDA X
AND Y
CMA
STA T
LDA X
CMA
STA W
LDA Y
CMA
AND W
CMA
AND T
CMA
STA RESULT
HLT

X, HEX FFFF
Y, HEX FFFF
T, HEX 0000
W, HEX 0000
RESULT, HEX 0000
```

`RESULT` is `FFFF`

### Input two number and display the sum (Input-Output Instructions):

```Assembly
/a program to input two numbers
/and display their sum
//it sums unicode value of inputted data

ORG 100
BSA IN
LDA SUM
COF, SKO
BUN COF
OUT
HLT

IN, HEX 0
FST, SKI
BUN FST
INP
STA A
OUT
SCD, SKI
BUN SCD
INP
STA B
OUT
ADD A
STA SUM
BUN IN I

A, DEC 0
B, DEC 0
SUM, DEC 0

END
```

`RESULT`: <br>
Input A: 5 <br>
Input B: 10 <br>
15

## Contact

 © [Prashant Bhandari](https://github.com/techprahant)
