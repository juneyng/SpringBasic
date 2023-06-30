package basicspring.basicspringhello.service;

import basicspring.basicspringhello.repository.JdbcMemberRepository;
import basicspring.basicspringhello.repository.MemberRepository;
import basicspring.basicspringhello.repository.MemoryMemberRepository;
import basicspring.basicspringhello.service.MemberService;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
    
}
