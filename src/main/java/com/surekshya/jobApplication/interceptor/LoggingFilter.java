//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//import java.util.stream.Collectors;
//
//@Component
//public class LoggingFilter implements Filter {
//
//    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        if ("POST".equalsIgnoreCase(httpServletRequest.getMethod())) {
//            CachedBodyHttpServletRequest wrappedRequest = new CachedBodyHttpServletRequest(httpServletRequest);
//            String body = wrappedRequest.getBody();
//            logger.info("Request Body: {}", body);
//            chain.doFilter(wrappedRequest, response);
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//    private static class CachedBodyHttpServletRequest extends HttpServletRequestWrapper {
//        private final String body;
//
//        public CachedBodyHttpServletRequest(HttpServletRequest request) throws IOException {
//            super(request);
//            StringBuilder stringBuilder = new StringBuilder();
//            try (BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    stringBuilder.append(line);
//                }
//            }
//            this.body = stringBuilder.toString();
//        }
//
//        public String getBody() {
//            return body;
//        }
//    }
//}
