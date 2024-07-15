package Bbashyan.utils;

import Bbashyan.model.user.User;
import lombok.Getter;
import lombok.Setter;

public class Session {
    @Getter
    @Setter
    private static User currentUser;

}
