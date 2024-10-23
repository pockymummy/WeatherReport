package com.example.demo.weatherreport.supplierapi;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.example.demo.DemoApplication.log;

public class ClientLoggingInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request,body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) {
        StringBuilder builder = new StringBuilder();
        builder.append("Request raw: ");
        builder.append(request.getMethod());
        builder.append(" ");
        builder.append(request.getURI());
        log.info(builder.toString());
    }

    private void logResponse(ClientHttpResponse response) throws IOException {
        StringBuilder inputStringBuilder = new StringBuilder();
        inputStringBuilder.append("Response raw: ");
        InputStream responseStream = response.getBody();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseStream, "UTF-8"));
        String line = bufferedReader.readLine();
        while (line != null) {
            inputStringBuilder.append(line);
            inputStringBuilder.append('\n');
            line = bufferedReader.readLine();
        }
        log.info(inputStringBuilder.toString());
        responseStream.reset();
    }
}
