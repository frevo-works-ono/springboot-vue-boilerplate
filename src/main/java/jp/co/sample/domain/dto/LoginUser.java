package jp.co.sample.domain.dto;

import org.springframework.security.core.authority.AuthorityUtils;

import jp.co.sample.domain.model.User;
import lombok.Getter;

public class LoginUser extends org.springframework.security.core.userdetails.User {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Getter
    private Integer userId;

    @Getter
    private String userName;

    /*
     * コンストラクタ
     * 
     * @param user
     */
    public LoginUser(User user) {
        // スーパークラスのユーザーID、パスワードに値をセットする
        // 実際の認証はスーパークラスのユーザーID、パスワードで行われる
        super(user.getMailaddress(), user.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }
}
