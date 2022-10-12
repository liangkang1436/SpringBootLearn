package xyz.xiashuo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import xyz.xiashuo.domain.User;

@ConfigurationProperties(prefix = "myprop2")
public class MyPropertyMapBean2 {

    private String name;

    private Integer age;

    private String gender;

    private User userProperty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUserProperty() {
        return userProperty;
    }

    public void setUserProperty(User userProperty) {
        this.userProperty = userProperty;
    }

    @Override
    public String toString() {
        return "MyPropertyMapBean2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", userProperty=" + userProperty +
                '}';
    }
}
