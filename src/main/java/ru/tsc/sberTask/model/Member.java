package ru.tsc.sberTask.model;

public class Member {
    private final String name;
    private final Integer age;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (!getName().equals(member.getName())) return false;
        return Integer.compare(getAge(),member.getAge()) == 0;
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        return result;
    }
}
