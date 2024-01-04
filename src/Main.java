import domain.Faculty;
import domain.Group;
import domain.User;
import enums.UserStatusEnum;
import service.FacultyService;
import service.GroupService;
import service.SubjectService;
import service.UserService;
import service.impl.FacultyServiceImpl;
import service.impl.GroupServiceImpl;
import service.impl.SubjectServiceImpl;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static FacultyService facultyService = new FacultyServiceImpl();
    static GroupService groupService = new GroupServiceImpl();
    static SubjectService subjectService = new SubjectServiceImpl();
    static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        printWelcome();
        while (true) {
            printRegisterMenu();
            System.out.print("What you gonna do : ");
            int put = scNum.nextInt();
            if (put == 0) break;
            switch (put) {
                case 1 -> {
                    System.out.print("Enter your full name: ");
                    String name = scStr.nextLine();
                    System.out.print("Create a password: ");
                    String password = scStr.nextLine();
                    System.out.print("Enter a new username: ");
                    String userName = scStr.nextLine();
                    User user = new User(name, password, userName, UserStatusEnum.GUEST);
                    var register = userService.register(user);
                    if (register != null) {
                        System.out.println("Succesfuelly !");
                        printGuestMenu();
                    }
                    System.out.println("Something went wrong, Try again !");
                }
                case 2 -> {
                    System.out.print("Enter your username : ");
                    String username = scStr.nextLine();
                    System.out.print("Enter your password : ");
                    String password = scStr.nextLine();
                    var login = userService.login(password, username);
                    if (login != null && login.getStatus().equals(UserStatusEnum.REKTOR)) {
                        System.out.println("Succesfuelly !");
                        printRectorMenu(login);
                    } else if (login != null && login.getStatus().equals(UserStatusEnum.STUDENT)) {
                        System.out.println("Succesfuelly !");
                        printStudentMenu(login);
                    } else if (login != null && login.getStatus().equals(UserStatusEnum.GUEST)) {
                        System.out.println("Succesfuelly !");
                        printGuestMenu();
                    }
                    System.out.println("Something went wrong, Try again !");
                }
                default -> System.out.println("Enter a numbers that given in menu.");
            }
        }
    }

    private static void printRectorMenu(User rector) {
        while (true) {
            printRectorUses();
            System.out.print("What you gonna do :");
            int put = scNum.nextInt();
            if (put == 0) break;
            switch (put) {
                case 1 -> {
                    System.out.print("Enter name faculty :");
                    String name = scStr.nextLine();
                    Faculty faculty = new Faculty(name);
                    facultyService.addFaculty(faculty);
                }
                case 2 -> {
                    facultyService.show();
                    System.out.print("Enter an id faculty to delete :");
                    int id = scNum.nextInt();
                    facultyService.removeFaculty(id);
                }
                case 3 -> {
                    facultyService.show();
                    System.out.print("Enter a faculty id :");
                    int id = scNum.nextInt();
                    System.out.print("Enter a group name :");
                    String name = scStr.nextLine();
                    Group group = new Group(id, name);
                    groupService.addGroup(group);
                }
                case 4 -> {
                    groupService.showAllGroups();
                    System.out.print("Enter an id group to delete :");
                    int id = scNum.nextInt();
                    groupService.deleteGroup(id);
                }
                case 5 -> {
                    System.out.print("Enter a new username :");
                    String username = scStr.nextLine();
                    userService.changeUsername(rector.getUserId(), username);
                }
                case 6 -> {
                    System.out.print("Enter new password :");
                    String password = scStr.nextLine();
                    userService.changePassword(rector.getUserId(), password);
                }
                case 7 -> {
                    userService.showAllUsers();
                    System.out.print("Enter an id user to change status :");
                    int id = scNum.nextInt();
                    UserStatusEnum.show();
                    System.out.print("Enter an index to set status :");
                    int index = scNum.nextInt();
                    userService.changeStatus(id, UserStatusEnum.setStatusByIndex(index));
                }
            }
        }
    }

    private static void printRectorUses() {
        System.out.println("""
                |--- Rector Menu ---|
                                
                1.Create faculty
                2.Delete faculty
                3.Create group
                4.Delete group
                5.Change username
                6.Change password
                7.Change User status
                                
                0.Back to register menu
                |------------------|
                """);
    }

    private static void printStudentMenu(User student) {
        while (true) {
            printStudentUses();
            System.out.print("What you gonna do: ");
            int put = scNum.nextInt();
            if (put == 0) break;
            switch (put) {
                case 1 -> {
                    System.out.println("Enter a new username : ");
                    String username = scStr.nextLine();
                    userService.changeUsername(student.getUserId(), username);
                }
                case 2 -> {
                    System.out.print("Enter a new password : ");
                    String password = scStr.nextLine();
                    userService.changePassword(student.getUserId(), password);
                }
                case 3 -> groupService.showSubjects(student.getGroupId());
                default -> System.out.println("Enter a numbers that given in menu.");
            }
        }
    }

    private static void printStudentUses() {
        System.out.println("""
                |--- Student Menu ---|
                                
                1.Change username
                2.Change password
                3.Show subjects
                                
                0.Back to register menu
                |-------------------|
                """);
    }

    private static void printGuestMenu() {
        while (true) {
            printGuestUses();
            System.out.print("What you gonna do :");
            int put = scNum.nextInt();
            if (put == 0) break;
            switch (put) {
                case 1 -> facultyService.show();
                case 2 -> groupService.showAllGroups();
                default -> System.out.println("Enter a number that given in menu.");
            }
        }
    }

    private static void printGuestUses() {
        System.out.println("""
                |--- Guest Menu ---|
                                
                1.Show faculties
                2.Show groups
                                
                0.Back to register menu.
                |------------------|
                """);
    }

    private static void printRegisterMenu() {
        System.out.println("""
                |--- Register/Login Menu ---|
                                
                1.Register
                2.Login
                0.Exit
                |---------------------------|
                """);
    }

    private static void printWelcome() {
        System.out.println("""
                ░██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗  ████████╗░█████╗░  ░█████╗░██╗░░░██╗██████╗░
                ░██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝  ╚══██╔══╝██╔══██╗  ██╔══██╗██║░░░██║██╔══██╗
                ░╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░  ░░░██║░░░██║░░██║  ██║░░██║██║░░░██║██████╔╝
                ░░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░  ░░░██║░░░██║░░██║  ██║░░██║██║░░░██║██╔══██╗
                ░░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗  ░░░██║░░░╚█████╔╝  ╚█████╔╝╚██████╔╝██║░░██║
                ░░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝  ░░░╚═╝░░░░╚════╝░  ░╚════╝░░╚═════╝░╚═╝░░╚═╝
                                              
                ██╗░░░██╗███╗░░██╗██╗██╗░░░██╗███████╗██████╗░░██████╗██╗████████╗██╗░░░██╗
                ██║░░░██║████╗░██║██║██║░░░██║██╔════╝██╔══██╗██╔════╝██║╚══██╔══╝╚██╗░██╔╝
                ██║░░░██║██╔██╗██║██║╚██╗░██╔╝█████╗░░██████╔╝╚█████╗░██║░░░██║░░░░╚████╔╝░
                ██║░░░██║██║╚████║██║░╚████╔╝░██╔══╝░░██╔══██╗░╚═══██╗██║░░░██║░░░░░╚██╔╝░░
                ╚██████╔╝██║░╚███║██║░░╚██╔╝░░███████╗██║░░██║██████╔╝██║░░░██║░░░░░░██║░░░
                ░╚═════╝░╚═╝░░╚══╝╚═╝░░░╚═╝░░░╚══════╝╚═╝░░╚═╝╚═════╝░╚═╝░░░╚═╝░░░░░░╚═╝░░░""");
    }
}