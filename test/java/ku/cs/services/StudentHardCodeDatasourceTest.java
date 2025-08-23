package ku.cs.services;

import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    StudentHardCodeDatasource datasource;
    StudentList studentList;

    @BeforeEach
    void init() {
        datasource = new StudentHardCodeDatasource();
        studentList = datasource.readData();
    }

    @Test
    @DisplayName("Test studentList not be null")
    void testNotNull() {
        boolean nullTest = false;
        if (studentList == null) nullTest = true;
        assertEquals(false, nullTest);
    }

    @Test
    @DisplayName("Test size of studentList Must be 4")
    void testSize() {
        assertEquals(4, studentList.getStudents().size());
    }

    @Test
    @DisplayName("Test Student Name and Id")
    void testStudents() {
        assertEquals("6710400001", studentList.getStudents().get(0).getId());
        assertEquals("First", studentList.getStudents().get(0).getName());

        assertEquals("6710400002", studentList.getStudents().get(1).getId());
        assertEquals("Second", studentList.getStudents().get(1).getName());

        assertEquals("6710400003", studentList.getStudents().get(2).getId());
        assertEquals("Third", studentList.getStudents().get(2).getName());

        assertEquals("6710400004", studentList.getStudents().get(3).getId());
        assertEquals("Fourth", studentList.getStudents().get(3).getName());
    }
}
