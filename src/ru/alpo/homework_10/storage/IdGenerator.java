package ru.alpo.homework_10.storage;

public final class IdGenerator {
    public static long id = 1;

    private IdGenerator() {

    }

    public static Long generateId() {
        return ++id;
    }
}
