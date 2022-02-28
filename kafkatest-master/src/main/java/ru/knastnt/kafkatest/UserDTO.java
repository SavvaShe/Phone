package ru.knastnt.kafkatest;

public class UserDTO {
    private String name;
    private int age;
    private String phone;

    public static UserDTO getTestInstance(){
        UserDTO u = new UserDTO();
        u.setName("Иван");
        u.setAge(25);
        u.setPhone("89256701133");

        u.setName("Сергей");
        u.setAge(26);
        u.setPhone("89256701231");

        u.setName("Ирина");
        u.setAge(21);
        u.setPhone("89232701131");

        u.setName("Александр");
        u.setAge(15);
        u.setPhone("89256741131");
        return u;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
