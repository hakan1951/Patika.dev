public class Employee {
    private String name;
    private double salary;
    private int workHours; //weekly work hours.
    private final int hireYear;

    public Employee(String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    private double tax(double salary){
        double taxPercent = 0;
        if (salary > 1000){
            taxPercent = 0.03; // %3
        }
        return salary * taxPercent; // tax amount
    }
    private double bonus(int workHours){
        int weeklyHours = 40;
        double bonus = 0;
        int bonusPerHour = 30;
        if (workHours > weeklyHours){
            bonus = (workHours - weeklyHours) * bonusPerHour;
        }
        return bonus;
    }
    private double raiseSalary(int hireYear){
        int currentYear = 2021;
        double raiseMultiplier;
        int workYear = currentYear - hireYear;
        if (workYear < 10){
            raiseMultiplier = 0.05; // 5% increase.
        }else if (workYear < 20){
            raiseMultiplier = 0.10;
        }else {
            raiseMultiplier = 0.15;
        }
        return salary * raiseMultiplier;
    }
    @Override
    public String toString() {
        return  "Name = " + name +
                "\nSalary = " + salary +
                "\nWorkHours = " + workHours +
                "\nTax = " + tax(salary)+
                "\nBonus = " + bonus(workHours) +
                "\nRaiseAmount = " + raiseSalary(hireYear) +
                "\nSalaryWithTaxAndBonus = " + (salary + bonus(workHours) - tax(salary)) +
                "\nTotalSalary = " + (salary + tax(salary));
    }
}
