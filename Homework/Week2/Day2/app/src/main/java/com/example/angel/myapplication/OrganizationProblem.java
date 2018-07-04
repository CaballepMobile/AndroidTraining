package com.example.angel.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrganizationProblem {

    private static class Employee {

        private String _id;
        private String _managerId;
        private int _subordinationDownLevel;

        public Employee(String Id, String ManagerId){
            _id = Id;
            _managerId = ManagerId;
            _subordinationDownLevel = 0;
        }

        public String get_id() {
            return _id;
        }

        public String get_managerId() {
            return _managerId;
        }

        public int get_subordinationDownLevel() {
            return _subordinationDownLevel;
        }

        public void plusOneToSubordinationLevel() {
            _subordinationDownLevel++;
        }

    }


    static ArrayList<Employee> allEmployees;
    static ArrayList<ArrayList<Employee>> allGroups;

    public static void main(String args[]){

        //String[] arrayGroups = {"B2,F5,B6","A1,B2,C3,D4","D4,G7,I9","G7,H8"};
        String[] arrayGroups = {"F,I,J","B,F,G","A,B,C","J,M,N"};
        allEmployees = new ArrayList<>();
        allGroups = new ArrayList<>();
        allGroups = GenerateGroupsList(arrayGroups);

        UpdateAllEmployeeList(allGroups);

        for(Employee employee : allEmployees){
            System.out.println(employee._id + " - " + employee._subordinationDownLevel + " - " + employee._managerId);
        }
    }

    private static void UpdateAllEmployeeList (ArrayList<ArrayList<Employee>> groups){

        for(ArrayList<Employee> employees : groups){
            for(Employee employee : employees){

                DefineInList(employee);
            }
        }
    }

    private static void DefineInList(Employee newEmployee){

        boolean employeeExists = false;
        for(Employee employee : allEmployees){
            if(employee._id.equals(newEmployee._id)){
                employeeExists = true;
            }
        }

        if(newEmployee._id.equals("F")){
            System.out.println("Stop");
        }

        if(employeeExists){
            for(Employee employee : allEmployees){
                if(employee._id.equals(newEmployee._id)){
                    UpdateSubordination(employee);
                }
            }
        }else{
            allEmployees.add(newEmployee);
        }
    }

    private static void UpdateSubordination(Employee employee){

        if(employee._managerId.equals("")){
            ///ArrayList<Employee> subordinates = Arrays.asList(GetSubordinates(employee).toArray());

            Set subordinates = GetSubordinates(employee);
            for(Employee subordinate : GetSubordinates(employee)){
                employee.plusOneToSubordinationLevel();
                UpdateSubordination(subordinate);
            }
        }else{
            int managerDownLevel = GetManagerSubordinationDownLevel(employee._managerId);
            employee._subordinationDownLevel = managerDownLevel+1;
        }
    }

    private static Set<Employee> GetSubordinates(Employee manager){
        Set<Employee> subordinates = new HashSet<>();
        for(ArrayList<Employee> employees : allGroups){
            for(Employee employee : employees){
                if(employee._managerId.equals(manager._id)){
                    subordinates.add(employee);
                }
            }
        }
        return subordinates;
    }

    private static int GetManagerSubordinationDownLevel(String managerId){

        int managerSubordinationDownLevel = 0;
        for(ArrayList<Employee> employees : allGroups){
            if(employees.get(0)._id.equals(managerId)){
                managerSubordinationDownLevel = employees.get(0)._subordinationDownLevel;
            }
        }
        return managerSubordinationDownLevel;
    }

    private static ArrayList<ArrayList<Employee>> GenerateGroupsList(String[] arrayGroups){

        ArrayList<ArrayList<Employee>> allGroups = new ArrayList<>();
        ArrayList employeeGroup = new ArrayList();

        for(String group : arrayGroups){

            employeeGroup = new ArrayList();
            String[] arrayEmployees = group.split(",");
            boolean isManager = true;
            String manager = "";

            for(String employee : arrayEmployees){

                if(isManager) {
                    employeeGroup.add(new Employee(employee, ""));
                    isManager = false;
                    manager = employee;
                }
                else {
                    employeeGroup.add(new Employee(employee, manager));
                }
            }
            allGroups.add(employeeGroup);
        }

        return allGroups;
    }


}