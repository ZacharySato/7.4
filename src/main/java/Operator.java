import java.util.Scanner;

public class Operator {

    public final void run() {
        for (Country country : Country.values()) {
            System.out.println(country.toString());
        }
        System.out.println("Для выхода введите \"Esc\", для проверки статуса введите название страны из списка:");
        boolean off = false;
        while (!off) {
            Scanner stream = new Scanner(System.in, "windows-1251");
            String input = stream.nextLine().trim();
            if (input.equalsIgnoreCase("esc")) {
                off = true;
                continue;
            }
            if (input.isEmpty()) {
                System.out.println("Получена пустая строка. Введите название страны из списка.");
                continue;
            }
            Country found;
            try {
                found = Country.valueOf(input.toUpperCase());
                found.statusLog();
            } catch (IllegalArgumentException e) {
                System.out.println("Наименование страны на английском введено некорректно,"
                        + "\n"
                        + " проверяем русское название...");
                //Выглядит странно с точки зрения читаемости
                try {
                    found = Country.getByRuName(input);
                    found.statusLog();
                } catch (NoCountryException e1) {
                    System.out.println(e1.getMessage());
                }
            } catch (NullPointerException e) {
                System.out.println("На поиск подано пустое значение.");
            }
        }
    }
}