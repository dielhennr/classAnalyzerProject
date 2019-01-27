/**
 * A class that recursivley traverses a given directory for java files.
 * @author rdielhenn
 */

import java.io.File;
import java.io.FileNotFoundException;

public class RecursiveTraversal {

	/**
	 * Takes an absolute path to a directory as input and returns a JavaClassList
	 * @param directory
	 * @return classList
	 * @throws FileNotFoundException
	 */
	public static JavaClassList findFiles(String directory) throws FileNotFoundException{

		JavaClassList classList = new JavaClassList();

		//create a File object to pass to the helper method instead of a string 
		File file = new File(directory);

		//if the file exists call helper method if not throw fnf
		if (file.exists()){
			findFiles(file, classList);
		}else{
			throw new FileNotFoundException("File not found");
		}
		
		return classList;
	} 

	/**
	 * Recursive helper method
	 * @param directory
	 * @param classList
	 */
	public static void findFiles(File directory, JavaClassList classList){

		//if the File object is a file create a JavaClass object and put it into classList
		if (directory.isFile()){
			if (directory.getName().endsWith(".java")){
				ProcessFile.buildClass(directory, classList);
			}
		}

		//otherwise iterate through the directory and recurse
		else if (directory.isDirectory()){
			File[] files = directory.listFiles();

			//if the directory is not empty
			if (files != null){
				//iterate over files
				for (File file : files)	{
					//make recursive call
					findFiles(file, classList);
				}
			}
		}

	}

}