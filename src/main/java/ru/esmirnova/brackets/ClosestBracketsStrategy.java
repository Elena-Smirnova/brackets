package ru.esmirnova.brackets;

public class ClosestBracketsStrategy extends AbstractStrategy {
    char[] invalidBracketsChArray;
    boolean validBracketsFound = true;
    char emptyChar = ' ';
    public ClosestBracketsStrategy(String inputBracketsString) {
        super(inputBracketsString);
    }

    @Override
    public String getValidBrackets(String inputBracketsString) {
        invalidBracketsChArray = inputBracketsString.toCharArray();

        // replacing () with empty chars in invalidBracketsChArray iteratively
        while (validBracketsFound) {
            validBracketsFound = false;
            updateInvalidBracketsArray();
        }

        // reverting the invalidBracketsChArray so that empty chars are filled with input values
        StringBuilder validBracketsSB = new StringBuilder();
        for (int pos=0; pos<invalidBracketsChArray.length; pos++) {
            if (invalidBracketsChArray[pos]==emptyChar) {
                validBracketsSB.append(inputBracketsString.charAt(pos));
            }
        }
        return validBracketsSB.toString();
    }

    private void updateInvalidBracketsArray() {
        for (int pos = 0; pos < invalidBracketsChArray.length; pos++) {
            if (invalidBracketsChArray[pos]=='(') {
                int nearestClosingBracketPos = getNearestClosingBracketPos(pos);
                if (nearestClosingBracketPos > -1) {
                    invalidBracketsChArray[pos] = emptyChar;
                    invalidBracketsChArray[nearestClosingBracketPos] = emptyChar;
                    validBracketsFound = true;
                }
            }
        }
    }

    private int getNearestClosingBracketPos(int pos) {
        for (int nextPos = pos+1; nextPos < invalidBracketsChArray.length; nextPos++) {
            if (invalidBracketsChArray[nextPos]==')') {
                return nextPos;
            }
            if (invalidBracketsChArray[nextPos]!=emptyChar) {
                return -1;
            }
        }
        return -1;
    }


}
