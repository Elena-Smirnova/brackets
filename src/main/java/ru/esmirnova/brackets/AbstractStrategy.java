package ru.esmirnova.brackets;

public abstract class AbstractStrategy {
    String inputBracketsString;
    String validBracketsString;

    public AbstractStrategy() {}
    public AbstractStrategy(String inputBracketsString) {
        this.inputBracketsString = inputBracketsString;
    }
    public abstract String getValidBrackets(String inputBracketsString);
    public String getValidBrackets() {
        return getValidBrackets(inputBracketsString==null?"":inputBracketsString);
    }
}
