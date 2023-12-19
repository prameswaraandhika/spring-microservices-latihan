    package com.prameswaradev.OrderService.external.decoder;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.prameswaradev.OrderService.exception.CustomException;
    import feign.Response;
    import feign.codec.ErrorDecoder;
    import lombok.extern.slf4j.Slf4j;

    import java.io.IOException;
    @Slf4j
    public class CustomErrorDecoder implements ErrorDecoder {

        @Override
        public Exception decode(String s, Response response) {
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("Response URL: {}", response.request().url());
            log.info("Response Headers: {}", response.request().headers());

            try {
                if (response.body() != null) {
                    CustomException customException = objectMapper.readValue(response.body().asInputStream(), CustomException.class);
                    customException.setStatus(response.status());
                    return customException;
                } else {
                    // Handle null response body
                    log.error("Null response body received.");
                    return new RuntimeException("Null response body received.");
                }
            } catch (IOException e) {
                // Handle IOException
                log.error("Error reading response body: {}", e.getMessage());
                return new RuntimeException("Error reading response body.", e);
            } catch (RuntimeException e) {
                // Handle other runtime exceptions
                log.error("Runtime exception: {}", e.getMessage());
                return e;
            }
        }
    }

