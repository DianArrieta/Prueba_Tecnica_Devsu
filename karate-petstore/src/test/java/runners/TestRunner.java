package runners;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRunner {

    @Test
    public void testAll() {
        Results results = Runner.path("classpath:features").parallel(1);
        assertNotNull(results);
    }
}

