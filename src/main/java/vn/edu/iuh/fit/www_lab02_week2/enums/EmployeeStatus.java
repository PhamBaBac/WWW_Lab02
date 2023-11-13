package vn.edu.iuh.fit.www_lab02_week2.enums;

public enum EmployeeStatus {
    ACTIVE(1),
    TERMINATED(0),
    IN_ACTIVE(-1);

    private final int value;

    EmployeeStatus(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
    public static EmployeeStatus getByValue(int value) {
        for (EmployeeStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null; // or throw an exception if needed
    }
}
