package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Payment;
import za.ac.cput.domain.Project;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ProjectFactoryTest {
    // i. Object Equality Test
    @Test
    public void a_testCompareConsultant() {
        Project project = new Project();
        Project myProject = ProjectFactory.createProject("Saranto", "1 July 2023", "31 Dec 2023", "R85600", "Active");
        String projectDetails = myProject.getProjectName().toString();
        assertEquals(projectDetails, "Maximus");
    }


    // ii. Object Identity Test
    @Test
    public void b_testObjectIdentity() {
        Project project = new Project();
        Project project1 = ProjectFactory.createProject("Bison", "12 Feb 2023", "19 Sept 2023", "R22204", "Active");
        Project project2 =  project1;
        Project project3 = ProjectFactory.createProject("Sparta", "23 Jun 2003", "08 Sept 2023", "R1220000", "Inactive");

        assertSame(project1, project3);
    }

    // iii. Animal build Failing TEST
    @Test
    public void c_test_fail(){
        Project project = ProjectFactory.createProject("Radix", "17 Apr 2023", "01 July 2023", "R344355", "Active");
        assertNotNull(project);
        System.out.println(project.toString());

    }

    // iv. Timeout Test
    @Test
    void d_testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);

            System.out.println("Execution exceeded timout duration!");
        });
    }

    // v. Disabling Test
}