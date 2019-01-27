/**
 * A list of JavaClass
 * @author rdielhenn
 */
import java.util.ArrayList;
import java.util.Collections;
public class JavaClassList{

	//data members
	private ArrayList<JavaClass> classList;
	private ArrayList<String> invalidClassList;
	private ArrayList<String> invalidParenList;

	/**
	 * Constructor
	 */
	public JavaClassList() {
		classList = new ArrayList<JavaClass>();
		invalidClassList = new ArrayList<String>();
		invalidParenList = new ArrayList<String>();
	}

	/**
	 * @param newClass
	 */
	public void addClass(JavaClass newClass) {

		classList.add(newClass);
	}

	/**
	 * @param invalidClassPath
	 */
	public void addClass(String invalidClassPath, boolean validParenthesis) {

		if (validParenthesis) {
			invalidClassList.add(invalidClassPath);
		}else{
			invalidParenList.add(invalidClassPath);
		}
	}

	/**
	 * @return number of valid classes
	 */
	public int getValidClasses() {
		return classList.size();
	}

	/**
	 * @return sum of sloc across all valid JavaClass objects
	 */
	public int getTotalSloc() {

		int sum = 0;

		for (JavaClass c : classList) {
			
			sum += c.getSloc();

		}
		return sum;
	}

	/**
	 * @return sum of sloc excluding comments across all JavaClass objects
	 */
	public int getTotalSlocExComments() {
		int sum = 0;

		for (JavaClass c: classList) {
			
			sum += c.getSlocExComments();
		}

		return sum;
	}

	/**
	 * @return string representation of valid JavaClass in sorted order
	 */
	public String toStringValidClasses() {

		String output = "";

		Collections.sort(classList);

		for (JavaClass c : classList) {

			output += c.toString() + "\n";
		}

		return output;
		
	}

	/**
	 * @return string representation of invalid JavaClass
	 */
	public String toStringInvalidClasses() {

		String output = "Invalid Classes: \n";

		Collections.sort(invalidClassList);

		for (String c : invalidClassList) {
			output += c + "\n";
		}

		return output;
	}

	public String toStringInvalidParen() {


		String output = "Classes with invalid parenthesis: \n";

		Collections.sort(invalidParenList);

		for (String c : invalidParenList) {
			output += c + "\n";
		}

		return output;

	}


}