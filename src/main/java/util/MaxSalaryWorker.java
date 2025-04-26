package util;

import javax.xml.namespace.QName;

public class MaxSalaryWorker {
    private String name;
    private float salary;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorker\n{" +
                "salary='" + salary +
                '}';
    }
}
