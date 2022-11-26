package ru.esmirnova.brackets;

public class EarliestBracketStrategy extends AbstractStrategy {
    public EarliestBracketStrategy(String inputBracketsString) {
        super(inputBracketsString);
    }
    @Override
    public String getValidBrackets(String inputBracketsString){
        // initial values for the output string and for service counters
        //int correctBracketsInt = 0;
        int openBracketsInt = 0;
        int closeBracketsInt = 0;
        StringBuilder correctBracketsStringB = new StringBuilder();

        // loop through the chars of the input string
        for (int pos=0; pos<inputBracketsString.length(); pos++) {
            // if for '(' exists subsequent ')', then this bracket is correct
            if (inputBracketsString.charAt(pos)=='(') {
                openBracketsInt++;
                closeBracketsInt = 0;
                for (int posClose=pos+1; posClose<inputBracketsString.length(); posClose++) {
                    if (inputBracketsString.charAt(posClose)==')') {
                        closeBracketsInt++;
                        if (closeBracketsInt>=openBracketsInt) {
                            //correctBracketsInt++;
                            correctBracketsStringB.append("(");
                            break;
                        }
                    }
                }
            }
            // if for ')' there's a number of preceding open brackets, then this bracket is correct
            // and the number of open brackets is reduced by 1
            else if (inputBracketsString.charAt(pos)==')') {
                if (openBracketsInt>0) {
                    //correctBracketsInt++;
                    correctBracketsStringB.append(")");
                    openBracketsInt--;
                }
            }
        }
        return correctBracketsStringB.toString();
    }
}
