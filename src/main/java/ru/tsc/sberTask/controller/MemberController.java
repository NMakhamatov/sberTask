package ru.tsc.sberTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tsc.sberTask.CustomDataOut;
import ru.tsc.sberTask.DataBase;
import ru.tsc.sberTask.dao.Finder;
import ru.tsc.sberTask.model.Member;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "members/")
public class MemberController {

    private Finder dao;

    @Autowired
    public void setDao(Finder dao) {
        this.dao = dao;
    }

    @GetMapping(value = "youngerThen/{age}")
    public ResponseEntity<CustomDataOut> findYoungerThen(@PathVariable int age) {
        List<Member> list = dao.findMembersYoungerThen(age);
        CustomDataOut<List<Member>> dataOut = new CustomDataOut<>(list);
        return new ResponseEntity<CustomDataOut>(dataOut, HttpStatus.OK);
    }

    @GetMapping(value = "getOldMembers")
    public ResponseEntity<CustomDataOut> findOldMembers () {
        Set<String> set = dao.findOldMembers(DataBase.membersGroups);
        CustomDataOut<Set<String>> dataOut = new CustomDataOut<>(set);
        return new ResponseEntity<CustomDataOut>(dataOut,HttpStatus.OK);
    }
}
