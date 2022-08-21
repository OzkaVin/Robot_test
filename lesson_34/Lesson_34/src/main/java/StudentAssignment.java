import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentAssignment {
    @JsonProperty
    public String id;

    @JsonProperty
    public String solution;

    @JsonProperty
    public Integer mark;

    @JsonProperty
    public Student student;

    @JsonProperty
    public AssignmentContent content;
}
