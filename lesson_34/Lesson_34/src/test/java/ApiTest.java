import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest extends BaseTest{
    final int n = 3;
    StudentData[] allStudentsInit = new StudentData[n];
    List<Student> studentsResp= new ArrayList<Student>();
    GroupData studentsGroupInit = new GroupData();
    Group studentsGroup = new Group();
    String assignmContentInit;
    AssignmentContent assignmContent = new AssignmentContent();
    StudentAssignmentPOST[] groupAssignment = new StudentAssignmentPOST[n];

    @BeforeTest
    public void setUpTestingData(){
        for(int i = 0; i<n; i++)
            allStudentsInit[i] = new StudentData(randomAlphabetic(5), randomAlphabetic(5));

        assignmContentInit = "This is an assignment content";
    }

    public void testStudentCreation(int i){
        Student student = RestAssured.given()
                .body(allStudentsInit[i])
                .header("user-token", sessionToken)
                .post("/students")
                .then().statusCode(200)
                .body("first_name", equalTo(allStudentsInit[i].firstName))
                .body("last_name", equalTo(allStudentsInit[i].lastName))
                .extract().as(Student.class);
        studentsResp.add(student);

        // Verification of student creation via GET
        RestAssured.given()
                .queryParam("id", student.id)
                .header("user-token", sessionToken)
                .when().get("/students/{id}",student.id)
                .then().statusCode(200)
                .body("first_name", equalTo(student.firstName))
                .body("last_name", equalTo(student.lastName))
                .body("id", equalTo(student.id));
    }

    @Test
    public void testStudentsCreation(){
        for(int i = 0; i<allStudentsInit.length; i++)
            testStudentCreation(i);
    }

    @Test (dependsOnMethods = "testStudentsCreation")
    public void testGroupCreation(){
        studentsGroupInit.name = "Test" + randomAlphanumeric(3);
        studentsGroupInit.studentsIds = studentsResp.stream().map(student -> student.id).collect(Collectors.toList());

        studentsGroup = RestAssured.given()
                .body(studentsGroupInit)
                .header("user-token", sessionToken)
                .post("/groups")
                .then().statusCode(200)
                .body("name", equalTo(studentsGroupInit.name))
                .body("students.size()", equalTo(studentsGroupInit.studentsIds.size()))
                .extract().as(Group.class);

        // Verification of student creation via GET
        Group studentsGroupFromGET = RestAssured.given()
                .queryParam("id", studentsGroup.id)
                .header("user-token", sessionToken)
                .when().get("groups/{id}", studentsGroup.id)
                .then().statusCode(200)
                .body("id", equalTo(studentsGroup.id))
                .body("name", equalTo(studentsGroup.name))
                .body("students.size()", equalTo(studentsGroup.students.size()))
                .extract().as(Group.class);

        // Comparing student lists inside of POST ang GET responses for Group
        Assert.assertTrue(studentsGroup.students.equals(studentsGroupFromGET.students));
    }

    @Test
    public void testAssignmContentCreation(){
        JSONObject joAssignmContent = new JSONObject();
        joAssignmContent.put("content", assignmContentInit);

        assignmContent = RestAssured.given()
                .body(joAssignmContent.toString())
                .header("user-token", sessionToken)
                .post("/content")
                .then().statusCode(200)
                .body("content", equalTo(assignmContentInit))
                .extract().as(AssignmentContent.class);

        AssignmentContent[] assignmContentsFromGET = RestAssured.given()
                .header("user-token", sessionToken)
                .when().get("content")
                .then().statusCode(200)
                .extract().as(AssignmentContent[].class);

        Assert.assertTrue(Arrays.asList(assignmContentsFromGET).contains(assignmContent));
    }

    @Test(dependsOnMethods = {"testGroupCreation", "testAssignmContentCreation"})
    public void testCreateAssignmToStudentsGroup() {
        JSONObject joAssignmPost = new JSONObject();
        joAssignmPost.put("target_type", "group");
        joAssignmPost.put("group_id", studentsGroup.id);
        joAssignmPost.put("content_id", assignmContent.id);

        groupAssignment = RestAssured.given()
                .body(joAssignmPost.toString())
                .header("user-token", sessionToken)
                .post("/assignments")
                .then().statusCode(200)
                .body("size()", equalTo(studentsGroup.students.size()))
                .extract().as(StudentAssignmentPOST[].class);

        for (StudentAssignmentPOST assignment : groupAssignment) {
            StudentAssignment assignmFromGET = RestAssured.given()
                    .header("user-token", sessionToken)
                    .when().get("assignments/{id}", assignment.id)
                    .then().statusCode(200)
                    .body("id", equalTo(assignment.id.toString()))
                    .body("solution", equalTo(assignment.solution))
                    .body("mark", equalTo(assignment.mark))
                    .extract().as(StudentAssignment.class);

            Assert.assertTrue(assignment.contentId.toString().equals(assignmFromGET.content.id));
            Assert.assertTrue(assignment.studentId.equals(assignmFromGET.student.id));

        }
    }
}
