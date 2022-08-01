package api.constants;

public class UserConstants {


    public static final String DEFAULT_PATH = "userDetails/";
    public static final String GET_ALL_USERS = DEFAULT_PATH + "getUsersList";
    public static final String GET_USER_BY_ID = DEFAULT_PATH + "getUserById/{userId}";
    public static final String DELETE_USER_BY_ID = DEFAULT_PATH + "deleteUser/{userId}";
    public static final String CREATE_USER = DEFAULT_PATH + "saveUser";
    public static final String UPDATE_USER_BY_ID = DEFAULT_PATH + "updateUser/{userId}";
}
