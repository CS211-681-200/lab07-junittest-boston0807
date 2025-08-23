package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
    void init(){
        s = new Student("6710451461", "test");
    }

    @Test
    @DisplayName("คะเเนนของนิสิต 10 คะเเนน เพิ่มด้วย 30 คะเเนน")
    void testAddScore(){
        s.addScore(10);
        assertEquals(10, s.getScore());
        s.addScore(30);
        assertEquals(40, s.getScore());
    }

    @Test
    @DisplayName("เกรดของนิสิตคะเเนน 76 คะเเนน")
    void testGetGrade(){
        s.addScore(76);
        assertEquals("B+",s.grade());
    }

    @Test
    @DisplayName("Test การสร้าง object สองเเบบ หนึ่งคือไม่ระบุคะเเนน สองคือระบุคะเเนน 70.3 คะเเนน")
    void testStudent(){
        Student student1 = new Student("6710451323", "test1");
        assertEquals("6710451323",student1.getId());
        assertEquals("test1",student1.getName());
        assertEquals(0.0,student1.getScore());
        Student student2 = new Student("6710451323", "test2", 70.3);
        assertEquals("6710451323",student2.getId());
        assertEquals("test2",student2.getName());
        assertEquals(70.3,student2.getScore());
    }

    @Test
    @DisplayName("Test เปลี่ยนชื่อจาก test เป็น Teenoi")
    void testChangeName(){
        s.changeName("Teenoi");
        assertEquals("Teenoi",s.getName());
    }

    @Test
    @DisplayName("Test isId ด้วย ID 6710451461")
    void testIsId(){
        assertEquals(true, s.isId("6710451461"));
    }

    @Test
    @DisplayName("Test isNameContains(String name) ด้วย name TEST เเละ test")
    void testIsNameContains(){
        assertEquals(true, s.isNameContains("TEST"));
        assertEquals(true, s.isNameContains("test"));
    }
}