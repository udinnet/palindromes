##Unique palindromes
This is a solution built for finding and printing 3 longest *unique* palindrome strings in a given input string. 
This solution's core algorithm based on famous Manacher’s algorithm which has the time complexity of O(n). But in
this specific solution there is one more additional step in the algorithm to find the next longest unique palindrome
in a recursive fashion. So in worse case, this algorithm will operate with a time complexity of O(n2).

Although this specific solution runner is setup to find only 3 longest palindromes, the solution class is designed in an
extensible way that it can handle all the general unique palindrome search scenarios in a string with the help of 
configurations.
(explained in below section).

###Compiling and running
**Build Requirements**
- Java JDK >=1.8
- Maven >=3
- An internet connection (Not required if the build system has all the necessary versions maven dependencies required by
                            this project)
                            
**Building**
- Using a command line (cmd for windows, default terminal shell for mac/linux), change the directory to project root.
- Then issue the following maven command `mvn clean compile`. This should build the project and install the class files in
`<project_root>/target` directory.
- To run the main application issue the following command, `mvn exec:java`. Or one case do the building and running of main
application in single command by issuing `mvn clean compile exec:java`.
- Running of applications should print following output
```
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ palindromes ---
Text: hijkllkjih, Index: 23, Length: 10
Text: defggfed, Index: 13, Length: 8
Text: abccba, Index: 5, Length: 6
```
**Tests**
* The unit tests can be run by issuing `mvn clean test` command.

**Configuration**
- The depth of the algorithm recursion can be adjusted to maximize the performance needs according to the use case. By
default, recursion depth is set to 2. This is set as a maven property value in pom.xml file and the property key is
`recursion.depth.value`. Even if that key's value is empty, default value will set as 2. If this value is set to 0, The
recursion depth is set to `unlimited` and the algorithm will terminate after resolving single character level (which are not
part of another palindrome sub-string) as the end condition.
- The main Runner can be externally configured to print custom number of longest palindromes and it can also accept custom
input strings.
    - The command line arg format of the runner is `mvn clean compile exec:java -Dexec.args="<input_string> <max_length_count>"`.
    For example : To print 2 longest palindrome strings of input string `assdefffgtggghf`, issuing following command will 
    do the trick `mvn clean compile exec:java -Dexec.args="assdefffgtggghf 2"`.
    
    ```
    [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ palindromes ---
    Text: gtggg, Index: 8, Length: 5
    Text: fff, Index: 5, Length: 3
    ```
  