import com.flash.main.ProviderApplication8001;
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
@SpringBootTest(classes = ProviderApplication8001.class)
@WebAppConfiguration
public class ElasticsearchTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test1() {

        System.out.println(restHighLevelClient);

    }



}