package hello.login.domain.login;

import hello.login.web.member.Member;
import hello.login.web.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepository memberRepository;

	/**
	 * @return null 이면 로그인 실패
	 */
	public Member login(String loginId, String password) {
/*		Optional<Member> findMemberOptional = memberRepository.findByLongId(loginId);
		Member member = findMemberOptional.get();
		if (member.getPassword().equals(password)) {
			return member;
		} else {
			return null;
		}*/

		return memberRepository.findByLongId(loginId)
				.filter(m -> m.getPassword().equals(password))
				.orElse(null);
	}
}
