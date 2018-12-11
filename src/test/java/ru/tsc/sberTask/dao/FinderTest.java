package ru.tsc.sberTask.dao;

import org.junit.Test;
import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FinderTest {
    @Test
    public void findOldMembers() throws Exception {
        Member member5 = new Member("Arsen",32);
        Member member6 = new Member("Gosha",16);
        Member member7 = new Member("Anatoliy",56);
        Member member8 = new Member("Lyudmila",66);

        List<Member> list1 = new ArrayList<>();
        List<Member> list2 = new ArrayList<>();

        list1.add(member5);
        list1.add(member7);
        list2.add(member6);
        list2.add(member8);

        List<MembersGroup> listForCheck = new ArrayList<>();
            listForCheck.add(new MembersGroup("1",list1));
            listForCheck.add(new MembersGroup("2",list2));

        Finder finder = new Finder();
        Set<String> checkAns = finder.findOldMembers(listForCheck);

        assertTrue(checkAns.size() == 2);
        assertTrue(checkAns.contains("Anatoliy"));
        assertTrue(checkAns.contains("Lyudmila"));
    }

}