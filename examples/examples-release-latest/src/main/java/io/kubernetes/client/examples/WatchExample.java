///*
//Copyright 2020 The Kubernetes Authors.
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//http://www.apache.org/licenses/LICENSE-2.0
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
//*/
//package io.kubernetes.client.examples;
//
//import com.google.gson.reflect.TypeToken;
//import io.kubernetes.client.openapi.ApiClient;
//import io.kubernetes.client.openapi.ApiException;
//import io.kubernetes.client.openapi.Configuration;
//import io.kubernetes.client.openapi.apis.CoreV1Api;
//import io.kubernetes.client.openapi.models.V1Namespace;
//import io.kubernetes.client.util.Config;
//import io.kubernetes.client.util.Watch;
//import okhttp3.OkHttpClient;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
///** A simple example of how to use Watch API to watch changes in Namespace list. */
//public class WatchExample {
//  public static void main(String[] args) throws IOException, ApiException {
//    ApiClient client = new ApiClient();
//    client.setBasePath("https://5302E4D20BD5556D8BE3B85E635F1DAE.gr7.ap-northeast-2.eks.amazonaws.com");
//    client.setApiKey("Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6InF5a2NsWElJMjNZTlNNRU03X3V4eERkd0NYcmZNbEhTZjZnb2gyQXFvYlkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImNsb2l0LWRldi1zZWNyZXQiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiY2xvaXQtZGV2LXNhIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQudWlkIjoiY2U1MzVlMWYtNzM1ZC00YjVjLTk0MTAtZTRlMDhjY2RjY2QzIiwic3ViIjoic3lzdGVtOnNlcnZpY2VhY2NvdW50OmRlZmF1bHQ6Y2xvaXQtZGV2LXNhIn0.olP2AXIFQ0OydTWNPr_PMBUqVVAMmCwqPZXMpkSQI7jGl65MDDMioovk4-t9prxAhN0ZbTJ4hAeKuD7UvuvNy3AHj5qXDpZ80e7NoZIAIKXqmN_IxtSv9bkU3cwbH5V-yocGVj_oBm8Ok0LuTXPLO0NYlo5gbt8nJdBNCBhGTqOnLgjpARwJV6I2xuOTft4Zbs-CGbO7aYd4_e_drBIz8jdI_lEtB7JnydS_3zzUlOKGya2ZiEfxN-gXrherBuvvDRPT7GaG4Aj9HLaNLTl0Hz8staKUvshhJuE4WjKuCilILSL1D2mE0TPS3BBBP0BSXFRKiHsarZndo5L7Z-0VxQ");
//    client.setVerifyingSsl(false);
//    // infinite timeout
//    OkHttpClient httpClient =
//        client.getHttpClient().newBuilder().readTimeout(0, TimeUnit.SECONDS).build();
//    client.setHttpClient(httpClient);
//    Configuration.setDefaultApiClient(client);
//
//    CoreV1Api api = new CoreV1Api();
//
//    Watch<V1Namespace> watch =
//        Watch.createWatch(
//            client,
//            api.listNamespace()
//                    .watch(true)
//                    .buildCall(null),
//            new TypeToken<Watch.Response<V1Namespace>>() {}.getType());
//
//    try {
//      for (Watch.Response<V1Namespace> item : watch) {
//        System.out.printf("%s : %s%n", item.type, item.object.getMetadata().getName());
//      }
//    } finally {
//      watch.close();
//    }
//  }
//}
