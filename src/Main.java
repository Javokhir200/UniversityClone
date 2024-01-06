import domain.Faculty;
import domain.Group;
import domain.Subject;
import domain.User;
import enums.UserStatusEnum;
import service.GroupService;
import service.GroupSubjectService;
import service.SubjectService;
import service.UserService;
import service.impl.*;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    static UserService userService = new UserServiceImpl();
    static SubjectService subjectService = new SubjectServiceImpl();
    static FacultyServiceImpl facultyService = new FacultyServiceImpl();
    static GroupService groupService = new GroupServiceImpl();
    static GroupSubjectService groupSubjectService = new GroupSubjectServiceImpl();

    public static void main(String[] args) {
        welcome();
        boolean onProcess = true;
        while (onProcess) {
            showRegMenu();
            System.out.print("Enter the number: ");
            int regNum = scNum.nextInt();
            User loggedUser = null;
            switch (regNum) {
                case 0 -> {
                    onProcess = false;
                }
                case 1 -> {
                    System.out.print("Enter fullname: ");
                    String fullname = scStr.nextLine();
                    System.out.print("Enter strength password: ");
                    String password = scStr.nextLine();
                    System.out.print("Enter your username: ");
                    String username = scStr.nextLine();
                    if (userService.isValidUsername(username)) {
                        System.out.print("Enter your email: ");
                        String email = scStr.nextLine();
                        if (userService.isValidEmail(email)) {
                            System.out.println("We delivered confirmation code to your email.Check you email !!!");
                            String pass = userService.confirmationByEmail(email);
                            boolean confirm = true;
                            while (confirm) {
                                System.out.print("Enter confirmation code(4 digits or enter ../ to exit: ");
                                String conCode = scStr.nextLine();
                                if (pass.equals(conCode)) {
                                    loggedUser = userService.register(new User(fullname, email, username,password, UserStatusEnum.GUEST));
                                    System.out.println("You successfully entered !!!");
                                    confirm = false;
                                } else if (conCode.equals("../")) {
                                    confirm = false;
                                }
                            }
                            if (Objects.isNull(loggedUser)) {
                                System.out.println("You missed enter smth at registration !!!");
                            } else {
                                GuestMenu(loggedUser);
                            }
                        } else {
                            System.out.println("This email already registered !!!");
                        }
                    } else {
                        System.out.println("This username already taken !!!");
                    }
                }
                case 2 -> {
                    System.out.print("Enter your username: ");
                    String username = scStr.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scStr.nextLine();
                    loggedUser = userService.login(username, password);
                    findStatus(loggedUser);
                }
                case 3 -> {
                    System.out.print("Enter your email: ");
                    String email = scStr.nextLine();
                    if (userService.isValidEmail(email)) {
                        userService.confirmationByEmail(email);
                        System.out.println("We delivered confirmation code to your email.Check your email !!!");
                        String pass = userService.confirmationByEmail(email);
                        boolean confirm = true;
                        int chance = 5;
                        while (confirm) {
                            System.out.print("Enter confirmation code(4 digits or enter ../ to exit");
                            String conCode = scStr.nextLine();
                            if (pass.equals(conCode)) {
                                loggedUser = userService.login(email);
                                System.out.println("You successfully entered !!!");
                                confirm = false;
                            } else if (conCode.equals("../")) {
                                confirm = false;
                            }
                        }
                        findStatus(loggedUser);
                    } else {
                        System.out.println("This email is not registered !!!");
                    }
                }
            }
        }
    }

    private static void RektorMenu(User rektor) {
        boolean onProcess = true;
        while (onProcess) {
            showRektorMenu();
            System.out.print("Enter the number: ");
            int rekMenuNum = scNum.nextInt();
            switch (rekMenuNum) {
                case 0 -> {
                    onProcess = false;
                }
                case 1 -> {
                    System.out.print("Enter the name of faculty: ");
                    String facultyName = scStr.nextLine();
                    System.out.println(facultyService.addFaculty(new Faculty(facultyName)));
                }
                case 2 -> {
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int facultyId = scNum.nextInt();
                    System.out.println(facultyService.removeFaculty(facultyId));
                }
                case 3 -> {
                    facultyService.showAllFaculties();
                }case 4->{
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int facultyId = scNum.nextInt();
                    if (Objects.isNull(facultyService.getFacultyById(facultyId))){
                        System.out.println("This faculty is not exist !!!");
                    }else{
                        System.out.print("Enter group name: ");
                        String groupName = scStr.nextLine();
                        System.out.println(groupService.addGroup(new Group(facultyId, groupName)));
                    }
                }case 5->{
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int faculty = scNum.nextInt();
                    if (Objects.isNull(facultyService.getFacultyById(faculty))){
                        System.out.println("This faculty is not exist !!!");
                    }else{
                        groupService.showAllGroupsByFacultyId(faculty);
                        System.out.print("Enter group id: ");
                        int groupId = scNum.nextInt();
                        System.out.println(groupService.deleteGroup(faculty, groupId));
                    }
                }case 6->{
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int faculty = scNum.nextInt();
                    groupService.showAllGroupsByFacultyId(faculty);
                }case 7->{
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int faculty = scNum.nextInt();
                    groupService.showAllGroupsByFacultyId(faculty);
                    System.out.print("Enter the id of group: ");
                    int groupId = scNum.nextInt();
                    subjectService.showSubjects();
                    System.out.print("Enter the id of subject: ");
                    int subId = scNum.nextInt();
                    System.out.println(groupSubjectService.addSubjectToGroup(groupId, subId));
                }case 8->{
                    facultyService.showAllFaculties();
                    System.out.print("Enter the id of faculty: ");
                    int faculty = scNum.nextInt();
                    groupService.showAllGroupsByFacultyId(faculty);
                    System.out.print("Enter the id of group: ");
                    int groupId = scNum.nextInt();
                    groupSubjectService.showSubjectsByGroupId(groupId);
                    System.out.print("Enter the id of subject: ");
                    int subId = scNum.nextInt();
                    System.out.println(groupSubjectService.removeSubjectFromGroup(groupId, subId));
                }case 9->{
                    userService.showAllUsers();
                    System.out.print("Enter the id of user: ");
                    int userId = scNum.nextInt();
                    System.out.println(userService.delete(userId));
                }case 10->{
                    userService.showAllUsers();
                    System.out.print("Enter the id of user: ");
                    int userId = scNum.nextInt();
                    UserStatusEnum.show();
                    System.out.print("Enter the id of status: ");
                    int statusId= scNum.nextInt();
                    if (statusId == UserStatusEnum.STUDENT.getIndex()){
                        facultyService.showAllFaculties();
                        System.out.print("Enter the id of faculty: ");
                        int facultyId = scNum.nextInt();
                        groupService.showAllGroupsByFacultyId(facultyId);
                        System.out.print("Enter the id of faculty: ");
                        int groupId = scNum.nextInt();
                    System.out.println(userService.changeStatus(userId,UserStatusEnum.getStatusByIndex(statusId),facultyId,groupId));

                    }
                }case 11->{
                    System.out.print("Enter the new password: ");
                    String newPass = scStr.nextLine();
                    System.out.println(userService.changePassword(rektor.getUserId(), newPass));
                }case 12->{
                    System.out.print("Enter the new email: ");
                    String newEmail = scStr.nextLine();
                    System.out.println("We have sent code to your email !!!");
                    String pass = userService.confirmationByEmail(newEmail);
                    try {
                        Thread.sleep(3000);
                        int chance = 5;
                        boolean isNotConfirmed = true;
                        while (chance>0 && isNotConfirmed){
                            System.out.print("Enter the code we have sent: ");
                            String code = scStr.nextLine();
                            if (pass.equals(code)){
                                System.out.println(userService.changeEmail(rektor.getUserId(), newEmail));
                                isNotConfirmed = false;
                            }else{
                                System.out.println("Incorrect code !!!\nYou have " + (--chance) + " chances !!!");
                            }
                        }
                    } catch (InterruptedException e) {
                        System.out.println("There is not a huge problem !!!");
                    }
                }case 13->{
                    System.out.print("Enter the new username: ");
                    String username = scStr.nextLine();
                    System.out.println(userService.changeUsername(rektor.getUserId(), username));
                }case 14->{
                    userService.showAllUsers();
                }
                case 15->{
                    System.out.print("Enter the new Subject: ");
                    String username = scStr.nextLine();
                    System.out.println(subjectService.addSubject(new Subject(username)));
                }case 16->{
                    subjectService.showSubjects();
                    System.out.print("Enter the id of subject: ");
                    int num = scNum.nextInt();
                    System.out.println(subjectService.removeSubject(num));
                }
                default -> {
                    System.out.println("Enter the number 0 to 13 !!!");
                }
            }
        }
    }

    private static void showRektorMenu() {
        System.out.println("""
                |==========================================| Rektor Menu |=============================================|
                |------------------------------------------------------------------------------------------------------|
                |==| Faculty Settings |==|  Group Settings  |==|    User Settings   |==|      Subject Settings      |==|
                |------------------------------------------------------------------------------------------------------|
                |==| 1.Add Faculty    |==| 4.Add group      |==|  9.Delete user     |==| 15.Add Subject to List      ==|
                |==| 2.Remove Faculty |==| 5.Remove group   |==| 10.Change Status   |==| 16.Remove Subject from List ==|
                |==| 3.Show Faculties |==| 6.Show groups    |==| 11.Change password |==================================|
                |========================| 7.Add subject    |==| 12.Change email    |==================================|
                |========================| 8.Remove subject |==| 13.Change username |==================================|
                |==============================================| 14.Show users      |==================================|
                |------------------------------------------------------------------------------------------------------|
                |=========================================|      0.Exit      |=========================================|
                |------------------------------------------------------------------------------------------------------|
                """);
    }

    private static void StudentMenu(User student) {
        boolean onProcess = true;
        while (onProcess) {
            showStudentMenu();
            System.out.print("Enter the number: ");
            int studentMenuNum = scNum.nextInt();
            switch (studentMenuNum) {
                case 0 -> {
                    onProcess = false;
                }case 1->{
                    groupSubjectService.showSubjectsByGroupId(student.getGroupId());
                }case 2->{
                    System.out.print("Enter the new email: ");
                    String newEmail = scStr.nextLine();
                    System.out.println("We have sent code to your email !!!");
                    String pass = userService.confirmationByEmail(newEmail);
                    try {
                        Thread.sleep(3000);
                        int chance = 5;
                        boolean isNotConfirmed = true;
                        while (chance>0 && isNotConfirmed){
                            System.out.print("Enter the code we have sent: ");
                            String code = scStr.nextLine();
                            if (pass.equals(code)){
                                System.out.println(userService.changeEmail(student.getUserId(), newEmail));
                                isNotConfirmed = false;
                            }else{
                                System.out.println("Incorrect code !!!\nYou have " + (--chance) + " chances !!!");
                            }
                        }
                    } catch (InterruptedException e) {
                        System.out.println("There is not a huge problem !!!");
                    }
                }case 3->{
                    System.out.print("Enter the new username: ");
                    String username = scStr.nextLine();
                    System.out.println(userService.changeUsername(student.getUserId(), username));
                }case 4->{
                    System.out.print("Enter new password: ");
                    String newPassword = scStr.nextLine();
                    System.out.println(userService.changePassword(student.getUserId(), newPassword));
                }case 5->{
                    System.out.println(student.toString());
                }case 6->{
                    System.out.print("Enter your username: ");
                    String username = scStr.nextLine();
                    System.out.print("Enter your password: ");
                    String pass = scStr.nextLine();
                    System.out.println(userService.delete(username, pass));
                    onProcess = false;
                }default -> {
                    System.out.println("Enter the number 0 to 6 !!!");
                }
            }
        }
    }

    private static void showStudentMenu() {
        System.out.println("""
                ---| Student Menu |---
                1.Show Subjects
                2.Change email
                3.Change username
                4.Change password
                5.Show account info
                6.Delete account
                ----------------------
                0.Exit
                ----------------------
                """);
    }

    private static void GuestMenu(User guest) {
        boolean onProcess = true;
        while (onProcess) {
            showGuestMenu();
            System.out.print("Enter the number: ");
            int guestMenuNum = scNum.nextInt();
            switch (guestMenuNum) {
                case 0 -> {
                    onProcess = false;
                }
                case 1 -> {
                    System.out.println("Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                            "Eligendi non quis exercitationem culpa nesciunt nihil aut nostrum explicabo " +
                            "reprehenderit optio amet ab temporibus asperiores quasi cupiditate." +
                            " Voluptatum ducimus voluptates voluptas?");
                }case 2->{
                    System.out.println("Currently not available !!!");
                }
            }
        }
    }

    private static void showGuestMenu() {
        System.out.println("""
                ---------| Guest Menu |-----------
                1.Information about our University
                2.Connect to us
                                
                0.Exit
                ----------------------------------
                """);
    }

    private static void findStatus(User loggedUser) {
        if (Objects.isNull(loggedUser)) {
            System.out.println("This user is not exist !!!");
        } else {
            switch (loggedUser.getStatus()) {
                case GUEST -> {
                    GuestMenu(loggedUser);
                }
                case STUDENT -> {
                    StudentMenu(loggedUser);
                }
                case REKTOR -> {
                    RektorMenu(loggedUser);
                }
            }
        }
    }

    private static void showRegMenu() {
        System.out.println("""
                ======Menu======
                1.Registration
                2.Login
                3.I can't memorize my password
                                
                0.Exit
                ================
                """);
    }

    private static void welcome() {
        System.out.println("Welcome to our university's website");
    }
}