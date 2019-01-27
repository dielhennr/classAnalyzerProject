/**
 * Class that takes as input an absolute path to a directory and prints out data
 * about all of the .java files in that directory and its sub-directories
 * @author rdielhenn
 */
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class JavaClassAnalyzer{
	
	//main
	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: java JavaClassAnalyzer <absolutepath>");
			System.exit(0);
		}

		//RecursiveTraversal.findFiles(...) throws FileNotFoundException
		try{
			JavaClassList classList = RecursiveTraversal.findFiles(args[0]);

			System.out.println("Valid Classes - Total: " + classList.getValidClasses());
			System.out.print(classList.toStringValidClasses());
			System.out.println("Total SLOC: " + classList.getTotalSloc());
			System.out.println("Total SLOC (excluding comments): " + classList.getTotalSlocExComments());

			System.out.println(classList.toStringInvalidClasses());
			System.out.println(classList.toStringInvalidParen());
			

		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage() + "\nStack Trace: " + fnf.getStackTrace());
		}

	}

}