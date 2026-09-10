package gouri.dsa.stack;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Stack;

public class StackProblem {
    public static void main(String[] args) {

        System.out.println("Stack Problems");
        // Story Id: https://github.com/Dilip9/dsa/issues/14
        /**
         * Basic Problem on Monotonic Stack
         * Next Greater Element
         * Next Smaller Element
         * Previous Greater Element
         * Previous Smaller Element
         * Daily Temperatures
         *
         * **/
        int[] arr = {4, 5, 2, 10, 8};
        int[] greaterElement = nextGreaterElement(arr);
        int[] smallerElement = nextSmallerElement(arr);
        Arrays.stream(greaterElement).forEach(n -> System.out.print(n+" "));
        System.out.println();
        Arrays.stream(smallerElement).forEach(n -> System.out.print(n+" "));
        System.out.println();
        int[] previousGreaterElement = previousGreaterElement(arr);
        Arrays.stream(previousGreaterElement).forEach(n -> System.out.print(n+" "));
//        int[] previousSmallerElement = previousSmallerElement(arr);
//        Arrays.stream(previousSmallerElement).forEach(n -> System.out.print(n+" "));


        /**
         *  Medium Problem on Monotonic Stack
         *  Stock Span
         *  Remove K Digits
         *  Asteroid Collision
         *  Sum of Subarray Minimums
         *  Online Stock Span
         *
         * **/
        StackMediumProblem stackMediumProblem = new StackMediumProblem();
        stackMediumProblem.stockSpan();
        stackMediumProblem.removeKDigits();
        stackMediumProblem.asteroidCollision();
        stackMediumProblem.sumOfSubarrayMinimums();
        stackMediumProblem.onlineStockSpan();
        stackMediumProblem.MinAddToMakeValidParentheses();
        stackMediumProblem.nearestSmallerTower();
        stackMediumProblem.nextElementWithGreaterFrequency();


        /**
         * Hard Problem on Monotonic Stack
         * Largest Rectangle in Histogram
         * Maximal Rectangle
         * Trapping Rain Water
         * 132 Pattern
         * Sum of Subarray Ranges
         * Sum of Subarray Minimums
         *
         *
         */

        StackHardProblem stackHardProblem = new StackHardProblem();
        stackHardProblem.largestRectangleInHistogram();
        stackHardProblem.maximalRectangle();
        stackHardProblem.trappingRainWater();
        stackHardProblem.pattern132();
        stackHardProblem.histogramLargestRectangle();
        stackHardProblem.sumOfMaximumsOfAllSubarrays();
        stackHardProblem.sumOfMinimumsOfAllSubarrays();
        stackHardProblem.removeDuplicateLetters();
        stackHardProblem.maxOfMinForEveryWindowSize();

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

    public static int[] previousGreaterElement(int[] arr){
        int n= arr.length;
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return answer;

    }
}
