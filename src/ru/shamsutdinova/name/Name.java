package ru.shamsutdinova.name;

public final class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        if (isEmpty(firstName) && isEmpty(lastName))
            throw new IllegalArgumentException("Хотя бы одно поле должно быть непустым");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static boolean isEmpty(String s) { return s == null || s.trim().isEmpty(); }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty(firstName)) sb.append(firstName);
        if (!isEmpty(lastName)) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(lastName);
        }
        return sb.toString();
    }
}