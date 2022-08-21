import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Group{
    @JsonProperty
    Integer id;

    @JsonProperty
    String name;

    @JsonProperty
    List<Student> students;
}
