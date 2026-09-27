package Recursion;

import java.util.*;

class _16_LetterCombinationsOfAPhoneNumber {

    /*
     * Problem:
     * Given a string containing digits from 2 to 9,
     * return all possible letter combinations that
     * the number could represent.
     *
     * Phone mapping:
     *
     * 2 → abc
     * 3 → def
     * 4 → ghi
     * 5 → jkl
     * 6 → mno
     * 7 → pqrs
     * 8 → tuv
     * 9 → wxyz
     *
     * Example 1:
     *
     * Input:
     * digits = "23"
     *
     * Output:
     * [
     *   "ad","ae","af",
     *   "bd","be","bf",
     *   "cd","ce","cf"
     * ]
     *
     * Example 2:
     *
     * Input:
     * digits = "2"
     *
     * Output:
     * ["a","b","c"]
     *
     * Example 3:
     *
     * Input:
     * digits = ""
     *
     * Output:
     * []
     *
     * Key Pattern:
     *
     * For every digit:
     * 1. Get its possible letters
     * 2. Try each letter
     * 3. Add the letter to current
     * 4. Recurse for the next digit
     * 5. Undo the letter
     */

    static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        String[] mapping = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        // Write your code here

        generate(digits,0,"",mapping,result);
        return result;
    }

    static void generate(
            String digits,
            int index,
            String current,
            String[] mapping,
            List<String> result) {

        // Write your code here
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String s = mapping[digits.charAt(index) - '0'];
        for(int i=0;i<s.length();i++){
            generate(digits,index+1,current+s.charAt(i),mapping,result);
        }

    }

    // ---------------- TEST HARNESS ----------------

    static void test(
            String digits,
            List<String> expected) {

        List<String> actual =
                letterCombinations(digits);

        Set<String> expectedSet =
                new HashSet<>(expected);

        Set<String> actualSet =
                new HashSet<>(actual);

        if (expectedSet.equals(actualSet)) {

            System.out.println("PASS");

        } else {

            System.out.println("FAIL");
            System.out.println("Digits   : " + digits);
            System.out.println("Expected : " + expected);
            System.out.println("Actual   : " + actual);
        }
    }

    // ---------------- MAIN ----------------

    public static void main(String[] args) {

        test(
            "23",
            Arrays.asList(
                "ad","ae","af",
                "bd","be","bf",
                "cd","ce","cf"
            )
        );

        test(
            "2",
            Arrays.asList(
                "a","b","c"
            )
        );

        test(
            "",
            Arrays.asList()
        );

        test(
            "7",
            Arrays.asList(
                "p","q","r","s"
            )
        );
    }
}