package ru.tsc.sberTask.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import ru.tsc.sberTask.DataBase;
import ru.tsc.sberTask.SberTaskApplication;
import ru.tsc.sberTask.dao.Finder;
import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SberTaskApplication.class)
public class MemberControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;

    @Before
    public void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        DataBase.membersGroups.clear();
    }


    @Test
    public void findYoungerThen() throws Exception {
        addOneMemberToDB();
        String url = "/members/youngerThen/6" ;
        HttpEntity entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        Member expected = new Member("Donald",5);

        String result = response.getBody();

        String expectedText = "{" +
                "\"data\":[{" +
                "\"name\":\"" + expected.getName()
                +"\",\"age\":" + expected.getAge()
                + "}]}";
        assertTrue(result.equals(expectedText));
    }

    private void addOneMemberToDB(){
        Member member = new Member("Donald",5);
        List<Member> list = new ArrayList<>();
        list.add(member);
        MembersGroup membersGroup = new MembersGroup("someGroupName",list);
        DataBase.membersGroups.add(membersGroup);
    }

}