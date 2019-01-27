/**
 * JavaClass is a class to represent a .java file and some of its properties.
 * Implements the comparable interface by least to greatest number of source lines of code in the class.
 * @author rdielhenn
 */
public class JavaClass implements Comparable<JavaClass> {
	
	//data members
	private String absolutePath;
	private String className;
	private int sloc;
	private int slocExComments;
	
	/**
	 * Constructor
	 * @param absolutePath
	 * @param className
	 * @param sloc
	 * @param slocExComments
	 */
	public JavaClass(String absolutePath, String className, int sloc, int slocExComments) {
		this.absolutePath = absolutePath;
		this.className = className;
		this.sloc = sloc;
		this.slocExComments = slocExComments;
	}

	/**
	 * @return absolutePath
	 */
	public String getAbsolutePath() {
		return absolutePath;
	}
	

	/**
	 * @param absolutePath sets absolutePath
	 */
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}
	

	/**
	 * @return className
	 */
	public String getClassName() {
		return className;
	}
	

	/**
	 * @param className sets className
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	
	/**
	 * @return sloc
	 */
	public int getSloc() {
		return sloc;
	}

	
	/**
	 * @param sloc sets sloc
	 */
	public void setSloc(int sloc) {
		this.sloc = sloc;
	}
	

	/**
	 * @return slocExComments
	 */
	public int getSlocExComments() {
		return slocExComments;
	}
	

	/**
	 * @param slocExComments sets slocExComments 
	 */
	public void setSlocExComments(int slocExComments) {
		this.slocExComments = slocExComments;
	}
	
	/**
	 * compareTo method
	 * @param other
	 * @return difference between this classes number of source lines and other classes
	 */

	public int compareTo(JavaClass other){
		return this.sloc - other.getSloc();
	}
	
	/**
	 * @return String representation of JavaClass
	*/
	public String toString() {
		return "Class: " + this.className + "[" + this.absolutePath + "]\n\tSLOC: " + sloc
				+ "\n\tSLOC (excluding comments): " + slocExComments;
	}
	
	

}