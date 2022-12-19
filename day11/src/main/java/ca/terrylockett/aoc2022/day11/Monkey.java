package ca.terrylockett.aoc2022.day11;

import java.util.*;

public class Monkey {
    
    private int name;
    private LinkedList<Long> items;
    private String operationOperator;
    private String operationValue;
    private long test;
    private int trueDestination;
    private int falseDestination;
    
    private long inspectionCount = 0;
    
    private boolean isWorry = true;
    private long MaxItemSize = 0;
    
    private final MonkeyProcessor processor;
    
    public Monkey(MonkeyProcessor processor){
        this.processor = processor;
    }
    
    public void doRound() {

        int listSize = items.size();;
        for(int i=0; i< listSize; i++ ) {  
            long item = items.pop();
            inspectionCount++;
            //apply operator
            long operVal = item;
            if(!operationValue.equals("old")){
                operVal = Long.parseLong(operationValue);
            }
            
            if(operationOperator.equals("*")){
                item *= operVal;
            }
            else if(operationOperator.equals("+")){
                item += operVal;
            }
            
            //divide by 3
            if(isWorry) {
                item /= 3L;
            }
            
            //squash items
            if(MaxItemSize != 0 && item > MaxItemSize) {
                item = item % MaxItemSize;
            }
            
            //check the test
            if( 0 == item % test){
                processor.throwItem(item, trueDestination);
            }
            else {
                processor.throwItem(item, falseDestination);
            }
        }
    }
    
    
    public void setWorry(boolean worry) {
        isWorry = worry;
    }

    public void setMaxItemSize(long maxItemSize) {
        this.MaxItemSize = maxItemSize;
    }

    public long getInspectionCount() {
        return inspectionCount;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public LinkedList<Long> getItems() {
        return items;
    }

    public void setItems(LinkedList<Long> items) {
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

    public long getTest() {
        return test;
    }

    public void setTest(long test) {
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
