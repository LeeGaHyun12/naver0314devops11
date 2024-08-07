//package hello.hellospring.repository;
//
//import hello.hellospring.domain.Member;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//public class MemoryMemberRepository implements MemberRepository{
//
//    private static Map<Long, Member> store=new HashMap<>();
//    private static long sequence=0L;
//
//
//    @Override
//    public Member save(Member member) {
//        member.setId(++sequence);
//        store.put(member.getId(),member);
//        return memer;
//    }
//
//    @Override
//    public Optional<Member> findByID(Long id) {
//        return Optional.ofNullable(store.get(id));
//    }
//
//    @Override
//    public Optional<Member> findByName(String name) {
//        return store.values().stream()
//                .filter(member->member.getName().equals(name))
//                .findAny();
//    }
//
//    @Override
//    List<Member> findAll() {
//        return new ArrayList<>(store.values());
//    }
//}
