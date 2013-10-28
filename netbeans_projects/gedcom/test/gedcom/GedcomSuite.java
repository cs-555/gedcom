package gedcom;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/** @author Alan */
@RunWith(Suite.class)
// @Suite.SuiteClasses({gedcom.FileLoaderTest.class, gedcom.OutputDisplayerTest.class, gedcom.BeanProducerTest.class, gedcom.PersonTest.class, gedcom.GedcomProcessServiceTest.class, gedcom.FamilyTest.class})
@Suite.SuiteClasses({gedcom.GedcomProcessServiceTest.class})

public class GedcomSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
