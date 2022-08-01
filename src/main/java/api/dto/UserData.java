package api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private Integer userID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean subscription;

}
