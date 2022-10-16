package xyz.xiashuo.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import xyz.xiashuo.domain.Pet;
import xyz.xiashuo.domain.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private String studentInfo;
    private Pet pet;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salarys;
    private Map<String, List<Pet>> allPets;
    private Map<List<String>, List<User>> userOrganization;
    private Map<Pet, List<User>> petHome;

}
