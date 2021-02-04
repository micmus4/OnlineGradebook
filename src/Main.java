import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Student> students = new ArrayList<>(); // ArrayList containing all students.
    private static final ArrayList<String> subjects = new ArrayList<>(); // ArrayList containing all subjects in school.

    public static void main(String[] args) {

        addSomeSubjects();
        addSomeStudents();
        addSomeGrades();
        System.out.println("\n\nWelcome to Online Grade Book application!");
        System.out.println("Via this app, you can have a closer look at how students from your school are performing!");
        System.out.println("There is a variety of options that provide you all sort of interesting data that you wish to know!\n\n");

        boolean breakMainLoop = false;
        while(!breakMainLoop){
            mainOptions();
            int chooseSection = correctChoice(0, 4, 4);
            switch(chooseSection){
                case 0:
                    System.out.println("Quitting application...");
                    breakMainLoop = true;
                    break;
                case 1:
                    studentOptions();
                    boolean breakStudentLoop = false;
                    while(!breakStudentLoop) {
                        int chooseStudentOption = correctChoice(0, 5, 5);
                        switch (chooseStudentOption) {
                            case 0:
                                System.out.println("Going back to main menu...");
                                breakStudentLoop = true;
                                break;
                            case 1:
                                addNewStudent();
                                break;
                            case 2:
                                removeStudent();
                                break;
                            case 3:
                                modifyStudent();
                                break;
                            case 4:
                                showListOfStudents();
                                break;
                            case 5:
                                studentOptions();
                                break;
                        }
                    }
                    break;
                case 2:
                    gradeOptions();
                    boolean breakGradeLoop = false;
                    while(!breakGradeLoop){
                        int chooseGradeOption = correctChoice(0, 5, 5);
                        switch (chooseGradeOption){
                            case 0:
                                System.out.println("Going back to main menu...");
                                breakGradeLoop = true;
                                break;
                            case 1:
                                addGrade();
                                break;
                            case 2:
                                removeGrade();
                                break;
                            case 3:
                                modifyGrade();
                                break;
                            case 4:
                                showListOfGrades();
                                break;
                            case 5:
                                gradeOptions();
                                break;
                        }
                    }
                    break;
                case 3:
                    statisticOptions();
                    boolean breakStatisticLoop = false;
                    while (!breakStatisticLoop) {
                        int chooseStatisticOption = correctChoice(0, 7, 7);
                        switch (chooseStatisticOption){
                            case 0:
                                System.out.println("Going back to main menu...");
                                breakStatisticLoop = true;
                                break;
                            case 1:
                                showAverageFromAllStudentGrades();
                                break;
                            case 2:
                                showAverageFromAllStudentGradesButFromSpecificSubject();
                                break;
                            case 3:
                                showAverageOfAllStudentsALLgrades();
                                break;
                            case 4:
                                showAverageOfAllStudentsAllGradesFromSpecificSubject();
                                break;
                            case 5:
                                showBestStudentsFromAllSubjects();
                                break;
                            case 6:
                                showBestStudentsFromSpecificSubject();
                                break;
                            case 7:
                                statisticOptions();
                                break;
                        }
                    }
                    break;
                case 4:
                    mainOptions();
                    break;
            }
        }
    }




    // ###################################################
    // #                    OPTIONS                      #
    // ###################################################


    // List of main options.
    public static void mainOptions(){

        System.out.println("Main Options:\n");
        System.out.println("\t1. Student Options.");
        System.out.println("\t2. Grade Options.");
        System.out.println("\t3. Statistic Options.");
        System.out.println("\t4. Show options.\n");
        System.out.println("\t0. To Exit.\n");
    }


    // List of student options.
    public static void studentOptions(){

        System.out.println("Student Options:\n");
        System.out.println("\t1. Add a new student to the grade book.");
        System.out.println("\t2. Remove student from the grade book.");
        System.out.println("\t3. Modify student's personal information.");
        System.out.println("\t4. Show list of students.");
        System.out.println("\t5. Show available options.");
        System.out.println("\t0. Going back to main menu.\n");
    }


    // List of grade options.
    public static void gradeOptions(){

        System.out.println("Grade Options:\n");
        System.out.println("\t1. Add a new grade to student's grade report.");
        System.out.println("\t2. Remove grade from student's grade report.");
        System.out.println("\t3. Modify student's grade.");
        System.out.println("\t4. Show list of grades.");
        System.out.println("\t5. Show available options.");
        System.out.println("\t0. Going back to main menu.\n");
    }


    // List of statistic options.
    public static void statisticOptions(){

        System.out.println("Statistic Options:\n");
        System.out.println("\t1. Show average of all student's grades");
        System.out.println("\t2. Show average of all student's grades from specific subject.");
        System.out.println("\t3. Show average of all students' all grades.");
        System.out.println("\t4. Show average of all students' all grades from specific subject.");
        System.out.println("\t5. Show best students (list of students sorted by their average of grades).");
        System.out.println("\t6. Show best students from specific subject (list of students sorted by their average of grades from specific subject).");
        System.out.println("\t7. Show available options.");
        System.out.println("\t0. Going back to main menu.\n");
    }






    // ###################################################
    // #                  STUDENT SOFTWARE               #
    // ###################################################




    // A method that adds a new student into an ArrayList students.
    // It requires all Student-related data to create a new Student.
    public static void addNewStudent(){

        System.out.println("ADDING NEW STUDENT PROCESS\n\n");
        System.out.print("\tEnter student's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("\tEnter student's last name: ");
        String lastName = scanner.nextLine();
        String numberID;
        while(true) {
            System.out.print("\tEnter student's number ID: ");
            numberID = scanner.nextLine();
            if(findStudentByID(numberID) != null){
                System.out.println("\nThere is already a student with the same ID number.");
                System.out.println("Please try again...\n");
                continue;
            }
            break;
        }
        Student student = new Student(firstName, lastName, numberID);
        student.setDayOfBirth();
        student.setMonthOfBirth();
        student.setYearOfBirth();
        System.out.print("\tEnter student's place of residence (city/village): ");
        student.setCity();
        System.out.print("\tEnter student's address: ");
        student.setAddress();
        students.add(student);
        Collections.sort(students, new sortArrayByLastName());
        System.out.println("\nStudent successfully added!");
        student.showStudent();
    }


    // A method that removes student from the students ArrayList.
    // It requires student's fullname in order to delete him from the ArrayList of Students.
    public static void removeStudent(){
        System.out.println("REMOVING STUDENT PROCESS\n\n");
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        student.showStudent();
        System.out.println("\n Are you sure you want to remove this student from the grade book?\n");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        int choice = correctChoice(1, 2);
        if(choice == 1){
            students.remove(student);
            System.out.println("Student " + student.getFullName() + " was removed from the grade book");
        } else {
            System.out.println("Student " + student.getFullName() + " was not removed from the grade book");
        }
    }



    // A method that modifies personal information about student.
    // It needs student's ID number to do so.
    public static void modifyStudent(){
        System.out.println("MODIFYING STUDENT PROCESS\n\n");
        String numberID = "";
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        student.showStudent();
        System.out.println("\n Are you sure you want to modify information about this student?\n");
        System.out.println("\t1. Yes");
        System.out.println("\t2. No");
        int choice = correctChoice(1, 2);
        boolean modifyBreakLoop = false;
        if(choice == 1){
            while(!modifyBreakLoop) {
                System.out.println("What information do you wish to change?:\n");
                System.out.println("\t1. Information about name.");
                System.out.println("\t2. Information about ID.");
                System.out.println("\t3. Information about birth date.");
                System.out.println("\t4. Information about place of residence.\n");
                System.out.println("\t0. To exit.");
                int modifyOption = correctChoice(0, 4);
                switch (modifyOption){
                    case 0:
                        System.out.println("Modification is done, going back now...");
                        studentOptions();
                        modifyBreakLoop = true;
                        break;
                    case 1:
                        System.out.println("NAME MODIFICATION PROCESS\n\n");
                        System.out.println("\tStudent's current first name: " + student.getFirstName());
                        student.setFirstName();
                        System.out.println("\tStudent's current last name: " + student.getLastName());
                        student.setLastName();
                        System.out.println("\n\t Modification was successfull!");
                        Collections.sort(students, new sortArrayByLastName());
                        break;
                    case 2:
                        System.out.println("ID MODIFICATION PROCESS\n\n");
                        boolean idFound = true;
                        while(idFound) {
                            idFound = false;
                            System.out.println("\tStudent's current ID number: " + student.getNumberID());
                            System.out.print("\tEnter student's new ID number: ");
                            numberID = scanner.nextLine();
                            for (Student studentToCheck : students) {
                                if (studentToCheck.getNumberID().equals(numberID)) {
                                    System.out.println("There is already student with the same number ID. Please try again!");
                                    idFound = true;
                                    break;
                                }
                            }
                            if (idFound){
                                continue;
                            }
                            idFound = false;
                        }
                        student.setNumberID(numberID);
                        System.out.println("\n\t Modification was successfull!");
                        break;
                    case 3:
                        System.out.println("ID MODIFICATION PROCESS\n\n");
                        System.out.println("\tStudent's current birth date: " + student.getFullBirthDate());
                        student.setDayOfBirth();
                        student.setMonthOfBirth();
                        student.setYearOfBirth();
                        System.out.println("\n\t Modification was successfull!");
                        break;
                    case 4:
                        System.out.println("PLACE OF RESIDENCE MODIFICATION PROCESS\n\n");
                        System.out.println("\tStudent's current address: " + student.getAddress());
                        System.out.print("\tEnter student's new address: ");
                        student.setAddress();
                        System.out.println("\tStudent's current city/village: " + student.getCity());
                        System.out.print("\tEnter student's new city/village: ");
                        student.setCity();
                        System.out.println("\n\t Modification was successfull!");
                        break;
                }
            }

        } else {
            System.out.println("Modification cancelled, going back now...");
        }
    }



    // A method that prints list of students.
    // It shows student's full name and his/her ID number.
    public static void showListOfStudents(){
        if(students.size() == 0){
            System.out.println("LIST OF STUDENTS IS EMPTY. THERE ARE NONE STUDENTS.");
            return;
        }
        System.out.println("LIST OF STUDENTS: ");
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            System.out.println("\t" + (i + 1) + ". " + student.getFullName() + " (" + student.getNumberID() + ").");
        }
    }



    // A method that looks for a student.
    // It requires student's ID to proceed.
    // It returns Student Object (if student was found) or null (if student was not found).
    private static Student findStudentByID(String numberID){
        for(Student student : students){
            if(student.getNumberID().equals(numberID)){
                return student;
            }
        }
        return null;
    }


    // A method that looks for a student.
    // It requires student's first name and last name to proceed.
    // It returns Student Object (if student was found) or null (if student was not found).
    // In case there is more than one student of the same full name, it enables you to choose the one you need.
    public static Student findStudentByName(String firstName, String lastName){
        int choice;
        for(Student student : students){
            if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                System.out.println("Is that the student you were looking for?\n");
                student.showStudent();
                System.out.println("\n1. Yes.");
                System.out.println("2. No, look for another one with the same name.");
                choice = correctChoice(1, 2);
                if(choice == 1){
                    return student;
                }
            }
        }
        return null;
    }



    // ###################################################
    // #                  GRADE SOFTWARE                 #
    // ###################################################




    // A method that adds a new grade to student's report.
    // It needs student's full name to do so.
    public static void addGrade(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        while(true) {
            student.addGrade(subjects);
            System.out.println("Do you want to add another grade to " + student.getFullName() + " report?\n");
            System.out.println("1. Yes, I do.");
            System.out.println("2, No, I don't.");
            int choice = correctChoice(1, 2);
            if(choice == 2){
                gradeOptions();
                break;
            }
        }
    }



    // A method that removes grade from Student's report.
    // It needs student's fullname to do so.
    // If student was found, the method will ask you which grade(s) do you want to remove.
    public static void removeGrade(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        while(true) {
            int choice;
            int numberOfGrades = student.getGrades().size();
            if(numberOfGrades == 0){
                System.out.println(student.getFullName() + " has no grades in his/her report.");
                gradeOptions();
                return;
            } else if(numberOfGrades == 1){
                System.out.println("Is that the grade that you wish to remove?\n");
                Student.Grade grade = student.getGrades().get(0);
                student.showGrade(grade);
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 1){
                    student.removeGrade(grade);
                    System.out.println("The grade was successfully removed from student's report");
                    System.out.println("The student has no more grades, going back to grade menu...");
                    gradeOptions();
                    return;
                } else {
                    System.out.println("The removal of grade was cancelled.");
                    System.out.println(student.getFullName() + " doesn't have any other grades, going back to grade menu...");
                    gradeOptions();
                    return;
                }
            } else {
                showListOfGrades(student);
                System.out.println("Which grade do you want to remove?");
                choice = correctChoice(1, numberOfGrades);
                choice--;
                System.out.println("Is that the grade that you wish to remove?\n");
                Student.Grade grade = student.getGrades().get(choice);
                student.showGrade(grade);
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 1){
                    student.removeGrade(grade);
                    System.out.println("The grade was successfully removed from student's report");
                } else {
                    System.out.println("The removal of grade was cancelled.");
                }
                System.out.println("Do you want to remove other grades?");
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 2){
                    System.out.println("Going back to grade menu...");
                    gradeOptions();
                    break;
                }
            }
        }
    }




    // A method that modifies grade(s).
    // It needs student's fullname to do so.
    // If student was found, that method will enable you to modify every single information about that student.
    public static void modifyGrade(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        while(true){
            int numberOfGrades = student.getGrades().size();
            int choice;
            if(numberOfGrades == 0) {
                System.out.println(student.getFullName() + " has no grades in his/her report.");
                gradeOptions();
                return;
            } else if(numberOfGrades == 1) {
                System.out.println("Is that the grade that you wish to modify?\n");
                Student.Grade grade = student.getGrades().get(0);
                student.showGrade(grade);
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 2){
                    System.out.println("There are no other grades in " + student.getFullName() + " report, going back to grade menu...");
                    gradeOptions();
                    return;
                }
                gradeModification(student, 0);
                System.out.println("There are no other grades in " + student.getFullName() + " report, going back to grade menu...");
                gradeOptions();
                return;
            } else {
                showListOfGrades(student);
                System.out.println("Which grade do you want to modify?");
                choice = correctChoice(1, numberOfGrades);
                choice--;
                System.out.println("Is that the grade that you wish to modify?\n");
                Student.Grade grade = student.getGrades().get(choice);
                int gradeIndex = choice;
                student.showGrade(grade);
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 2){
                    System.out.println("Modification of the grade is cancelled...");
                    continue;
                }
                gradeModification(student, gradeIndex);
                System.out.println("Do you want to modify other grades?");
                System.out.println("1. Yes, I do.");
                System.out.println("2, No, I don't.");
                choice = correctChoice(1, 2);
                if(choice == 2){
                    System.out.println("Going back to grade menu...");
                    gradeOptions();
                    break;
                }
            }
        }

    }


    // "An inner method" in method "modifyGrade".
    // Here is the process of modification of the student's grade.
    private static void gradeModification(Student studentToFind, int gradeIndex){
        Student student = findStudentByID(studentToFind.getNumberID());
        Student.Grade grade = student.getGrades().get(gradeIndex);
        boolean modifyGradeBreakLoop = false;
        int modifyOption;
        while(!modifyGradeBreakLoop){
            System.out.println("What do you want to modify?\n");
            System.out.println("\t1. Grade number.");
            System.out.println("\t2. Grade wage.");
            System.out.println("\t3. Grade subject.");
            System.out.println("\t4. Grade description\n");
            System.out.println("\t0. Modification is done");
            modifyOption = correctChoice(0, 4);
            switch (modifyOption){
                case 0:
                    System.out.println("Modification is done!");
                    modifyGradeBreakLoop = true;
                    break;
                case 1:
                    System.out.println("Current grade number: " + grade.getGrade());
                    System.out.print("New grade number: ");
                    grade.setGrade(false);
                    System.out.println("You've successfully edited grade number! New grade number: " + grade.getGrade());
                    break;
                case 2:
                    System.out.println("Current grade wage: " + grade.getWage());
                    System.out.print("New grade wage: ");
                    grade.setWage(false);
                    System.out.println("You've successfully edited grade wage! New grade wage: " + grade.getWage());
                    break;
                case 3:
                    System.out.println("Current grade subject: " + grade.getSubject());
                    System.out.print("New grade subject: ");
                    grade.setSubject(false, subjects);
                    System.out.println("You've successfully edited grade subject! New grade subject: " + grade.getSubject());
                    break;
                case 4:
                    System.out.println("Current grade description: " + grade.getDescription());
                    System.out.print("New grade description: ");
                    grade.setDescription(false);
                    System.out.println("You've successfully edited grade description! New grade description: " + grade.getDescription());
                    break;
            }
        }
    }







    // A method that displays grades of a student.
    // It needs student's full name to display the list.
    public static void showListOfGrades(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            gradeOptions();
            return;
        }
        String fullName = student.getFullName();
        String exception;
        if(fullName.charAt(fullName.length()-1) == 's'){
            exception = "'";
        } else {
            exception = "'s";
        }
        System.out.println("\n" + student.getFullName() + exception + " grades:\n");
        if(student.getGrades().size() == 0){
            System.out.println("\nThis student has no grades...\n");
            return;
        }
        for(int i = 0; i < student.getGrades().size(); i++){
            double grade = student.getGrade(student.getGrades().get(i));
            double wage = student.getWage(student.getGrades().get(i));
            String subject = student.getSubject(student.getGrades().get(i));
            String description = student.getDescription(student.getGrades().get(i));
            System.out.println("\t[#" + (i+1) + "]  " + grade + ", Wage: " + wage + ", from " + subject);
            System.out.println("\tDescription: " +  description + "\n");
        }
        System.out.println();
    }



    // A method that displays all student's grades and all the information about them.
    public static void showListOfGrades(Student student){
        for(int i = 0; i < student.getGrades().size(); i++){
            double grade = student.getGrade(student.getGrades().get(i));
            double wage = student.getWage(student.getGrades().get(i));
            String subject = student.getSubject(student.getGrades().get(i));
            String description = student.getDescription(student.getGrades().get(i));
            System.out.println("\t[#" + (i+1) + "]  " + grade + ", Wage: " + wage + ", from " + subject);
            System.out.println("\tDescription: " +  description + "\n");
        }
    }


    // #####################################################
    // #                  STATISTIC SOFTWARE               #
    // #####################################################




    // A method that shows average from all student's grades.
    // It needs student's fullname to do so.
    public static void showAverageFromAllStudentGrades(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            statisticOptions();
            return;
        }
        ArrayList<Student.Grade> grades = student.getGrades();
        if(grades.size() == 0){
            System.out.println(student.getFullName() + " has no grades at all.");
            return;
        }
        double average = 0;
        double wageSum = 0;
        for (Student.Grade gradeToCheck: grades){
            average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
            wageSum = wageSum + gradeToCheck.getWage();
        }
        average = average / wageSum;
        average = (double) Math.round(average * 100) / 100;
        System.out.println(student.getFullName() + " average of all grades: " + average);
    }


    // A method that shows average from all student's grades BUT from one specific subject.
    // It needs student's fullname to do so and also name of the subject.
    public static void showAverageFromAllStudentGradesButFromSpecificSubject(){
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        Student student = findStudentByName(firstName, lastName);
        if(student == null){
            System.out.println("There is no such student...");
            statisticOptions();
            return;
        }
        String subject;
        while (true) {
            System.out.print("Enter subject: ");
            subject = scanner.nextLine();
            subject = subject.toUpperCase();
            if (!subjects.contains(subject)) {
                System.out.println("There is no such subject in our school.");
                System.out.println("List of subjects:\n");
                for (String subjectToCheck: subjects) {
                    System.out.println("\t" + subjectToCheck);
                }
                continue;
            }
            break;
        }
        ArrayList<Student.Grade> grades = student.getGrades();
        ArrayList<Student.Grade> gradesFromSpecificSubject = new ArrayList<>();
        boolean subjectFound = false;
        for(Student.Grade gradeToCheck: grades){
            if(gradeToCheck.getSubject().equals(subject)){
                subjectFound = true;
                gradesFromSpecificSubject.add(gradeToCheck);
            }
        }
        if (!subjectFound){
            System.out.println(student.getFullName() + " does not have any grades from subject " + subject);
            return;
        }
        double average = 0;
        double wageSum = 0;
        for (Student.Grade gradeToCheck: gradesFromSpecificSubject){
            average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
            wageSum = wageSum + gradeToCheck.getWage();
        }
        average = average / wageSum;
        average = (double) Math.round(average * 100) / 100;
        System.out.println(student.getFullName() + " average of all grades from subject " + subject + ": " + average);
    }



    // A method that displays list of average grades of ALL students.
    public static void showAverageOfAllStudentsALLgrades(){
        double average = 0;
        double wageSum = 0;
        if(students.size() == 0){
            System.out.println("There are no students in the gradebook currently!");
            return;
        }
        for(Student studentToCheck: students){
            ArrayList<Student.Grade> grades = studentToCheck.getGrades();
            for(Student.Grade gradeToCheck: grades){
                average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
                wageSum = wageSum + gradeToCheck.getWage();
            }
        }
        if(average == 0){
            System.out.println("Students have no grades at all...");
            return;
        }
        average = average / wageSum;
        average = (double) Math.round(average * 100) / 100;
        System.out.println("Average off all students' all grades: " + average);
    }


    // A method that displays list of average grades of ALL students BUT from one specific subject.
    public static void showAverageOfAllStudentsAllGradesFromSpecificSubject(){
        double average = 0;
        double wageSum = 0;
        if(students.size() == 0){
            System.out.println("There are no students in the gradebook currently!");
            return;
        }
        String subject;
        while (true) {
            System.out.print("Enter subject: ");
            subject = scanner.nextLine();
            subject = subject.toUpperCase();
            if (!subjects.contains(subject)) {
                System.out.println("There is no such subject in our school.");
                System.out.println("List of subjects:\n");
                for (String subjectToCheck: subjects) {
                    System.out.println("\t" + subjectToCheck);
                }
                continue;
            }
            break;
        }
        ArrayList<Student.Grade> gradesFromSpecificSubject = new ArrayList<>();
        for(Student studentToCheck: students) {
            ArrayList<Student.Grade> grades = studentToCheck.getGrades();
            for(Student.Grade gradeToCheck: grades){
                if(gradeToCheck.getSubject().equals(subject)){
                    gradesFromSpecificSubject.add(gradeToCheck);
                }
            }
        }
        if(gradesFromSpecificSubject.size() == 0){
            System.out.println("Students have no grades from subject " + subject);
            return;
        }
        for(Student.Grade gradeToCheck: gradesFromSpecificSubject){
            average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
            wageSum = wageSum + gradeToCheck.getWage();
        }
        average = average / wageSum;
        average = (double) Math.round(average * 100) / 100;
        System.out.println("Average off all students' all grades from subject " + subject + ": " + average);
    }


    // A method that displays list of the best students from all subjects.
    // By "best" it means it will sort the list from best to worst averages.
    public static void showBestStudentsFromAllSubjects(){
        if(students.size() == 0){
            System.out.println("There are no students in the gradebook currently!");
            return;
        }
        double average = 0;
        double wageSum = 0;
        ArrayList<Student> studentsSortedByAverage = new ArrayList<>();
        for(Student studentToCheck: students){
            average = 0;
            wageSum = 0;
            if(studentToCheck.getGrades().size() == 0){
                studentToCheck.setAverage(0.0d);
                studentsSortedByAverage.add(studentToCheck);
                continue;
            }
            for(Student.Grade gradeToCheck: studentToCheck.getGrades()){
                average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
                wageSum = wageSum + gradeToCheck.getWage();
            }
            average = average / wageSum;
            average = (double) Math.round(average * 100) / 100;
            studentToCheck.setAverage(average);
            studentsSortedByAverage.add(studentToCheck);
        }
        studentsSortedByAverage = sortStudentsByAverage(studentsSortedByAverage);
        int index = 1;
        for(Student studentToDisplay: studentsSortedByAverage){
            if(studentToDisplay.getAverage() == 0.0){
                System.out.println(index + ". " + studentToDisplay.getFullName() + ": NO GRADES");
            } else {
                System.out.println(index + ". " + studentToDisplay.getFullName() + ": " + studentToDisplay.getAverage());
            }
            index++;
        }
    }


    // A method that displays list of the best students from all subjects BUT from one specific subject.
    // By "best" it means it will sort the list from best to worst averages.
    public static void showBestStudentsFromSpecificSubject(){
        if(students.size() == 0){
            System.out.println("There are no students in the gradebook currently!");
            return;
        }
        String subject;
        while (true) {
            System.out.print("Enter subject: ");
            subject = scanner.nextLine();
            subject = subject.toUpperCase();
            if (!subjects.contains(subject)) {
                System.out.println("There is no such subject in our school.");
                System.out.println("List of subjects:\n");
                for (String subjectToCheck: subjects) {
                    System.out.println("\t" + subjectToCheck);
                }
                continue;
            }
            break;
        }
        double average = 0;
        double wageSum = 0;
        ArrayList<Student> studentsSortedByAverage = new ArrayList<>();
        for(Student studentToCheck: students){
            average = 0;
            wageSum = 0;
            ArrayList<Student.Grade> gradesFromSpecificSubject = new ArrayList<>();
            for(Student.Grade gradeToCheck: studentToCheck.getGrades()){
                if(gradeToCheck.getSubject().equals(subject)){
                    gradesFromSpecificSubject.add(gradeToCheck);
                }
            }
            if(gradesFromSpecificSubject.size() == 0){
                studentToCheck.setAverage(0.0d);
                studentsSortedByAverage.add(studentToCheck);
                continue;
            }
            for(Student.Grade gradeToCheck: gradesFromSpecificSubject){
                average = average + gradeToCheck.getGrade() * gradeToCheck.getWage();
                wageSum = wageSum + gradeToCheck.getWage();
            }
            average = average / wageSum;
            average = (double) Math.round(average * 100) / 100;
            studentToCheck.setAverage(average);
            studentsSortedByAverage.add(studentToCheck);
        }
        studentsSortedByAverage = sortStudentsByAverage(studentsSortedByAverage);
        int index = 1;
        for(Student studentToDisplay: studentsSortedByAverage){
            if(studentToDisplay.getAverage() == 0.0){
                System.out.println(index + ". " + studentToDisplay.getFullName() + ": NO GRADES");
            } else {
                System.out.println(index + ". " + studentToDisplay.getFullName() + ": " + studentToDisplay.getAverage());
            }
            index++;
        }
    }






    // ###################################################
    // #                      OTHER                      #
    // ###################################################





    // A method which ensures user that he made a correct choice.
    public static int correctChoice(int from, int to){
        int choice;
        while(true) {
            System.out.print("Choose: ");
            choice = intValidation();
            if (choice < from || choice > to) {
                System.out.println("You have to enter number from " + from + " to " + to + ".");
                continue;
            }
            break;
        }
        return choice;
    }



    // The same method as above, but overloaded with third parameter.
    // It prints a reminder to show options in case the user forgot those.
    public static int correctChoice(int from, int to, int showOptions){
        int choice;
        while(true) {
            System.out.println("(" + showOptions + " -  to show options)");
            System.out.print("Choose: ");
            choice = intValidation();
            if (choice < from || choice > to) {
                System.out.println("You have to enter number from " + from + " to " + to + ".");
                continue;
            }
            break;
        }
        return choice;
    }


    // A method which validates Integer input and makes sure you pass the right type of data.
    public static int intValidation(){
        boolean isCorrect = scanner.hasNextInt();
        if(isCorrect){
            int action = scanner.nextInt();
            scanner.nextLine(); // enter
            return action;
        } else {
            System.out.println("Invalid value! Please try again...");
            scanner.next();
            return intValidation();
        }
    }



    // The next three methods are adding some basic data into the program.
    public static void addSomeSubjects(){
        subjects.add("BIOLOGY");
        subjects.add("PHYSICS");
        subjects.add("CHEMISTRY");
        subjects.add("MATHS");
        subjects.add("ART");
        subjects.add("MUSIC");
        subjects.add("GEOGRAPHY");
        subjects.add("HISTORY");
        subjects.add("IT");
    }

    public static void addSomeStudents(){
        students.add(new Student("Clark", "Kent", "01", 15, 3, 2001, "Daily 2b", "Smallville"));
        students.add(new Student("Bruce", "Wayne", "02", 21, 12, 2003, "St. Paul 3/1", "Gotham"));
        students.add(new Student("Ragnar", "Lothbrok", "03", 13, 1, 1997, "Unknown 3", "Kattegat"));
        students.add(new Student("Walter", "White", "04", 13, 1, 1997, "Don't Remember ;D", "some random in USA???"));
        Collections.sort(students, new sortArrayByLastName());
    }

    public static void addSomeGrades(){
        students.get(0).getGrades().add(students.get(0).createGrade(4, 2, "IT", "Quiz #1"));
        students.get(1).getGrades().add(students.get(0).createGrade(3.5, 1, "IT", "Quiz #2"));
        students.get(2).getGrades().add(students.get(0).createGrade(2.5, 3, "IT", "Quiz #3"));
        students.get(1).getGrades().add(students.get(1).createGrade(5, 3, "IT", "Mammal test"));
        students.get(0).getGrades().add(students.get(1).createGrade(1, 2, "CHEMISTRY", "Homework assignment"));
        students.get(1).getGrades().add(students.get(2).createGrade(4.5, 1, "MUSIC", "Own song"));
        students.get(2).getGrades().add(students.get(2).createGrade(6, 5, "ART", "Final exam"));
        students.get(0).getGrades().add(students.get(0).createGrade(4, 2, "IT", "Quiz #3.5"));
        students.get(1).getGrades().add(students.get(0).createGrade(4.5, 3, "CHEMISTRY", "Quiz #4"));
        students.get(0).getGrades().add(students.get(0).createGrade(1.5, 3, "IT", "Quiz #5"));
        students.get(1).getGrades().add(students.get(1).createGrade(4, 2, "BIOLOGY", "End test"));
        students.get(2).getGrades().add(students.get(1).createGrade(3, 1, "CHEMISTRY", "Homework assignment"));
        students.get(2).getGrades().add(students.get(2).createGrade(5, 3, "MUSIC", "National anthem"));
        students.get(2).getGrades().add(students.get(2).createGrade(6, 4, "ART", "Final exam"));
    }




    // A method which sorts the arraylist of Students by students' last names.
    private static class sortArrayByLastName implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getLastName().compareTo(student2.getLastName());
        }
    }


    // A method which sorts the arraylist of Students by students' averages.
    private static ArrayList<Student> sortStudentsByAverage(ArrayList<Student> studentsToSort){
        for(int i = 0; i < studentsToSort.size(); i++){
            double temp = studentsToSort.get(i).getAverage();
            Student tempStudent = studentsToSort.get(i);
            int j = i - 1;
            while (j >= 0 && studentsToSort.get(j).getAverage() < temp){
                studentsToSort.set((j + 1), studentsToSort.get(j));
                j--;
            }
            j++;
            studentsToSort.set(j, tempStudent);
        }
        return studentsToSort;
    }
}
