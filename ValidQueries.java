/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progress;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author santosh
 */
public class ValidQueries {
    public Map<Integer, List<String>> validatorMap = new HashMap<>();
    public Set<String> columnSet = new HashSet<>();
    public Set<String> operatorSet = new HashSet<>();
    public Queue<String> colNames = new LinkedList<>();
    public Queue<String> operatorSeq = new LinkedList<>();

    public void populateValidator(){
        validatorMap.put(1, Arrays.asList("select","Select"));
        validatorMap.put(2, Arrays.asList("*","ID","id"));
        validatorMap.put(3, Arrays.asList("where","Where","order"));
        validatorMap.put(4, Arrays.asList("by"));
        validatorMap.put(5, Arrays.asList(""));
        validatorMap.put(6, Arrays.asList(""));
        validatorMap.put(7, Arrays.asList("order"));
        validatorMap.put(8, Arrays.asList("by"));
        
        columnSet.add("ID");
        columnSet.add("Name");
        columnSet.add("Salary");
        
        for (String s : Arrays.asList("=","!=", "<",">","order by"))
            operatorSet.add(s);
    }

    public Map<Integer, List<String>> getValidatorMap() {
        return validatorMap;
    }

    public Set<String> getColumnSet() {
        return columnSet;
    }

    public Queue<String> getColNames() {
        return colNames;
    }

    public Set<String> getOperatorSet() {
        return operatorSet;
    }
    
    boolean validate(int count, String checkStr) {
        
        if(validatorMap.get(count).contains(checkStr)){
            return true;
        }
        else if(validatorMap.get(count).contains(checkStr) || columnSet.contains(checkStr)){
            colNames.add(checkStr);
            return true;
        }else if(validatorMap.get(count).contains(checkStr) || operatorSet.contains(checkStr)){
           operatorSeq.add(checkStr);
            return true;
        }
            
        return false;
    }
    
}


