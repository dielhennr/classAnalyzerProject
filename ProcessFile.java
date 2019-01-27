/**
 * A class that proccesses a File object and builds a JavaClass object
 * @author rdielhenn
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
public class ProcessFile{

	/**
	 * Builds a JavaClass object out of a File object
	 * @param file
	 * @return thisClass
	 */
	public static void buildClass(File file, JavaClassList classList){
		

		try(Scanner scan = new Scanner(file)){

			//instantiate data members to be added to the JavaClass object
			String className = "";
			int totalLines = 0;
			int commentLines = 0;
			boolean validClass = false;

			//boolean to represent if a line is in a comment block or not
			boolean inCommentBlock = false;

			/*
			stack to keep track of open-closed parenthesis pairing
			boolean to represent if invalid pairing is found
			*/
			Stack<Character> parenthesis = new Stack<Character>();
			boolean validParenthesis = true;
			
			//iterate through lines of the file
			while (scan.hasNextLine()){

				String thisLine = scan.nextLine().trim();

				//increment counter
				totalLines++;

				//if validParenthesis is still true try to find a counter example
				if (validParenthesis){

					//iterate through line
					for (int i = 0; i < thisLine.length(); i++) {

						//if open parenthesis is found, push it onto the stack
						if (thisLine.charAt(i) == '(') {
							parenthesis.push('(');
						}
						//if closed parenthisis is found and the stack isn't empty, pop the stack
						//if the stack is empty set valid parenthesis to false.
						else if (thisLine.charAt(i) == ')') {
							if (!parenthesis.empty()){
								parenthesis.pop();
							}else{
								validParenthesis = false;
							}
						}
		
					}
				}


				//if a line starts with /* , a comment block is entered
				if (thisLine.startsWith("/*")){
					inCommentBlock = true;
					commentLines++;
				}

				//if line ends with */, a comment block is exited
				else if (thisLine.endsWith("*/")){
					inCommentBlock = false;
					commentLines++;
				}

				else if (inCommentBlock || thisLine.startsWith("//")) {
					commentLines++;
				}

				/*
				 * First line that contains the word "class" that is not a comment.
				 * If validClass is true then there was a previous line containing "class" that wasn't a comment line,
				 * however the first instance is the important one hence - if !validClass.
				*/ 

				else if ((!validClass) && (thisLine.contains("class"))) {

					String[] splitLine = thisLine.split("\\s+");

					//find token after "class"
					for (int i = 0; i < splitLine.length-1; i++){
						if (splitLine[i].equals("class")) {
							className += splitLine[i + 1].trim();
							break;
						}
					}

					//if the token after class ends with "{" then the classname is the string without the curly brace.
					if (className.endsWith("{")) {
						className = className.substring(0, className.length() - 1);
						
					}

					//remove .java from end of filename
					String fileName = file.getName().substring(0, file.getName().length() - 5);

					//check if class name and file name are equal
					if (className.equals(fileName)) {
						validClass = true;
					}
					

				}


			}

			//After iterating through every line, the stack should be emtpy because every parenthesis should have
			//a corresponding one. If its not empty then the parenthesis in the file are invalid
			if (!parenthesis.empty()) {
				validParenthesis = false;
			}

			//create a JavaClass object if the class is valid and add it to the class list
			if (validClass && validParenthesis){
				JavaClass thisClass = new JavaClass(file.getAbsolutePath(), className, totalLines, totalLines - commentLines);
				classList.addClass(thisClass);
			}
			//otherwise add the absolute path of the invalid class to the class list
			//(addClass adds to a serparate ArrayList in JavaClassList if adding a string instead of a JavaClass)
			else if (!validClass && validParenthesis){
				classList.addClass(file.getAbsolutePath(), validParenthesis);
			}

			else if (!validParenthesis) {
				classList.addClass(file.getAbsolutePath(), validParenthesis);
			}
			

		}catch(FileNotFoundException fnf){
			System.out.println(fnf.getMessage());
		}
		

	}


}