import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GroupData {
    @JsonProperty
    public String name;

    @JsonProperty ("students")
    List<Integer> studentsIds;

    public GroupData(String name, List<Integer> students) {
        this.name = name;
        this.studentsIds = students;
    }

    public GroupData() {}
}
