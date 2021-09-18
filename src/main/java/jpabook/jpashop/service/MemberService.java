package jpabook.jpashop.service;


import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional//db에 저장하기위해서 꼭 필요하다 , 스프링에서 제공되는것 사용하기
@RequiredArgsConstructor //final이 있는 필드만 생성자로 잡아준다. 자동으로 autowired됨
public class MemberService {

    //@Autowired
    private final MemberRepository memberRepository;

    //회원가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); //중복회원 검증하는 로직
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //만약 이름이 같은 두명이 들어 올때는 소용이 없음 나중에 db에 unique제약 조건 걸기
        List<Member> findMembers=memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");

        }
    }
    //회원 전체 조회
    @Transactional(readOnly = true) //jpa가 조회시에는 성능을 최적화 해준다, 쓰기 작업에는 넣으면 안됨
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //회원 한건 조회
    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
