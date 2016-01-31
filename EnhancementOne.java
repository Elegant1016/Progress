/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progress;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author santosh
 */
public class EnhancementOne {

    Map<String, Employee> mapIdEmp = new HashMap<>();
    Map<String, String> mapNameId = new HashMap<>();
    Map<String, String> mapSalId = new HashMap<>();

    String elementKey = null;

    public Map<String, Employee> getMapIdEmp() {
        return mapIdEmp;
    }

    public void setMapIdEmp(Map<String, Employee> mapIdEmp) {
        this.mapIdEmp = mapIdEmp;
    }

    public Map<String, String> getMapNameId() {
        return mapNameId;
    }

    public void setMapNameId(Map<String, String> mapNameId) {
        this.mapNameId = mapNameId;
    }

    public Map<String, String> getMapSalId() {
        return mapSalId;
    }

    public void setMapSalId(Map<String, String> mapSalId) {
        this.mapSalId = mapSalId;
    }

    public void setElementKey(String elementKey) {
        this.elementKey = elementKey;
    }

    public void execute(String colName, String operator) {
        switch (colName) {
            case ColumnNames.COL1:
                System.out.println("Inside ID");
                if (operator.equals(">")) {
                    getGreaterRecords(mapIdEmp);
                } else if (operator.equals("<")) {
                    getLesserRecords(mapIdEmp);
                } else if (operator.equals("=")) {
                    getEqualRecords(mapIdEmp);
                }
                break;
            case ColumnNames.COL2:

                System.out.println("Inside Name");
                if (operator.equals("=")) {
                    for (Map.Entry<String, String> entry : mapNameId.entrySet()) {
                        if (entry.getKey().compareTo(elementKey) == 0) {
                            getRecords(entry.getValue(), mapIdEmp);
                        }
                    }
                } else if (operator.equals("!=")) {
                    for (Map.Entry<String, String> entry : mapNameId.entrySet()) {
                        if (entry.getKey().compareTo(elementKey) != 0) {
                            getRecords(entry.getValue(), mapIdEmp);
                        }
                    }
                }
                break;

            case ColumnNames.COL3:
                System.out.println("Inside Salary");

                if (operator.equals(">")) {
                    for (Map.Entry<String, String> entry : mapSalId.entrySet()) {
                        if (Integer.parseInt(entry.getKey()) > Integer.parseInt(elementKey)) {
                            getRecords(entry.getValue(), mapIdEmp);
                        }
                    }
                } else if (operator.equals("<")) {
                    for (Map.Entry<String, String> entry : mapSalId.entrySet()) {
                        if (Integer.parseInt(entry.getKey()) < Integer.parseInt(elementKey)) {
                            getRecords(entry.getValue(), mapIdEmp);
                        }
                    }
                } else {
                    for (Map.Entry<String, String> entry : mapSalId.entrySet()) {
                        if (Integer.parseInt(entry.getKey()) == Integer.parseInt(elementKey)) {
                            getRecords(entry.getValue(), mapIdEmp);
                        }
                    }
                }

                break;
        }
    }

    private void getGreaterRecords(Map<String, Employee> mapIdEmp) {
        for (Map.Entry<String, Employee> entry : mapIdEmp.entrySet()) {
            if (entry.getValue().getId().compareTo(elementKey) > 0) {
                System.out.print(entry.getValue().getId() + " ");
                System.out.print(entry.getValue().getName() + " ");
                System.out.println(entry.getValue().getSalary());
            }
        }
    }

    private void getLesserRecords(Map<String, Employee> mapIdEmp) {
        for (Map.Entry<String, Employee> entry : mapIdEmp.entrySet()) {

            if (entry.getValue().getId().compareTo(elementKey) < 0) {
                System.out.print(entry.getValue().getId() + " ");
                System.out.print(entry.getValue().getName() + " ");
                System.out.println(entry.getValue().getSalary());
            }

        }
    }

    private void getEqualRecords(Map<String, Employee> mapIdEmp) {
        for (Map.Entry<String, Employee> entry : mapIdEmp.entrySet()) {
            if (entry.getValue().getId().compareTo(elementKey) == 0) {
                System.out.print(entry.getValue().getId() + " ");
                System.out.print(entry.getValue().getName() + " ");
                System.out.println(entry.getValue().getSalary());
            }
        }
    }

    private void getRecords(String value, Map<String, Employee> mapIdEmp) {
        System.out.print(mapIdEmp.get(value).getId() + " ");
        System.out.print(mapIdEmp.get(value).getName() + " ");
        System.out.println(mapIdEmp.get(value).getSalary());
    }

}
