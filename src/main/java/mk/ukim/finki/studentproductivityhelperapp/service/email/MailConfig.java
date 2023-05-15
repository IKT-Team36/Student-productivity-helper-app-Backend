package mk.ukim.finki.studentproductivityhelperapp.service.email;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("localhost"); // MailDev host
        mailSender.setPort(1025); // MailDev port
        mailSender.setUsername("hello");
        mailSender.setPassword("hello");

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.auth", "false");
        properties.put("mail.smtp.starttls.enable", "false");

        return mailSender;
    }
}