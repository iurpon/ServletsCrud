package ru.trandefil.sc.util;

import ru.trandefil.sc.model.User;

import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static void storeLoginUser(HttpSession session, User loginUser) {
        // На JSP можно получить доступ через ${loginUser}
        session.setAttribute("loginUser", loginUser);
    }

    // Получить информацию пользователя, сохраненную в Session.
    public static User getLoginUser(HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        return loginUser;
    }

}
