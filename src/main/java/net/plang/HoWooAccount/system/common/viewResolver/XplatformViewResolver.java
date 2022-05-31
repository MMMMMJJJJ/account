package net.plang.HoWooAccount.system.common.viewResolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class XplatformViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        System.out.println("xpaltformviewResolver 실행");
        return (map, httpServletRequest, httpServletResponse) -> {};
    }
}
