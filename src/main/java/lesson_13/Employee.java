package lesson_13;

public class Employee  {
    private String fullName;
    private int workAge;
    private int personnelNumber;

    public Employee(String fullName, int workAge, int personnelNumber) {
        this.fullName = fullName;
        this.workAge = workAge;
        this.personnelNumber = personnelNumber;
    }
    public Employee(){}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public long getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    @Override
    public String toString() {
        return "Сотрудник {"
                +"ФИО ='" + fullName + '\''
                +", Сраж Работы = " + workAge
                +", Табельный номер = " + personnelNumber
                +'}';
    }

}
