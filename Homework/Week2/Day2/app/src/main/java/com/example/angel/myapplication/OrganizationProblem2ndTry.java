package com.example.angel.myapplication;

import java.util.ArrayList;
import java.util.List;

public class OrganizationProblem2ndTry {

    static String[] employeeGroups = {"A,B,C", "B,M,N", "C,X,Y", "M,O,P"};

    static int temporalIndex = 0;
    static List<Employee> temporalEmployees = GetEmployeesAsList(employeeGroups);

    public static void main(String[] args) {

        List<Employee> employees = GetEmployeesAsList(employeeGroups);

        for(Employee employee : employees){
            System.out.println(employee.Id + " - " + employee.ManagerId + " - " + employee.DownTreeLevel + " - " + employee.IsManager) ;
        }
    }

    public static List<Employee> GetEmployeesAsList(String[] employeeGroups){

        List<Employee> result = new ArrayList<>();
        for(String employeeGroup : employeeGroups){

            String[] arrayEmployees = employeeGroup.split(",");
            boolean firstOneManager = true;

            String groupManagerId = "UNKNOWN";

            for(String employee : arrayEmployees){

                if(!EmployeeExists(employee, result)){

                    if(firstOneManager) {
                        result.add(new OrganizationProblem2ndTry(). new Employee(employee, "", true));
                        firstOneManager = false;
                        groupManagerId = employee;
                    }
                    else {
                        result.add(new OrganizationProblem2ndTry(). new Employee(employee, groupManagerId, false));
                    }
                }else{

                    if(firstOneManager){

                        MarkAsManager(result, employee);
                        firstOneManager = false;
                        groupManagerId = employee;


                    }else{
                        int existingEmployeeIndex = FindEmployeeIndexInList(employee, result);
                        result.get(existingEmployeeIndex).ManagerId = groupManagerId;
                    }

                }
            }
        }

        result = DefineOrganization(result);
        return result;
    }

    private static void MarkAsManager(List<Employee> employees, String employeeId){
        for(Employee employee : employees){
            if(employee.Id.equals(employeeId)){
                employee.IsManager = true;
            }
        }
    }

    public static boolean EmployeeExists(String employeeId, List<Employee> employees){
        for (Employee inTurn: employees){
            if(employeeId.equals(inTurn.Id)){
                return true;
            }
        }
        return false;
    }

    public static int FindEmployeeIndexInList(String employeeId, List<Employee> employees){
        int index = 0;
        for (Employee inTurn: employees){
            if(employeeId.equals(inTurn.Id)){
                return index;
            }
            index++;
        }
        return -1;
    }

    private static List<Employee> DefineOrganization(List<Employee> employees){

        /*
        for(Employee employee : employees){
            if(employee.IsManager){
                PlusOneToSubordinates(employees, employee.Id);
            }else{
                //employee.DownTreeLevel++;
            }
        }
        */

        PlusOneToSubordinates(employees, "A");

        return employees;
    }

    private static void PlusOneToSubordinates(List<Employee> employees, String managerId){

        for(Employee inTurn : employees){

            //Finds employees that managerId is the current manager
            if(inTurn.ManagerId.equals(managerId) && (!inTurn.Id.equals(managerId))){

                //Increase plus one the found subordinate
                inTurn.DownTreeLevel++;

                //If this new subordinate is manager too will be required to self-call this method again (recursion)
                if(inTurn.IsManager){
                    PlusOneToSubordinates(employees, inTurn.Id);
                }
            }
        }
    }

    private void PrintOrganization(List<Employee> employees){
        String finalResult = "";

        int index = 0;
        for (Employee employee : employees){
            if(employee.DownTreeLevel == index){
                finalResult += finalResult + employee.Id;
            }
        }
    }



    private static void PrintChildren(Employee employee){

        for (Employee inTurn : temporalEmployees){
            if(employee.Id.equals(temporalEmployees.get(temporalIndex))){
                System.out.println(employee.Id);
            }
        }
    }

    public class Employee {

        String Id, ManagerId;
        int DownTreeLevel;
        boolean IsManager = false;

        Employee(String id, String managerId, boolean isManager){
            Id = id;
            ManagerId = managerId;
            IsManager = isManager;
        }
    }
}
