Feature: New post

Scenario Outline: Evaluate RPN Expression
       Given the input as <input>
       When I select "evaluate"
       Then the Result fields should be <Result>
Examples:       
|input    |Result    |
|"1 2 +"|"3"|       
|"1 2 3 + -"|"-4"|
|"6 2 * 3 /"|"4"|
|"2 3 ^ 4 5 + +"|"17"|
|"50 % 2 *"|"1"|
|"3 ! 4 5 * +"|"26"|
|"12 3 / !"|"24"|
|"5 1 2 + 4 * + 3 -"|"14"|
     
     


                
                                                            