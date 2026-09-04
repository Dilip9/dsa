package gouri.dsa.stack;

import javax.swing.plaf.synth.SynthOptionPaneUI;
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
        int[] greaterElement = nextGreaterElement(arr);
        int[] smallerElement = nextSmallerElement(arr);
        Arrays.stream(greaterElement).forEach(n -> System.out.print(n+" "));
        System.out.println();
        Arrays.stream(smallerElement).forEach(n -> System.out.print(n+" "));
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


    public static int[] nextSmallerElement(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack();

        for(int i=n-1; i>=0;i--){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            result[i]= stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;

    }
}
