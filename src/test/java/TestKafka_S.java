
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Saul on 11/29/16.
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestKafka_S {
    private static String BOOT_TOPIC = "boot.t";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testReceive() throws Exception {
//        sender.send(BOOT_TOPIC, "Hello Boot!");
//
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        assertThat(receiver.getLatch().getCount()).isEqualTo(0);
    }
}
