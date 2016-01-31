/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author santosh
 */
class Utility{
    ParseFile p = new ParseFile();
    ValidQueries q = new ValidQueries();
    Map<String, Employee> mapIdEmp = new HashMap<>();
    Map<String, String> mapNameId = new HashMap<>();
    Map<String, String> mapSalId = new HashMap<>();
    
    public void setUpDBkindOf()
    {
        p.parseFunction();
        List<Employee> listEmp = p.getListEmp();
        for(Employee e: listEmp){
            mapIdEmp.put(e.getId(), e);
            mapNameId.put(e.getName(), e.getId());
            mapSalId.put(e.getSalary(), e.getId());
        }
    }

    public Map<String, Employee> getMapIdEmp() {
        return mapIdEmp;
    }

    public Map<String, String> getMapNameId() {
        return mapNameId;
    }

    public Map<String, String> getMapSalId() {
        return mapSalId;
    }
    
}

public class MainApp {
    public static void main(String[] args) {
        ValidQueries q = new ValidQueries();
        q.populateValidator();
        Utility u = new Utility();
        u.setUpDBkindOf();
        Map<String, Employee> mapIdEmp = u.getMapIdEmp();
        Map<String, String> mapNameId = u.getMapNameId();
        Map<String, String> mapSalId = u.getMapSalId();
        
        System.out.println("Please enter query:");
        Scanner input = new Scanner(System.in);
        String query = input.nextLine();
        StringTokenizer st = new StringTokenizer(query);
        int count = 1;
        while(st.hasMoreTokens()){
            String checkStr = st.nextToken();
            if(q.validate(count,checkStr)){
                count++;
            }
            if (count == 6 && q.colNames.size() == 1) {
                System.out.println("Inside Enhancement 1");
                EnhancementOne enhan1 = new EnhancementOne();
                checkStr = st.nextToken();
                enhan1.setMapIdEmp(mapIdEmp);
                enhan1.setMapNameId(mapNameId);
                enhan1.setMapSalId(mapSalId);
                enhan1.setElementKey(checkStr);
                enhan1.execute(q.colNames.remove(), q.operatorSeq.remove());
            }
        }
        if(count == 3){
            System.out.println("Query:" + query);
            for (Map.Entry<String, Employee> entry : mapIdEmp.entrySet())
            {
                System.out.print(entry.getValue().getId() + " ");
                System.out.print(entry.getValue().getName() + " ");
                System.out.println(entry.getValue().getSalary());
            }
        }
    }    
}
