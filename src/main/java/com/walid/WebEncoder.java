package com.walid;

import com.walid.util.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A sample class that acts as a REST client encoding the GET response using ROT13 algorithm.
 * The class is tested using JUnit and Mockito
 */
@Component
public class WebEncoder {

    private static final Logger log = LoggerFactory.getLogger(WebEncoder.class);

    @Autowired
    private HttpClient httpClient;

    public String getEncodedResponse(String url) {
        return encodeText(requestResponse(url));
    }

    private String requestResponse(String url) {
        log.info("Connecting to url: {}", url);
        String response = httpClient.get(url);
        log.info("Retrieved response from URL [{}] is [{}]", url, response);
        return response;
    }

    private String encodeText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        log.info("Encoding text: {}", text);

        StringBuilder stringBuilder = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            stringBuilder.append(c);
        }
        String encodedText = stringBuilder.toString();
        log.info("Encoded text: {}", encodedText);
        return encodedText;
    }
}
