package nextstep.auth.authentication.handler;

import nextstep.auth.authentication.AuthenticationException;
import nextstep.auth.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, Exception failed) throws IOException {
        SecurityContextHolder.clearContext();
        throw new AuthenticationException();
    }
}
