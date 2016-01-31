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
class Employee {
    private String Id;
    private String name;
    private String salary;

    void setId(String str) {
        this.Id = str;
    }

    void setName(String str) {
        this.name = str;
    }

    void setSalary(String str) {
        this.salary = str;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}
