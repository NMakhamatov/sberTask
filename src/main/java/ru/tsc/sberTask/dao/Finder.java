package ru.tsc.sberTask.dao;

import org.springframework.stereotype.Repository;
import ru.tsc.sberTask.DataBase;
import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class Finder implements FinderInterface {
//    public static interface OldMemberFinder {
//        public Set<String> findOldMembers(List<MembersGroup> listMembers);
//    }
//
//    public static interface YoungerThenFinder {
//        public List<Member> findMembersYoungerThen(int age);
//    }

//    public static class FinderOldMan   {
//        public Set<String> findOldMembers(List<MembersGroup> groups) {
//            Set<String> groupsNames = new HashSet<>();
//            for (MembersGroup membersGroup : groups) {
//                for (Member member : membersGroup.getMembers()) {
//                    if (member.getAge() > 50) {
//                        String name = member.getName();
//                        groupsNames.add(name);
//                    }
//                }
//            }
//            return groupsNames;
//        }
//    private final EntityManager entityManager;
//
//    @Autowired
//    public Finder(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    public Finder() {
    }

    @Override
    public Set<String> findOldMembers(List<MembersGroup> groups) {
        return groups.stream()
                .flatMap(membersGroup -> membersGroup.getMembers().stream())
                .filter(member -> member.getAge() > 50)
                .map(Member::getName)
                .collect(Collectors.toSet());
    }
//    }

    //    public static class FinderYoungMan implements YoungerThenFinder {
    @Override
    public List<Member> findMembersYoungerThen(int age) {
        return DataBase.membersGroups.stream()
                .flatMap(membersGroup -> membersGroup.getMembers().stream())
                .filter(member -> member.getAge() < age)
                .collect(Collectors.toList());
    }
}


//}
