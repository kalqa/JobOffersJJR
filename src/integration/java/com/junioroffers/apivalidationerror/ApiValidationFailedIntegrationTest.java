package com.junioroffers.apivalidationerror;

import com.junioroffers.BaseIntegrationTest;
import com.junioroffers.infrastructure.apivalidation.ApiValidationErrorDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ApiValidationFailedIntegrationTest extends BaseIntegrationTest {

    @Test
    @WithMockUser
    public void should_return_400_bad_request_and_validation_message_when_empty_and_null_in_offer_save_request() throws Exception {
        // given & when
        ResultActions perform = mockMvc.perform(post("/offers")
                .content("""
                        {
                        "companyName": "",
                        "position": "",
                        "salary": ""
                        }
                        """)
                .contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
        );
        // then
        MvcResult mvcResult = perform.andExpect(status().isBadRequest()).andReturn();
        String json = mvcResult.getResponse().getContentAsString();
        ApiValidationErrorDto result = objectMapper.readValue(json, ApiValidationErrorDto.class);
        assertThat(result.messages()).containsExactlyInAnyOrder(
                "companyName must not be empty",
                "position must not be empty",
                "salary must not be empty",
                "offerUrl must not be null",
                "offerUrl must not be empty");
    }
}
