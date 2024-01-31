package dto;

import java.util.ArrayList;

public class Human {
    public String name;
    public Integer age;
    public Boolean isClever;
    public ArrayList<String> hobbies;
    public Passport passport;
    public String phone;

    public static class Passport{
        public String id;
        public String gender;
    }
}
