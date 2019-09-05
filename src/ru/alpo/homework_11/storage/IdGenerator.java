package ru.alpo.homework_11.storage;

public final class IdGenerator {
    public static long id = 1;

    private IdGenerator() {

    }

    public static Long generateId() {
        return ++id;
    }
}
