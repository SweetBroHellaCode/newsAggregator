package io.zipcoder;

import com.buzzilla.webhose.client.WebhoseClient;
import com.buzzilla.webhose.client.WebhosePost;

import java.io.IOException;

/**
 * Created by BatComputer on 12/1/15.
 */
public class webhoseSDKTester {
    public void webhostTest() {
        WebhoseClient client = new WebhoseClient("5730ee2a-881e-4d01-94ef-313e25a214f6");
        try {
            for(WebhosePost post : client.search("cnn").posts){
                System.out.println(post.title);
                System.out.println(post.text);
                System.out.println(post.ordInThread);
                System.out.println(post.thread.country);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
