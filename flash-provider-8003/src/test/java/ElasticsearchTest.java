import com.flash.ProviderApplication8003;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Elasticsearch 测试
 * @Author: LiLiang
 * @Date: 2019/12/19 13:42
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProviderApplication8003.class)
@WebAppConfiguration
public class ElasticsearchTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test1() {

        System.out.println(restHighLevelClient);

    }



}