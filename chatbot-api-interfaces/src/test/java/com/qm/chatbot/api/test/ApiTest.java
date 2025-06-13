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


    @Test
    public void query_unanswered_questions_bi() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.bilibili.com/x/v2/reply/wbi/main?oid=354264365&type=11&mode=3&pagination_str=%7B%22offset%22:%22%22%7D&plat=1&seek_rpid=&web_location=1315875&w_rid=c897445bdcb78b9f1c9014a526717cb9&wts=1749794162");
        get.addHeader("cookie", "buvid_fp_plain=undefined; buvid4=BE0696BF-76A7-8069-B571-D38FAFB1C11B58020-022012614-jBG%2BtPos0hVtuGGjZp%2F2Og%3D%3D; enable_web_push=DISABLE; DedeUserID=352332489; DedeUserID__ckMd5=6dabd1f86a7384b0; header_theme_version=CLOSE; fingerprint=510b75e017ed58db64992618efcf251a; buvid_fp=032b7c75264cc7b27a4b0f581b29a70e; rpdid=0zbfAHBGCu|2JrZVhPF|PMC|3w1TJvKU; LIVE_BUVID=AUTO3017406597285029; PVID=2; enable_feed_channel=ENABLE; CURRENT_QUALITY=80; buvid3=3AEA6A72-D526-1ECD-418D-3819FDDE6D9580228infoc; b_nut=1748339480; _uuid=EB9E6CB2-A119-51F2-F766-E652AC994AC980476infoc; home_feed_column=5; browser_resolution=1536-730; SESSDATA=f30e4ba2%2C1765100972%2C28cbe%2A62CjBAIHEhuMWQhjk_8xThTt_6bhIvw9ZP7dzeRze4w_5T-0QTHubn4XDUyEjAzpwtdEkSVldTVHZXdnFRNmN0MEppZi1jSGlvTi0yeWtaaVEwVnpkeW96LVEzYUJSdmZPYklIdTlhbFdja2pIeWlOTTNjVVVsVGdCT0RGVzZ5dUNkNjd4MmRYRGR3IIEC; bili_jct=1b6d909225da168ace28fc8fbefbe93c; CURRENT_FNVAL=4048; sid=57ntuhjl; b_lsid=65992416_19767CBA78D; hit-dyn-v2=1; bili_ticket=eyJhbGciOiJIUzI1NiIsImtpZCI6InMwMyIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3NTAwNTMxNzQsImlhdCI6MTc0OTc5MzkxNCwicGx0IjotMX0.WkyvB14u-OK_lPsOsh-Joum2V07nQhaMJSSnzyTf3Tw; bili_ticket_expires=1750053114; bp_t_offset_352332489=1077845983078907904; dy_spec_agreed=1");
        get.addHeader("Content-Type", "*/*");
        get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36");

        HttpResponse response = httpClient.execute(get);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void answer_questions_bi() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8852421218542552/comments");
        // "https://api.zsxq.com/v2/topics/8852421218542552/comments"
        HttpPost post = new HttpPost("https://api.bilibili.com/x/v2/reply/add?dm_img_list=[%7B%22x%22:1797,%22y%22:487,%22z%22:0,%22timestamp%22:260218,%22k%22:115,%22type%22:0%7D,%7B%22x%22:2525,%22y%22:1201,%22z%22:57,%22timestamp%22:260319,%22k%22:96,%22type%22:0%7D,%7B%22x%22:2677,%22y%22:1348,%22z%22:155,%22timestamp%22:260420,%22k%22:112,%22type%22:0%7D,%7B%22x%22:2588,%22y%22:1217,%22z%22:54,%22timestamp%22:260647,%22k%22:109,%22type%22:0%7D,%7B%22x%22:2614,%22y%22:949,%22z%22:134,%22timestamp%22:260747,%22k%22:65,%22type%22:0%7D,%7B%22x%22:2605,%22y%22:-1266,%22z%22:165,%22timestamp%22:260847,%22k%22:122,%22type%22:0%7D,%7B%22x%22:2685,%22y%22:-1690,%22z%22:147,%22timestamp%22:260948,%22k%22:96,%22type%22:0%7D,%7B%22x%22:3189,%22y%22:-1495,%22z%22:635,%22timestamp%22:261050,%22k%22:80,%22type%22:0%7D,%7B%22x%22:3107,%22y%22:-1595,%22z%22:584,%22timestamp%22:261150,%22k%22:114,%22type%22:0%7D,%7B%22x%22:2630,%22y%22:-2034,%22z%22:131,%22timestamp%22:261250,%22k%22:78,%22type%22:0%7D,%7B%22x%22:2709,%22y%22:-1951,%22z%22:221,%22timestamp%22:261353,%22k%22:67,%22type%22:0%7D,%7B%22x%22:2985,%22y%22:-1700,%22z%22:503,%22timestamp%22:261454,%22k%22:60,%22type%22:0%7D,%7B%22x%22:3325,%22y%22:-1360,%22z%22:843,%22timestamp%22:261555,%22k%22:125%7D,%7B%22x%22:3588,%22y%22:-896,%22z%22:549,%22timestamp%22:263077,%22k%22:75,%22type%22:0%7D,%7B%22x%22:4133,%22y%22:-150,%22z%22:1158,%22timestamp%22:263177,%22k%22:79,%22type%22:0%7D,%7B%22x%22:3808,%22y%22:777,%22z%22:1217,%22timestamp%22:263277,%22k%22:123,%22type%22:0%7D,%7B%22x%22:2621,%22y%22:479,%22z%22:307,%22timestamp%22:263377,%22k%22:79,%22type%22:0%7D,%7B%22x%22:3282,%22y%22:1420,%22z%22:1186,%22timestamp%22:263477,%22k%22:91,%22type%22:0%7D,%7B%22x%22:3634,%22y%22:1959,%22z%22:1667,%22timestamp%22:263577,%22k%22:121,%22type%22:0%7D,%7B%22x%22:2223,%22y%22:561,%22z%22:263,%22timestamp%22:263677,%22k%22:115%7D]&dm_img_str=V2ViR0wgMS4wIChPcGVuR0wgRVMgMi4wIENocm9taXVtKQ&dm_cover_img_str=QU5HTEUgKE5WSURJQSwgTlZJRElBIEdlRm9yY2UgR1RYIDE2NTAgKDB4MDAwMDFGOTEpIERpcmVjdDNEMTEgdnNfNV8wIHBzXzVfMCwgRDNEMTEpR29vZ2xlIEluYy4gKE5WSURJQS&dm_img_inter=%7B%22ds%22:[%7B%22t%22:0,%22c%22:%22%22,%22p%22:[83,19,651],%22s%22:[180,3148,384]%7D],%22wh%22:[2843,1911,25],%22of%22:[1217,1944,482]%7D&w_rid=bd22e64992a5d25980604bccf95d15d5&wts=1749795266");
        post.addHeader("cookie", "sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTk3NWEyZDY3YzMxOC0wYmRkMDYxYzNiZDZiNC0yNjAxMWY1MS0xMzI3MTA0LTE5NzVhMmQ2N2M0ZTZiIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%22%2C%22value%22%3A%22%22%7D%2C%22%24device_id%22%3A%221975a2d67c318-0bdd061c3bd6b4-26011f51-1327104-1975a2d67c4e6b%22%7D; zsxq_access_token=B8497488-4AE6-4389-9BE8-ED0BC9258CAE_7E14FE8828A35782; abtest_env=beta");
        post.addHeader("Content-Type", "application/json, text/plain, */*");

        String paramJson = "plat=1&oid=354264365&type=11&message=test333&at_name_to_mid=%7B%7D&gaia_source=main_web&csrf=1b6d909225da168ace28fc8fbefbe93c&statistics=%7B%22appId%22:100,%22platform%22:5%7D";

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
