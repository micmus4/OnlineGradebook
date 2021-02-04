import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Student {

    private static final Scanner scanner = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String numberID;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    private String address;
    private String city;
    private ArrayList<Grade> grades;
    private double average;

    public Student(String firstName, String lastName, String numberID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberID = numberID;
        this.grades = new ArrayList<>();
    }

    public Student(String firstName, String lastName, String numberID, int dayOfBirth, int monthOfBirth, int yearOfBirth, String address, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberID = numberID;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.city = city;
        this.grades = new ArrayList<>();
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setFirstName() {
        System.out.print("\tEnter student's new first name: ");
        String firstName = scanner.nextLine();
        this.firstName = firstName;
    }

    public void setLastName() {
        System.out.print("\tEnter student's new last name: ");
        String lastName = scanner.nextLine();
        this.lastName = lastName;
    }
    
    public void setNumberID(String numberID) {
        this.numberID = numberID;
    }

    public void setDayOfBirth() {
        int dayOfBirth;
        while (true) {
            System.out.print("\tEnter student's day of birth: ");
            dayOfBirth = intValidation();
            if (dayOfBirth < 1 || dayOfBirth > 31) {
                System.out.println("Oops! Something's wrong! Please enter a number from 1 to 31.");
                continue;
            }
            break;
        }
        this.dayOfBirth = dayOfBirth;
    }

    public void setMonthOfBirth() {
        int monthOfBirth;
        while (true) {
            System.out.print("\tEnter student's month of birth: ");
            monthOfBirth = intValidation();
            if (monthOfBirth < 1 || monthOfBirth > 12) {
                System.out.println("Oops! Something's wrong! Please enter a number from 1 to 12.");
                continue;
            }
            break;
        }
        this.monthOfBirth = monthOfBirth;
    }

    public void setYearOfBirth() {
        int yearOfBirth;
        while(true) {
            System.out.print("\tEnter student's year of birth: ");
            yearOfBirth = intValidation();
            if (yearOfBirth < 1995 || yearOfBirth > 2005) {
                System.out.println("Oops! Something's wrong! Please enter a number from 1995 to 2005.");
                continue;
            }
            break;
        }
        this.yearOfBirth = yearOfBirth;
    }

    public void setAddress() {
        String address = scanner.nextLine();
        this.address = address;
    }

    public void setCity() {
        String city = scanner.nextLine();
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumberID() {
        return numberID;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getFullBirthDate(){
        return dayOfBirth + "." + monthOfBirth + "." + yearOfBirth;
    }

    public void showStudent() {
        System.out.println("\n\tStudent name: " + firstName + " " + lastName + ".");
        System.out.println("\tDate of birth: " + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth + ".");
        System.out.println("\tID number: " + numberID);
        System.out.println("\tPlace of residence: " + address + " in " + city);
    }

    public void addGrade(ArrayList<String> subjects){
        Grade grade = new Grade();
        grade.setSubject(true, subjects);
        grade.setGrade(true);
        grade.setWage(true);
        grade.setDescription(true);
        showGrade(grade);
        grades.add(grade);
    }

    public void removeGrade(Grade grade){
        grades.remove(grade);
    }

    public void showGrade(Grade grade){
        System.out.println("\n\tSTUDENT: " + getFullName());
        System.out.println("\tGRADE: " + grade.getGrade());
        System.out.println("\tWAGE: " + grade.getWage());
        System.out.println("\tSUBJECT: " + grade.getSubject());
        System.out.println("\tDESCRIPTION: " + grade.getDescription() + "\n");
    }

    public Grade createGrade(double grade, double wage, String subject, String description){
        Grade newGrade = new Grade(grade, wage, subject, description);
        return newGrade;
    }

    public double getGrade(Grade grade){
        return grade.getGrade();
    }

    public double getWage(Grade grade){
        return grade.getWage();
    }

    public String getSubject(Grade grade){
        return grade.getSubject();
    }

    public String getDescription(Grade grade){
        return grade.getDescription();
    }

                    public static class Grade{

                    private double grade;
                    private double wage;
                    private String subject;
                    private String description;


                    public Grade() {
                    }

                    public Grade(double grade, double wage, String subject, String description) {
                        this.grade = grade;
                        this.wage = wage;
                        this.subject = subject;
                        this.description = description;
                    }

                    public double getGrade() {
                        return grade;
                    }

                    public void setGrade(boolean displayEnterMessage) {
                        scanner.useLocale(Locale.US);
                        double grade;
                        while(true) {
                            if(displayEnterMessage) {
                                System.out.print("\tEnter grade: ");
                            }
                            grade = doubleValidation();
                            if (grade < 1 || grade > 6) {
                                System.out.println("Choose a number from 1 to 6.");
                                continue;
                            }
                            break;
                        }
                        this.grade = grade;
                    }

                    public double getWage() {
                        return wage;
                    }

                    public void setWage(boolean displayEnterMessage) {
                        scanner.useLocale(Locale.US);
                        double wage;
                        while(true) {
                            if(displayEnterMessage) {
                                System.out.print("\tEnter grade's wage: ");
                            }
                            wage = doubleValidation();
                            if (wage < 1) {
                                System.out.println("Enter a number that is equal to 1 or bigger.");
                                continue;
                            }
                            break;
                        }
                        this.wage = wage;
                    }

                    public String getSubject() {
                        return subject;
                    }

                    public void setSubject(boolean displayEnterMessage, ArrayList<String> subjects) {
                        if(displayEnterMessage) {
                            System.out.print("\tEnter subject: ");
                        }
                        while(true) {
                            String subject = scanner.nextLine();
                            subject = subject.toUpperCase();
                            for (int i = 0; i < subjects.size(); i++) {
                                if (subject.equals(subjects.get(i))) {
                                    this.subject = subject;
                                    return;
                                }
                            }
                            System.out.println("There is no such subject in our school!");
                            System.out.println("Please check the spelling or see the list of our school's subjects: \n");
                            for(int i = 0; i < subjects.size(); i++){
                                System.out.println("\t" + subjects.get(i));
                            }
                            System.out.print("\n\tEnter subject: ");
                        }
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(boolean displayEnterMessage) {
                        if(displayEnterMessage) {
                            System.out.print("\tEnter description: ");
                        }
                        String description = scanner.nextLine();
                        this.description = description;
                    }
    }





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

    public static double doubleValidation(){
        boolean isCorrect = scanner.hasNextDouble();
        if(isCorrect){
            double action = scanner.nextDouble();
            scanner.nextLine(); // enter
            return action;
        } else {
            System.out.println("Invalid value! Please try again...");
            scanner.next();
            return doubleValidation();
        }
    }

}
