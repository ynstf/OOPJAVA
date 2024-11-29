package com.example.tp5.application;

import com.example.tp5.models.Departement;
import com.example.tp5.services.MetierImpl;
import com.example.tp5.models.Professeur;
import com.example.tp5.services.IMetier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
        IMetier metier = new MetierImpl();

        int c;
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - professors");
        System.out.println("2 - departments");

        System.out.print("what you want to do : ");
        c = scanner.nextInt();

        if (c == 1) {
            System.out.println("1 - get all professors");
            System.out.println("2 - add new professor");
            System.out.println("3 - update professor");
            System.out.println("4 - delete professor");
            System.out.print("what you want to do : ");
            c = scanner.nextInt();
            System.out.println();
            if (c==1){
                List<Professeur> Profs =  metier.getAllProfesseurs();
                if (!Profs.isEmpty()){
                    System.out.println("ID"+"  --  "+"Name"+"  --  "+"Last Name"+"  --  "+"CIN"+"  --  "+"N Departement");
                    for ( Professeur prof : Profs){
                        System.out.println(prof.getIdProf()+"--"+prof.getNom()+"--"+prof.getPrenom()+"--"+prof.getCin()+"--"+ prof.getIdDepart());
                    }
                }else {
                    System.out.println("there is no professor");
                }

            }
            else if (c==2) {
                System.out.print("Name : ");
                String nom = scanner.next();
                System.out.print("Prenom : ");
                String prenom = scanner.next();
                System.out.print("Email : ");
                String email = scanner.next();
                System.out.print("Adresse : ");
                String adresse = scanner.next();
                System.out.print("Telephon : ");
                String tel = scanner.next();
                System.out.print("Cin : ");
                String cin = scanner.next();
                System.out.print("Year (yyyy) : ");
                int year = scanner.nextInt();
                System.out.print("month (mm) : ");
                int month = scanner.nextInt();
                System.out.print("day (dd) : ");
                int day = scanner.nextInt();
                Date date = new Date(year-1900,month-1,day);
                int idDept = 0;

                System.out.println("all departements: ");
                List<Departement> depts =  metier.getAllDepartements();
                if (!depts.isEmpty()){
                    for ( Departement dept : depts){
                        System.out.println( dept.getIdDeprat()+ "--" +dept.getNom());
                    }
                    System.out.print("the departement : ");
                    idDept = scanner.nextInt();
                }else {
                    System.out.println("there is no professor");
                }



                Professeur prof = new Professeur(0,nom,prenom,cin,adresse,email,tel,date,idDept);

                metier.addProfesseur(prof);

            }
            else if (c==3) {
                List<Professeur> Profs =  metier.getAllProfesseurs();
                if (!Profs.isEmpty()){
                    for ( Professeur prof : Profs){
                        System.out.println(prof);
                    }

                    System.out.println("enter the id of the professor : ");
                    System.out.print("id : ");
                    int id = scanner.nextInt();
                    Professeur prof = metier.getProfesseurById(id);
                    System.out.println("you chose : "+prof);

                    System.out.print("Name : ");
                    String nom = scanner.next();
                    System.out.print("Prenom : ");
                    String prenom = scanner.next();
                    System.out.print("Email : ");
                    String email = scanner.next();
                    System.out.print("Adresse : ");
                    String adresse = scanner.next();
                    System.out.print("Telephon : ");
                    String tel = scanner.next();
                    System.out.print("Cin : ");
                    String cin = scanner.next();
                    System.out.print("Year (yyyy) : ");
                    int year = scanner.nextInt();
                    System.out.print("month (mm) : ");
                    int month = scanner.nextInt();
                    System.out.print("day (dd) : ");
                    int day = scanner.nextInt();
                    Date date = new Date(year-1900,month-1,day);
                    int idDept = 0;

                    System.out.println("all departements: ");
                    List<Departement> depts =  metier.getAllDepartements();
                    if (!depts.isEmpty()){
                        for ( Departement dept : depts){
                            System.out.println( dept.getIdDeprat()+ "--" +dept.getNom());
                        }
                        System.out.print("the departement : ");
                        idDept = scanner.nextInt();
                    }else {
                        System.out.println("there is no professor");
                    }



                    Professeur profUpdated = new Professeur(id,nom,prenom,cin,adresse,email,tel,date,idDept);

                    metier.updateProfesseur(profUpdated);

                }else {
                    System.out.println("there is no professor");
                }


            }
            else if (c==4) {
                System.out.println("all professors");
                List<Professeur> Profs =  metier.getAllProfesseurs();
                if (!Profs.isEmpty()) {
                    for (Professeur prof : Profs) {
                        System.out.println(prof);
                    }
                    System.out.print("chose a professor to delete (ID):");
                    int id = scanner.nextInt();
                    metier.deleteProfesseur(id);
                    System.out.println("the professor deleted successfully");

                }else {
                    System.out.println("there is no professor");
                }
            }
            else {
                System.out.println("you chose an invalid command");
            }
        }
        else if (c == 2) {
            System.out.println("1 - get all departements");
            System.out.println("2 - add new departement");
            System.out.println("3 - update departement");
            System.out.println("4 - delete departement");
            System.out.print("what you want to do : ");

            c = scanner.nextInt();
            if (c == 1) {
                List<Departement> departs = metier.getAllDepartements();
                if (!departs.isEmpty()){
                    System.out.println("ID"+"  --  "+"Name");
                    for ( Departement dept : departs){
                        System.out.println(dept.getIdDeprat()+"--"+dept.getNom());
                    }
                }else {
                    System.out.println("there is no departement");
                }
            }
            else if (c == 2) {
                System.out.print("Name : ");
                String nomDept = scanner.next();
                Departement departement = new Departement(0,nomDept);

                metier.addDepartement(departement);


            }
            else if (c == 3) {
                List<Departement> departs = metier.getAllDepartements();
                if (!departs.isEmpty()){
                    System.out.println("ID"+"  --  "+"Name");
                    for ( Departement dept : departs){
                        System.out.println(dept.getIdDeprat()+"--"+dept.getNom());
                    }
                    System.out.println("enter the id of the departement : ");
                    System.out.print("id : ");
                    int id = scanner.nextInt();
                    Departement departement = metier.getDepartementById(id);
                    System.out.println("you chose : "+departement);
                    System.out.print("updater Name : ");
                    String deptNom = scanner.next();
                    Departement deptUpdated = new Departement(id,deptNom);
                    metier.updateDepartement(deptUpdated);
                }else {
                    System.out.println("there is no departement");
                }




            }
            else if (c == 4) {
                System.out.println("all departements");
                List<Departement> Depts =  metier.getAllDepartements();
                if (!Depts.isEmpty()) {
                    for (Departement dept : Depts) {
                        System.out.println(dept.getIdDeprat()+"--"+dept.getNom());
                    }
                    System.out.print("chose a department to delete (ID):");
                    int id = scanner.nextInt();
                    metier.deleteDepartement(id);
                    System.out.println("the department deleted successfully");

                }else {
                    System.out.println("there is no department");
                }
            }
            else {
                System.out.println("you chose an invalid command");
            }
        }
        else {
            System.out.println("you chose an invalid command");
        }






        /*/ Example: Add a new department
        Departement dept = new Departement(0, "Computer Science");
        metier.addDepartement(dept);

        // Example: Retrieve all departments
        List<Departement> departements = metier.getAllDepartements();
        departements.forEach(System.out::println);

        // Example: Add a new professor
        Professeur prof = new Professeur(0, "John", "Doe", "CIN123", "123 Street", "123456789", "john.doe@example.com", new java.util.Date(), 1);
        metier.addProfesseur(prof);

        // Example: Retrieve all professors
        List<Professeur> professeurs = metier.getAllProfesseurs();
        professeurs.forEach(System.out::println);

        // Example: Search for professors
        List<Professeur> searchResults = metier.searchProfesseurs("John");
        searchResults.forEach(System.out::println);*/
    }
}
