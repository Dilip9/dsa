package gouri.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackProblem {
    public static void main(String[] args) {
        System.out.println("Stack Problems");
        // Story Id: https://github.com/Dilip9/dsa/issues/14
        /**
         * Problem on Monotonuic Stack
         * Next Greater Element
         * Next Smaller Element
         * Previous Greater Element
         * Previous Smaller Element
         * Largest Rectangle in Histogram
         *
         * **/
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElement(arr);
        Arrays.stream(result).forEach(System.out::println);
    }
    public static int[] nextGreaterElement(int[] arr){
        int[] answer = new int[arr.length];
        answer[arr.length-1] = -1; // Initialize all elements to -1
        Stack<Integer> stack = new Stack();
        for(int i= arr.length -1; i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            answer[i]= stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return answer;
    }
}
