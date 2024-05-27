package member.dao;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import member.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository //controller와 component와 똑같음=>자동으로 xml파일에 등록시켜줌
@RequiredArgsConstructor
public class MemberDao {
    //@Autowired //AUTOCONTEXT에 자동으로 등록되게 세팅되어 있기 때문에 자동 주입되게 해준다
    @NonNull
    private SqlSession session;
    private String namespace="member.dao.MemberDao.";
    public int getTotalCount(){
        return session.selectOne(namespace+"memberTotalCount");
    }

    public int getSearchId(String searchid){
        return session.selectOne(namespace+"selectIdCheck",searchid); //searchid가 memberMapper에 있는 아이디랑 똑같아야 함
    }
    public void insertMember(MemberDto dto){
        session.insert(namespace+"insertMember",dto);
    }

    public List<MemberDto> getAllMembers(){
        return session.selectList(namespace+"selectAllMembers");
    }

    public MemberDto getData(int num){
        return session.selectOne(namespace+"selectByNumData",num);
    }

    public void updatePhoto(Map<String, Object> map){
        session.update(namespace+"updatePhoto",map);
    }
    public void updateMember(MemberDto dto){
        session.update(namespace+"updateMember",dto);
    }

    public boolean isEqualPassCheck(Map<String, Object> map){
        int n=session.selectOne(namespace+"equalPassCheck",map);
        return n==1?true:false; //1이면 비번이 맞은 경우로 true 반환
    }

    public void deleteMember(int num){
        session.delete(namespace+"deleteMember",num);
    }
}
