package com.springwalk.sample.filter;

import com.springwalk.sample.wrapper.HtmlRequestWrapper;
import com.springwalk.sample.wrapper.HtmlResponseWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jgonzalezg on 10/11/2016.
 */

public class EncryptBodyFilterRequest implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("INTERCEPTO REQUEST");
        HtmlRequestWrapper capturingRequestWrapper = new HtmlRequestWrapper(
                (HttpServletRequest) request);
        System.out.println(capturingRequestWrapper.getHeader("Date"));
        System.out.println(request.getContentType());



        if (response.getContentType() == null && request.getContentType() != null
                && request.getContentType().contains("application/json")) {

            System.out.println("ENTRO NO NULL REQUEST");
            String content = org.apache.commons.io.IOUtils.toString(capturingRequestWrapper.getReader());
            System.out.println("Capturo: "+content);

            // replace stuff here
          /*  String replacedContent = content.replaceAll(
                    "<h2[^>]*>(.*?)</h2>",
                    "<h3>$1 - HTML replaced</h3>");*/


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
