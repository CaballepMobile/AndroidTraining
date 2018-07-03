package com.example.angel.myapplication;

import java.util.ArrayList;
import java.util.Arrays;
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

    ArrayList<Employee> allEmployees = new ArrayList<>();
    public static void main(String args[]){

        String[] arrayGroups = {"B2,F5,B6","A1,B2,C3,D4","D4,G7,I9","G7,H8"};
        ArrayList<ArrayList<Employee>> allGroups = GenerateGroupsList(arrayGroups);



    }

    private ArrayList<Employee> GenerateSubordinationList (ArrayList<ArrayList<Employee>> groups){

        for(ArrayList<Employee> employees : groups){
            for(Employee employee : employees){
                if(employee._managerId.equals("")){
                    employee._subordinationDownLevel = 0;
                }else{
                    employee._subordinationDownLevel = employees.get(0)._subordinationDownLevel + 1;
                }
                DefineInList(employee);
            }
        }

        return null;
    }

    private void DefineInList(Employee newEmployee){
        if(allEmployees.contains(newEmployee)){
            //allEmployees.
        }else{
            allEmployees.add(newEmployee);
        }
    }

    private static ArrayList<ArrayList<Employee>> GenerateGroupsList(String[] arrayGroups){

        ArrayList<ArrayList<Employee>> allGroups = new ArrayList<>();
        ArrayList employeeGroup;

        for(String group : arrayGroups){

            String[] arrayEmployees = group.split(",");
            boolean isManager = true;
            String manager = "";

            for(String employee : arrayEmployees){

                employeeGroup = new ArrayList();
                if(isManager) {
                    employeeGroup.add(new Employee(employee, ""));
                    isManager = false;
                }
                else
                    employeeGroup.add(new Employee(employee,manager));

                allGroups.add(employeeGroup);
            }
        }

        return allGroups;
    }


}


