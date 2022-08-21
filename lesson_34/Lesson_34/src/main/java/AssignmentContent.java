import com.fasterxml.jackson.annotation.JsonProperty;

public class AssignmentContent {
    @JsonProperty
    public String content;
    @JsonProperty
    public String id;

    public AssignmentContent() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentContent that = (AssignmentContent) o;
        return content.equals(that.content) &&
               id.equals(that.id);
    }
}
