import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        boolean[] inputs = userInput();
        boolean a = inputs[0];
        boolean b = inputs[1];

        // Display results of logical operations
        System.out.println("-----------RESULTS LIST FOR ALL LOGICAL OPERATORS-----------");
        System.out.println("A AND B: " + LogicalOperations.conjunction(a, b));
        System.out.println("A OR B: " + LogicalOperations.disjunction(a, b));
        System.out.println("NOT A: " + LogicalOperations.negation(a));
        System.out.println("NOT B: " + LogicalOperations.negation(b));
        System.out.println("A → B (Implication): " + LogicalOperations.implication(a, b));
        System.out.println("A ↔ B (Biconditional): " + LogicalOperations.biconditional(a, b));

        Main main = new Main();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("-----------------------------TRUTH TABLE----------------------------------");
        System.out.println("(all possible outcomes)");
        ArrayList<String> truthTable = main.generateTruthTable(null);  // Assuming `userInput` isn't needed for this example
        for (String row : truthTable) {
            System.out.println(row);
        }
    }

    public ArrayList<String> generateTruthTable(String[] userInput) {
        ArrayList<String> result = new ArrayList<>();

        // Define the possible boolean values for A and B
        boolean[] values = {true, false};

        // Add a header for the truth table with fixed-width columns
        result.add(String.format("%-6s %-6s %-10s %-10s %-10s %-10s %-10s %-10s",
                "A", "B", "A AND B", "A OR B", "NOT A", "NOT B", "A → B", "A ↔ B"));

        // Loop through all possible values of A and B
        for (boolean a : values) {
            for (boolean b : values) {
                // Calculate each logical operation for the current values of A and B
                boolean andResult = LogicalOperations.conjunction(a, b);
                boolean orResult = LogicalOperations.disjunction(a, b);
                boolean notA = LogicalOperations.negation(a);
                boolean notB = LogicalOperations.negation(b);
                boolean implicationResult = LogicalOperations.implication(a, b);
                boolean biconditionalResult = LogicalOperations.biconditional(a, b);

                // Format each row with fixed-width columns and add it to the result list
                result.add(String.format("%-6s %-6s %-10s %-10s %-10s %-10s %-10s %-10s",
                        a, b, andResult, orResult, notA, notB, implicationResult, biconditionalResult));
            }
        }

        return result;
    }


    // User input function
    public static boolean[] userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in your desired truth AND OR false inputs to have a Truth Table created: ");
        String [] validOptions = {"true", "false", "1", "0"};

        // Evaluate option A
        System.out.println("Input A: ");
        String inputA = scanner.next().toLowerCase();
        while (!validOptions[0].equals(inputA) && !validOptions[1].equals(inputA)) {
            for(String option: validOptions) {
                if(inputA.equals(option)) {
                    break;
                }
            }
            System.out.println("INVALID INPUT. TRY AGAIN.");
            System.out.println("Input A: ");
            inputA = scanner.next();
            if(inputA.equals("1")){ inputA = "true"; }
            else if(inputA.equals("0")){ inputA = "false"; }
        }

        // Evaluate option B
        System.out.println("Input B: ");
        String inputB = scanner.next().toLowerCase();
        while (!validOptions[0].equals(inputB) && !validOptions[1].equals(inputB)) {
            for(String option: validOptions) {
                if (inputB.toLowerCase().equals(option)) {
                    break;
                }
            }
            System.out.println("INVALID INPUT. TRY AGAIN.");
            System.out.println("Input B: ");
            inputB = scanner.next();
            if(inputB.equals("1")){ inputB = "true"; }
            else if(inputB.equals("0")){ inputB = "false"; }
        }

        boolean A = false;
        boolean B = false;
        if (inputA.equals("true")) {
            A = true;
        }
        if (inputB.equals("true")) {
            B = true;
        }

        scanner.close();
        return new boolean[]{A, B};
    }

    public class LogicalOperations {

        // Conjunction (AND)
        public static boolean conjunction(boolean a, boolean b) {
            return a && b;
        }

        // Disjunction (OR)
        public static boolean disjunction(boolean a, boolean b) {
            return a || b;
        }

        // Negation (NOT)
        public static boolean negation(boolean a) {
            return !a;
        }

        // Implication (IF...THEN)
        public static boolean implication(boolean a, boolean b) {
            return !a || b;  // equivalent to "if A then B"
        }

        // Biconditional (IF AND ONLY IF)
        public static boolean biconditional(boolean a, boolean b) {
            return a == b;  // true if both are the same
        }
    }

}