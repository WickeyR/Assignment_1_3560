//Author: Ricky Franco
//18 Feb 2024
//ValidParentheses.java: Determine if a string from the user contains the valid amount of opening-closing brackets

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {

        //Prompt the user to enter a string
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter a valid parentheses string: ");


        String parenthesesString = userInput.nextLine();

        //Return the result to the user based on the output of isValid
        if(isValid(parenthesesString)){
            System.out.println("Congratulations! You are valid!");

        }else{
            System.out.println("Sorry, you entered an invalid parentheses!");
        }
    }


    public static boolean isValid(String parenthesesString){

        //Catches empty strings
        if(parenthesesString.isEmpty()){
            return false;
        }

        //Dictionary containing valid combinations
        HashMap<Character, Character> validParen = new HashMap<>();
        validParen.put(')', '(');
        validParen.put(']', '[');
        validParen.put('}', '{');

        //Create a stack to keep track of most recent opening bracket
        Stack<Character> bracketTracker= new Stack<>();

        //Loop through the entire string to add/remove from the stack when appropriate
        for(char bracket: parenthesesString.toCharArray()){

            //Closing bracket has been detected
            if(validParen.containsKey(bracket)){

                //Checks if the brackets match each other
                if(!bracketTracker.isEmpty() && bracketTracker.lastElement() == validParen.get(bracket)){

                    //Pop the opening bracket from the stack if valid
                    bracketTracker.pop();

                }else{
                    //Brackets do not match (Invalid)
                    return false;
                }
            }else{
                //Potential opening bracket has been added
                bracketTracker.push(bracket);
            }
        }

        //Returns true if stack is completely empty after traversing, this means the string was valid
        return bracketTracker.isEmpty();

    }
}
