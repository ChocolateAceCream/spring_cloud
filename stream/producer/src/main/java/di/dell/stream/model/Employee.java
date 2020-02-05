package di.dell.stream.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String empName;
    private String empID;

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empID=" + empID + "]";
    }
}