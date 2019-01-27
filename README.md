# Code Written in Fall 2017

# Compile

javac *.java

# Usage

java JavaClassAnalyzer <AbsolutePath>

## Program

This program searches through an input directory, builds a list of java files,
and outputs information found to standard output.

It will find all valid java classes (classes whose names are the same as their respective filename), the number of source lines for each class, the number of source lines (excluding comments) for each class, and classes with invalid parenthesis (an open paren without a closing paren).

## Example

When JavaClassAnalyzer is run on this directory, it outputs this.

Valid Classes - Total: 4

Class: JavaClassAnalyzer[/Users/ryandielhenn/programming/cs112/project4/JavaClassAnalyzer.java]

SLOC: 38

SLOC (excluding comments): 31

Class: RecursiveTraversal[/Users/ryandielhenn/programming/cs112/project4/RecursiveTraversal.java]

SLOC: 64

SLOC (excluding comments): 42

Class: JavaClass[/Users/ryandielhenn/programming/cs112/project4/JavaClass.java]

SLOC: 111
SLOC (excluding comments): 66

Class: JavaClassList[/Users/ryandielhenn/programming/cs112/project4/JavaClassList.java]
	
SLOC: 129
SLOC (excluding comments): 100

Total SLOC: 342

Total SLOC (excluding comments): 239

Invalid Classes:

Classes with invalid parenthesis:
/Users/ryandielhenn/programming/cs112/project4/ProcessFile.java
