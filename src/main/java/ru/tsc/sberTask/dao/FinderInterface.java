package ru.tsc.sberTask.dao;

import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.List;
import java.util.Set;

public interface FinderInterface {
    public Set<String> findOldMembers(List<MembersGroup> listMembers);
    public List<Member> findMembersYoungerThen(int age);

}
