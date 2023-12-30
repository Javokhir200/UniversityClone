package enums;

public enum UserStatusEnum {
    REKTOR(1),
    TEACHER(2),
    STUDENT(3),
    GUEST(4);
    private int index;
    UserStatusEnum(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void show(){
        for(UserStatusEnum status:UserStatusEnum.values()){
            System.out.println(status.getIndex() + ") " + status);
        }
    }
}
