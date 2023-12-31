package enums;

public enum UserStatusEnum {
    REKTOR(1),
    STUDENT(2),
    GUEST(3);
    private final int index;

    UserStatusEnum(int index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }

    public static void show() {
        for (UserStatusEnum status : UserStatusEnum.values()) {
            System.out.println(status.getIndex() + ") " + status);
        }
    }

    public static UserStatusEnum getStatusByIndex(int index) {
        for (UserStatusEnum use : UserStatusEnum.values()) {
            if (index == use.getIndex()) {
                return use;
            }
        }
        return null;
    }
}
