package ProjectNeptune.neptune;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@RestController
public class HelloController {

   @Autowired
   private StringRedisTemplate template;

   @RequestMapping("/")
     public String hello() {

      ValueOperations<String, String> ops = this.template.opsForValue();

      
      String key = "greeting";
      if (!this.template.hasKey(key)) {
          ops.set(key, "Welcome to Project Neptune!");
      }

      
      return ops.get(key);
   }
}