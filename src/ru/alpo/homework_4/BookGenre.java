package ru.alpo.homework_4;

public enum BookGenre {
    NOVEL("Novel book"),
    POEMS("Book of poems"),
    SCIENCE("Book of science");

    private String description;

    BookGenre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
