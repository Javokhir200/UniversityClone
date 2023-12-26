package enums;

public enum UserStatusEnum {
    ADMIN(1),
    TEACHER(2),
    STUDENT(3),
    GUEST(4);
    private int index;
    UserStatusEnum(int index){
        this.index = index;
    }
}
