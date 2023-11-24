package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {
    public static void main(String[] args) {
        int totalGames = 1000;
        Map<Integer, String> results = new HashMap<>();
        int winsSwitch = 0;
        int winsStay = 0;

        Random random = new Random();
        for (int i = 1; i <= totalGames; i++) {
            //Имитация игры
            int randomDoor = random.nextInt(3); //Случайная дверь с автомобилем
            int chosenDoor = random.nextInt(3); //Игрок выбирает дверь

            //Открытие одной из оставшихся дверей с козой
            int openedDoor;
            do {
                openedDoor = random.nextInt(3);
            } while (openedDoor == randomDoor || openedDoor == chosenDoor);

            //Меняем выбор или оставляем текущий выбор
            boolean switchChoice = random.nextBoolean();

            if (switchChoice) {
                //Меняем выбор
                chosenDoor = 3 - chosenDoor - openedDoor;
            }

            //Проверка результатов
            if (chosenDoor == randomDoor) {
                if (switchChoice) {
                    winsSwitch++;
                    results.put(i, "Победа со сменой двери");
                } else {
                    winsStay++;
                    results.put(i, "Победа без смены двери");
                }
            } else {
                results.put(i, "Поражение");
            }
        }

        //Вывод статистики
        System.out.println("Статистика по шагам:");
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            System.out.println("Шаг " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Победы со сменой двери: " + winsSwitch);
        System.out.println("Победы без смены двери: " + winsStay);
        System.out.println("Поражения: " + (totalGames - winsSwitch - winsStay));

    }
}
