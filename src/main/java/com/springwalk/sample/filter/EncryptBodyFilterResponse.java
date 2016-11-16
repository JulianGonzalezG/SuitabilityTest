package com.springwalk.sample.filter;

import com.springwalk.sample.wrapper.HtmlResponseWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jgonzalezg on 10/11/2016.
 */

public class EncryptBodyFilterResponse implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        HtmlResponseWrapper capturingResponseWrapper = new HtmlResponseWrapper(
                (HttpServletResponse) response);

        System.out.println("INTERCEPTO RESPONSE");
        System.out.println("Capturo: "+response);
        System.out.println(capturingResponseWrapper.getHeader("Date"));
        System.out.println(request.getContentType());



        if (response.getContentType() != null
                && response.getContentType().contains("application/json")) {

            String content = capturingResponseWrapper.getCaptureAsString();
            System.out.println("Capturo: "+content);

            // replace stuff here
          /*  String replacedContent = content.replaceAll(
                    "<h2[^>]*>(.*?)</h2>",
                    "<h3>$1 - HTML replaced</h3>");*/
            //String replacedContent = "INTERCEPTO RESPONSE";

            //System.out.println(replacedContent);
            //response.getWriter().write(replacedContent);
            //response.setContentLength(replacedContent.length());

        }
        filterChain.doFilter(request, response);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
