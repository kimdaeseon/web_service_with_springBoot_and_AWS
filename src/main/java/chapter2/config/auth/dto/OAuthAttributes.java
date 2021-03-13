package chapter2.config.auth.dto;

import chapter2.domain.user.Role;
import chapter2.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email, String picture){
        this.attributes = attributes;
        this.name = name;
        this.nameAttributeKey = nameAttributeKey;
        this.email = email;
        this.picture = picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){
        System.out.print(1);
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        System.out.print(2);
        return OAuthAttributes.builder().name((String) attributes.get("name")).email((String) attributes.get("email"))
                .picture((String) attributes.get("picture")).attributes(attributes).nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity(){
        System.out.print(3);
        return User.builder().name(name).email(email).picture(picture).role(Role.GUEST).build();
    }
}
