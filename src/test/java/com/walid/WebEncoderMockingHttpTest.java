package com.walid;

import com.walid.util.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WebEncoderMockingHttpTest {

    @Mock
    private HttpClient httpClient;

    @InjectMocks
    private WebEncoder webEncoder;

    @Before
    public void setUp() throws Exception {
        webEncoder = new WebEncoder();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEncodedResponseMockingRemoteServer() {

        String testQoute = "So easy it is to switch container in #springboot.";
        String testQouteEncoded = "Fb rnfl vg vf gb fjvgpu pbagnvare va #fcevatobbg.";

        // instruct the mock to respond to GET requests with the test quote.
        when(httpClient.get(anyString()))
                .thenReturn(testQoute);

        String encodedResponse = webEncoder.getEncodedResponse("http://whatever....");

        assertThat(encodedResponse, equalTo(testQouteEncoded));
    }
}