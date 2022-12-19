package ca.terrylockett.aoc2022.day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class MonkeyProcessor {
    
    Map<Integer, Monkey> monkeys = new HashMap<>();
    
    public void processInput(String inputFile) throws FileNotFoundException {
        
        Scanner scan = new Scanner(new FileInputStream(inputFile));
        
        while(scan.hasNextLine()){
            
            Monkey monkey = new Monkey(this);
            
            //name
            String line = scan.nextLine();
            int count = Integer.parseInt(line.substring(7,8));
            monkey.setName(count);
            monkeys.put(monkey.getName(), monkey);
            
            //item sets
            String[] itemsLine = scan.nextLine().substring(18).split(", ");
            int [] items = Arrays.stream(itemsLine).mapToInt(Integer::parseInt).toArray();
            LinkedList<Integer> intsLinkedList = new LinkedList<>();
            for(int i: items){
                intsLinkedList.add(i);
            }
            monkey.setItems(intsLinkedList);
            
            //operation
            String operationLine = scan.nextLine();
            monkey.setOperationOperator(operationLine.substring(23,24));
            monkey.setOperationValue(operationLine.substring(25));
            
            //test
            String testLine = scan.nextLine();
            monkey.setTest(Integer.parseInt(testLine.substring(21)));
            
            //trueDestination
            String trueDstLine = scan.nextLine();
            monkey.setTrueDestination(Integer.parseInt(trueDstLine.substring(29)));
            
            //falseDestination
            String FalseDstLine = scan.nextLine();
            monkey.setFalseDestination(Integer.parseInt(FalseDstLine.substring(30)));
            
            // skip blank line.
            if(scan.hasNextLine()) {
                scan.nextLine();
            }
        }
    }

    
    public void playNRounds(int n) {
        for(int i=0; i<n; i++){
            playOneRound();
        }
    }

    void playOneRound() {
        for (Map.Entry<Integer, Monkey> integerMonkeyEntry : monkeys.entrySet()) {
            integerMonkeyEntry.getValue().doRound();
        }
    }
    
    public void throwItem(int item, int monkey) {
        monkeys.get(monkey).getItems().add(item);
    }
    
    
    public int getMonkeyBusinessScore() {
        List<Integer> scores = new ArrayList<>();
        
        for(Map.Entry<Integer, Monkey> monkey : monkeys.entrySet()){
            scores.add(monkey.getValue().getInspectionCount());
        }

        Collections.sort(scores);
        return scores.get(scores.size()-1) * scores.get(scores.size()-2);
    }
    

    public Map<Integer, Monkey> getMonkeys() {
        return monkeys;
    }
}
