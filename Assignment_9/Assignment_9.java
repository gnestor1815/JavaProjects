package Assignment_9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Stack;

public class Assignment_9 {
	
	static Path filePath = Path.of("TestCode.txt");
	static File fileName = new File("TestCode.txt");
    public static void main(String args[]) throws IOException {
    	String content = Files.readString(filePath);
    	System.out.println(fileName.getName());
        System.out.println(balancedParenthensies(content));
        
    }

    public static String balancedParenthensies(String s) {
        Stack<Character> stack  = new Stack<Character>();
        String output = null;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '/') {
                char f = s.charAt(i+1);
            	if(f == '*') {
            		i=i+2;
                    c = s.charAt(i);
            		while (c != '/') {
            			i++;
                        f = s.charAt(i+1);
                        c = s.charAt(i);
            		}
            	} else if (f == '/') {
            		while (c != '\n' && c != '\r') {
            			i++;
                        c = s.charAt(i);
            			}
            		}
            	}
            
            if(c == '[' || c == '(' || c == '{' ) {     
                stack.push(c);
            } else if(c == ']') {
                if(stack.isEmpty()) {
                	output = "Not Balanced: Stack is Empty, found ]";
                    return output;
                } else if (stack.peek() != '[') {
                	switch (stack.peek()) {
                	case '(':
                    	output = "Not Balanced: Expected ), found ]";
                    	break;
                	case '{':
                    	output = "Not Balanced: Expected }, found ]";
                    	break;
                	}
                	return output;
                } else {
                	stack.pop();
                }
            } else if(c == ')') {
            	if(stack.isEmpty()) {
                	output = "Not Balanced: Stack is Empty, found )";
                    return output;
                } else if (stack.peek() != '(') {
                	switch (stack.peek()) {
                	case '[':
                    	output = "Not Balanced: Expected ], found )";
                    	break;
                	case '{':
                    	output = "Not Balanced: Expected }, found )";
                    	break;
                	}
                	return output;
                } else {
                	stack.pop();
                }        
            } else if(c == '}') {
            	if(stack.isEmpty()) {
                	output = "Not Balanced: Stack is Empty, found }";
                    return output;
                } else if (stack.peek() != '{') {
                	switch (stack.peek()) {
                	case '(':
                    	output = "Not Balanced: Expected ), found }";
                    	break;
                	case '[':
                    	output = "Not Balanced: Expected ], found }";
                    	break;
                	}
                	return output;
                }else {
                	stack.pop();
                }
            }

        }
        if (stack.isEmpty()) {
        	output = "Balanced";
        	return output;
        } else {
        	output = "Not Balanced: Stack is not Empty";
        	return output;
        }
    }
}
