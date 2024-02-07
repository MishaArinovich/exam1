package exam1;

import java.util.Scanner;

public class FinancialCalculator {

    private static double[] expenses = new double[30];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;


        do {
            System.out.println("Меню");
            System.out.println("1) Ввести оасходы за определеённый день");
            System.out.println("2) Траты за месяц");
            System.out.println("3) Саммая большая сумма расхода за месяц");
            System.out.println("4) Конвертор валюты");
            System.out.println("0) Выход");
            System.out.print("Введите выбранный пункт");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    enterExpenses(scanner);
                    break;
                case 2:
                    displayExpenses();
                    break;
                case 3:
                    MaxExpenses();
                    break;
                case 4:
                    ConvrtVal();
                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                    break;
                default:

                    System.out.println("Неверный выбор.");
                    break;

            }
        } while (choice != 0);



    }


    private static void enterExpenses(Scanner scanner)
    {
        System.out.print("Введите день(от 1 до 30");
        int day = scanner.nextInt();

        if (day < 1 || day > 30){
            System.out.println("Неправильно");
            return;
        }

        System.out.print("траты за текущий день");
        double expense = scanner.nextDouble();

        if (expenses[day - 1] != 0){
            System.out.print("Вы хотите перезаписать? (да/нет)");
            String overwrite = scanner.next();
            if (overwrite.equalsIgnoreCase("нет")){
                return;
            }
        }

        expenses[day - 1] = expense;
        System.out.println("Суммп трат перезаписано");
    }

    private static void displayExpenses(){
        for (int i = 0; i < expenses.length; i++){
            System.out.println((i + 1) + "день -" + expenses[i] + "руб");
        }
    }
    private static void MaxExpenses(){
        double maxExpensce = 0;
        int maxDay = -1;

        for(int i = 0; i < expenses.length; i++){
            if (expenses[i] > maxExpensce){
                maxExpensce = expenses[i];
                maxDay = i + 1;
            }
        }

        if (maxDay != -1) {
            System.out.println(maxDay + "день -" + maxExpensce + "руб" );
        }

        else {
            System.out.println("нет информации");
        }
    }

    private static void ConvrtVal()
    {
        double euro = 96;

        double dollar = 89;

        double cny = 12;

        double totalExpenses = 0;

        for(double expanse : expenses){
            totalExpenses += expanse;
        }

        double euroexpenses = totalExpenses * euro;
        double dollarex = totalExpenses * dollar;
        double cnyx = totalExpenses * cny;

        System.out.println("Траты за месяц в евро: " + euroexpenses);
        System.out.println("Траты за месяц в долларах: " + dollarex);
        System.out.println("Траты в месяц в юани: "+ cnyx);
    }
}