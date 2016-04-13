package com.davidbalazs.chess.filters;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.MessageFormat;

public class ResponseTimeMeasurerFilter implements Filter {
    public static final Logger LOGGER = Logger.getLogger(ResponseTimeMeasurerFilter.class);

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long elapsed = System.currentTimeMillis() - startTime;

        String name = "servlet";
        if (request instanceof HttpServletRequest) {
            name = ((HttpServletRequest) request).getRequestURI();
        }

        LOGGER.info(MessageFormat.format("request {0} took {1} ms.", name, elapsed));
    }
}
