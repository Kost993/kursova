package storage;

import singleton.FitnessCenter;

import java.io.*;

public class DataManager {

    private static final String FILE_NAME =
            "fitness_center.dat";

    public static void save(
            FitnessCenter center) {

        try(ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    FILE_NAME))) {

            out.writeObject(center);

            System.out.println(
                    "Дані успішно збережено."
            );

        } catch (IOException e) {

            System.out.println(
                    "Помилка збереження."
            );
        }
    }

    public static FitnessCenter load() {

        try(ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(
                                    FILE_NAME))) {

            System.out.println(
                    "Дані успішно завантажено."
            );

            return (FitnessCenter)
                    in.readObject();

        } catch (Exception e) {

            System.out.println(
                    "Файл не знайдено."
            );

            return null;
        }
    }
}