package ru.tsc.sberTask;

import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    public static List<MembersGroup> membersGroups = new ArrayList<>();

    static {
        Member member1 = new Member("Alexey",35);
        Member member2 = new Member("Irina", 29);
        Member member3 = new Member("Dmitriy", 19);
        Member member4 = new Member("Elena",22);
        Member member5 = new Member("Arsen",32);
        Member member6 = new Member("Gosha",16);
        Member member7 = new Member("Anatoliy",56);
        Member member8 = new Member("Lyudmila",66);


        List<Member> list1 = new ArrayList<>();
        List<Member> list2 = new ArrayList<>();

        list1.add(member1);
        list1.add(member2);
        list1.add(member3);
        list1.add(member7);

        list2.add(member4);
        list2.add(member5);
        list2.add(member6);
        list2.add(member8);

        membersGroups.add(new MembersGroup("developers",list1));
        membersGroups.add(new MembersGroup("testers",list2));
    }
}
