package ca.terrylockett.aoc2022.day11;

import java.util.*;

public class Monkey {
    
    private int name;
    private LinkedList<Integer> items;
    private String operationOperator;
    private String operationValue;
    private int test;
    private int trueDestination;
    private int falseDestination;
    
    private int inspectionCount = 0;
    
    private final MonkeyProcessor processor;
    
    public Monkey(MonkeyProcessor processor){
        this.processor = processor;
    }
    
    public void doRound() {

        int listSize = items.size();;
        for(int i=0; i< listSize; i++ ) {  
            Integer item = items.pop();
            inspectionCount++;
            //apply operator
            int operVal = item;
            if(!operationValue.equals("old")){
                operVal = Integer.parseInt(operationValue);
            }
            
            if(operationOperator.equals("*")){
                item *= operVal;
            }
            else if(operationOperator.equals("+")){
                item += operVal;
            }
            
            //divide by 3
            item /= 3;
            
            //check the test
            if( 0 == item%test){
                processor.throwItem(item, trueDestination);
            }
            else {
                processor.throwItem(item, falseDestination);
            }
            
        }
    }
    
    
    
    
    //getters and setters
    public int getInspectionCount() {
        return inspectionCount;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public LinkedList<Integer> getItems() {
        return items;
    }

    public void setItems(LinkedList<Integer> items) {
        this.items = items;
    }

    String getOperationOperator() {
        return operationOperator;
    }

    public void setOperationOperator(String operationOperator) {
        this.operationOperator = operationOperator;
    }

    String getOperationValue() {
        return operationValue;
    }

    public void setOperationValue(String operationValue) {
        this.operationValue = operationValue;
    }

    int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    int getTrueDestination() {
        return trueDestination;
    }

    public void setTrueDestination(int trueDestination) {
        this.trueDestination = trueDestination;
    }

    int getFalseDestination() {
        return falseDestination;
    }

    public void setFalseDestination(int falseDestination) {
        this.falseDestination = falseDestination;
    }
}
