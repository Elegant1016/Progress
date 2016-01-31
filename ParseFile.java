/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package progress;

/**
 *
 * @author santosh
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ParseFile {
    
    List<Employee> empList = new ArrayList();
    String curCol = null;
    
    public void parseFunction() {
        try
        {
            String absolutePath = new File("").getAbsolutePath();
            FileReader fin = new FileReader(absolutePath + "/src/progress/employees.txt");
            Scanner fileRead = new Scanner(fin);
            
            String line;
            int count = 0;
            Employee tmpEmp=null;
            while(fileRead.hasNextLine())
            {
                line = fileRead.nextLine();
                count = getSpaceCount(line);
                StringTokenizer st = new StringTokenizer(line);
                String str = null;
                switch(count){
                    case 0:
                        System.out.println(st.nextToken());
                        break;
                    case 1:
                        str = st.nextToken();
                        if(str.equalsIgnoreCase(ColumnNames.COL1)){
                            tmpEmp = createEmployee();
                            curCol = ColumnNames.COL1;
                        }
                        else if (str.equalsIgnoreCase(ColumnNames.COL2))
                            curCol= ColumnNames.COL2;                            
                        else 
                            curCol = ColumnNames.COL3;
                        break;
                        
                    case 2:
                        str = st.nextToken();
                        if(curCol.equalsIgnoreCase(ColumnNames.COL1)){
                            tmpEmp.setId(str);
                            
                        }
                        else if (curCol.equalsIgnoreCase(ColumnNames.COL2))
                            tmpEmp.setName(str);
                        else 
                        {
                            tmpEmp.setSalary(str);
                            empList.add(tmpEmp);
                        }
                        break;
                }
            }
            
        }
        catch(IOException e)
        {
            System.err.println(e);
        }        
        
    }

    private int getSpaceCount(String line) {
        char[] toChar = line.toCharArray();
        int i=0;
        while(toChar[i] != 0)
        {
            if(toChar[i] != ' ')
                break;
            else
                i++;
        }
        return i;
    }
 
    public void printList() {
        System.out.println("List is :");
        for(Employee e : empList){
            System.out.println("ID :" + e.getId());
            System.out.println("Name :" + e.getName());
            System.out.println("Salary :" + e.getSalary());
        }
        
    }
    
    public List<Employee> getListEmp(){
        return empList;
    }

    private Employee createEmployee() {
        Employee tmp = new Employee();
        return tmp;
    }
}
