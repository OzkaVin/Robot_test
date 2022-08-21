import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.Inherited;

public class Student extends StudentData{
    @JsonProperty
    public Integer id;

    public Student(Integer id, String firstName, String lastName) {
        super(firstName, lastName);
        this.id = id;
    }

    public Student(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                id.equals(that.id);
    }
}
