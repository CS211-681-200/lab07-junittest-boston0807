package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest {

    StudentList studentList;
    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("Test addNewStudent() เเบบไม่ใส่คะเเนน เเละใส่ 67 คะเเนน")
    void addNewStudent() {
        studentList.addNewStudent("6710423167", "test1");
        assertEquals("test1",studentList.getStudents().get(0).getName());
        assertEquals("6710423167",studentList.getStudents().get(0).getId());
        studentList.addNewStudent("6710451461", "test2", 67);
        assertEquals("test2",studentList.getStudents().get(1).getName());
        assertEquals("6710451461",studentList.getStudents().get(1).getId());
        assertEquals(67,studentList.getStudents().get(1).getScore());
    }

    @Test
    @DisplayName("Test findStudentById(String id) ด้วย id 6710451461")
    void testFindStudentById() {
        studentList.addNewStudent("6710423167", "test1");
        studentList.addNewStudent("6710451461", "test2", 67);
        assertEquals(studentList.getStudents().get(1), studentList.findStudentById("6710451461"));
    }

    @Test
    @DisplayName("Test filterByName(String name) by noi")
    void testFilterByName() {
        studentList.addNewStudent("6710451461", "Teenoi");
        studentList.addNewStudent("6710423167", "Moonoi");
        assertEquals(studentList.getStudents(), studentList.filterByName("noi").getStudents());

    }

    @Test
    @DisplayName("Test giveScoreToId 6710451461 50 point")
    void testGiveScoreToId(){
        studentList.addNewStudent("6710451461", "test", 15);
        studentList.giveScoreToId("6710451461", 50);
        assertEquals(65.0,studentList.findStudentById("6710451461").getScore());
    }

    @Test
    @DisplayName("Test viewGradeOfId 6710451461 expected F")
    void testViewGradeOfId(){
        studentList.addNewStudent("6710451461", "test");
        studentList.giveScoreToId("6710451461", 49);
        assertEquals("F", studentList.viewGradeOfId("6710451461"));
    }

    @Test
    @DisplayName("Test getStudents")
    void testGetStudents() {
        studentList.addNewStudent("6710451461", "test");
        studentList.addNewStudent("6710451462", "test2");
        assertEquals(studentList.getStudents(), studentList.filterByName("test").getStudents());
    }
}