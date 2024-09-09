package com.KLBproject.KLB_project.security.config.LoggingConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
@Log
public class LoggingServiceImpl implements LoggingService {


//    @Override
//    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Map<String, String> parameters = buildParametersMap(httpServletRequest);
//
//        stringBuilder.append("REQUEST ");
//        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
//        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
//        stringBuilder.append("headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");
//
//        if (!parameters.isEmpty()) {
//            stringBuilder.append("parameters=[").append(parameters).append("] ");
//        }
//
//        if (body != null) {
//            stringBuilder.append("body=[" + body + "]");
//        }
//
//        log.info(stringBuilder.toString());
//    }
//
//    @Override
//    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
//        StringBuilder stringBuilder = new StringBuilder();
//
//        stringBuilder.append("RESPONSE ");
//        stringBuilder.append("method=[").append(httpServletRequest.getMethod()).append("] ");
//        stringBuilder.append("path=[").append(httpServletRequest.getRequestURI()).append("] ");
//        stringBuilder.append("responseHeaders=[").append(buildHeadersMap(httpServletResponse)).append("] ");
//        stringBuilder.append("responseBody=[").append(body).append("] ");
//
//
//
//        log.info(stringBuilder.toString());
//    }


    private static final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> parameters = buildParametersMap(httpServletRequest);

        stringBuilder.append("REQUEST ")
                .append("method=[").append(httpServletRequest.getMethod()).append("] ")
                .append("path=[").append(httpServletRequest.getRequestURI()).append("] ")
                .append("headers=[").append(buildHeadersMap(httpServletRequest)).append("] ");

        if (!parameters.isEmpty()) {
            stringBuilder.append("parameters=[").append(parameters).append("] ");
        }

        if (body != null) {
            try {
                stringBuilder.append("body=[")
                        .append(objectMapper.writeValueAsString(body)) // Pretty print JSON body
                        .append("]");
            } catch (Exception e) {
                stringBuilder.append("body=[error serializing body]");
            }
        }

        log.info(stringBuilder.toString());
    }

    @Override
    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("RESPONSE ")
                .append("method=[").append(httpServletRequest.getMethod()).append("] ")
                .append("path=[").append(httpServletRequest.getRequestURI()).append("] ")
                .append("responseHeaders=[").append(buildHeadersMap(httpServletResponse)).append("] ");

        if (body != null) {
            try {
                stringBuilder.append("responseBody=[")
                        .append(objectMapper.writeValueAsString(body)) // Pretty print JSON body
                        .append("]");
            } catch (Exception e) {
                stringBuilder.append("responseBody=[error serializing body]");
            }
        }

        log.info(stringBuilder.toString());
    }

    private Map<String, String> buildParametersMap(HttpServletRequest httpServletRequest) {
        Map<String, String> resultMap = new HashMap<>();
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            String value = httpServletRequest.getParameter(key);
            resultMap.put(key, value);
        }

        return resultMap;
    }

    private Map<String, String> buildHeadersMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

    private Map<String, String> buildHeadersMap(HttpServletResponse response) {
        Map<String, String> map = new HashMap<>();

        Collection<String> headerNames = response.getHeaderNames();
        for (String header : headerNames) {
            map.put(header, response.getHeader(header));
        }

        return map;
    }
}