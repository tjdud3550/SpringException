package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements
        WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/errorpage/404");
        //에러 페이지 생성 스프링 부트가 제공
        ErrorPage errorPage500 = new
                ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");

       //500 에러페이지 생성
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/errorpage/500");
        factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
        //생성된 에러 등록

    }
}
