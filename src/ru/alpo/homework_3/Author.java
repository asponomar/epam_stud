package ru.alpo.homework_3;

public class Author {
    private String name;
    private String lastName;
    private Integer birthYear;
    private Integer deathYear;

    Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return name + " " + lastName;
    }

    public boolean isLiving() {
        return deathYear == null;
    }

    public String lifeTime() {
        if (isLiving()) {
            return birthYear + " - now";
        } else return birthYear + " - " + deathYear;
    }
}
