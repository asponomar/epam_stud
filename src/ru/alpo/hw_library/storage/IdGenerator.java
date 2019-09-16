package ru.alpo.hw_library.storage;

public final class IdGenerator {
    private static long id = 0;

    private IdGenerator() {

    }

    public static Long generateId() {
        return ++id;
    }
}
