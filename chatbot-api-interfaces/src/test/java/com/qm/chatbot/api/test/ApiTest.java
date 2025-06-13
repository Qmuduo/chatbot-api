package com.qm.chatbot.api.test;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @program: chatbot-api
 * @description:
 * @author: ZhangQingMin
 * @create: 2025-06-12 20:35
 **/
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/topics/8852421218542552/comments?sort=asc&count=30&with_sticky=true");
        get.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk3NWEyZDY3YzMxOC0wYmRkMDYxYzNiZDZiNC0yNjAxMWY1MS0xMzI3MTA0LTE5NzVhMmQ2N2M0ZTZiIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%7D; zsxq_access_token=B8497488-4AE6-4389-9BE8-ED0BC9258CAE_7E14FE8828A35782; abtest_env=beta\n");
        get.addHeader("Content-Type", "application/json, text/plain, */*");

        HttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer_questions() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8852421218542552/comments");
        // "https://api.zsxq.com/v2/topics/8852421218542552/comments"

        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk3NWEyZDY3YzMxOC0wYmRkMDYxYzNiZDZiNC0yNjAxMWY1MS0xMzI3MTA0LTE5NzVhMmQ2N2M0ZTZiIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%7D; zsxq_access_token=B8497488-4AE6-4389-9BE8-ED0BC9258CAE_7E14FE8828A35782; abtest_env=beta");
        post.addHeader("Content-Type", "application/json");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"简单的回答444\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }


    }
}
